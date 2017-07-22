package io.yun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by chao.zhou on 2017/6/30.
 */
@Controller
@RequestMapping("/yun")
public class CommonController {
    @Autowired
    private Environment env;

    @RequestMapping(value = "/download", method = RequestMethod.GET)             //下载测试
    public void testDownload(HttpServletResponse res,String filePath,String filename) {
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + filename);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(env.getProperty("user.home")+filePath+filename)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile f,String path) throws IOException {           //上传测试
        //服务器地址
        String domain = env.getProperty("domain");
        String home = env.getProperty("user.home");
        String path2 = "/upload/"+path;
        File file = new File(home+path2+f.getOriginalFilename());
        if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
        f.transferTo(file);
        return domain+"/yun/download?filePath="+path2+"&filename="+f.getOriginalFilename();
    }
}
