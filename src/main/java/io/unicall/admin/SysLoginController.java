package io.unicall.admin;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

import io.unicall.entity.SysUserEntity;
import io.unicall.entity.UsernamePasswordUsertypeToken;
import io.unicall.utils.R;
import io.unicall.utils.ShiroUtils;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登录相关
 * 
 * @author unicall
 * 
 * @date 2016年11月10日 下午1:15:31
 */
@Controller
public class SysLoginController {
	@Autowired
	private Producer producer;

	
	@RequestMapping("captcha.jpg")
	public void captcha(HttpServletResponse response)throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
		out.flush();
	}
	
	/**
	 * 登录
//	 */
	@ResponseBody
	@RequestMapping(value = "/sys/login", method = RequestMethod.POST)
//	public R login(String username, String password, String captcha)throws IOException {
	public R login(@ModelAttribute SysUserEntity user, String captcha)throws IOException {
		String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
		if(!captcha.equalsIgnoreCase(kaptcha)){
			return R.error("验证码不正确");
		}
		
		try{
			//通过ShiroUtils工具类，获取当前的用户
			Subject subject = ShiroUtils.getSubject();
			
			//sha256加密
			String password = new Sha256Hash(user.getPassword()).toHex();
			//收集用户身份和证明
//			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			UsernamePasswordToken token = new UsernamePasswordUsertypeToken(user.getUsername(), password,"1");
			
	
			//提交认证
			subject.login(token);
			//记住我
			token.setRememberMe(true);
		}catch (UnknownAccountException e) {
			return R.error(e.getMessage());
		}catch (IncorrectCredentialsException e) {
			return R.error(e.getMessage());
		}catch (LockedAccountException e) {
			return R.error(e.getMessage());
		}catch (AuthenticationException e) {
			return R.error("账户验证失败");
		}
	    
		return R.ok();
	}
	
	
	
	
	
	/**
	 * 退出
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		ShiroUtils.logout();
		return "redirect:login_uadf.html";
	}
	

	
}