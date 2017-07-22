package io.yun.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by sr.chen on 2017/6/28.
 */
@Component
public class FileUtils {

    private final static Logger logger = Logger.getLogger(FileUtils.class);

    @Autowired
    private Environment env;

    public String upload(MultipartFile f,String path) throws IOException {
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

