package io.yun.controller;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import io.unicall.entity.SysRegisterEntity;
import io.unicall.entity.UsernamePasswordUsertypeToken;
import io.unicall.service.SysRegisterService;
import io.unicall.utils.R;
import io.unicall.utils.ShiroUtils;

import io.unicall.utils.validator.ValidatorUtils;
import io.unicall.utils.validator.group.AddGroup;
import io.yun.service.SMSService;

import java.io.IOException;
import java.util.Map;


@Controller
@RequestMapping("/yun")
public class LoginController {
	
	
	
	@Autowired
	private SysRegisterService registerService;

	@Autowired 
	private SMSService smsService;
	
    @RequestMapping("/index")
    public String freemarker(Map<String,Object> map){
        map.put("name", "云材网");
        return "yun/index";
    }
    
	/**
	 * 注册用户
	 */
    @ResponseBody
	@RequestMapping(value = "/regist")
	public R regist( @ModelAttribute SysRegisterEntity register, String verifyCode){

		ValidatorUtils.validateEntity(register, AddGroup.class);    //验证注册信息是否正确，是否注册过等供能
		
		if(smsService.checkVerifyCode(register.getMobile(), verifyCode)){       //y验证手机号与验证码是否匹配
			 registerService.save(register);    //注册信息
			 return R.ok();      //返回注册成功信息
		}else{
			return R.error("输入的验证码不正确或已超时");   //返回注册失败信息
		   
		}
	}
    /**
     * 修改密码
     */
    @ResponseBody
    @RequestMapping(value = "/modifyPW")
    public R modifyPW( @ModelAttribute SysRegisterEntity register, String verifyCode){
 
    	
    	if(smsService.checkVerifyCode(register.getMobile(), verifyCode)){     //y验证手机号和验证码
    		registerService.updatePW(register);                              //修改
    		return R.ok();
    	}else{
    		return R.error("输入的验证码不正确或已超时");
    		
    	}
    }

	
    /**
     * 登录
     * 
     */
    @ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public R login(String username, String password)throws IOException {
    	
    	//通过ShiroUtils工具类，获取当前的用户
    	Subject subject = ShiroUtils.getSubject();   //获取加密信息类实例
		try{
			//sha256加密
			password = new Sha256Hash(password).toHex();  //对登陆密码进行加密
			//收集用户身份和证明
//			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			UsernamePasswordToken token = new UsernamePasswordUsertypeToken(username, password,"2");     //收集用户信息和证明

			//提交认证
			subject.login(token);    //对登陆信息进行认证
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

		return R.ok().put("name",  ShiroUtils.getRegisterEntity().getMobile());
	}
    
   
    /**
     * 是否注册
     * 
     */
    @ResponseBody
    @RequestMapping(value = "/isRegisted")
    public R isRegisted(@RequestParam (name = "mobile") String mobile){
    	if(smsService.isRegisted(mobile)){       //使用SMSService对注册进行验证，service层上
    		return R.ok();
    		
    	}else
    	    return R.error("号码已注册");
    	
    }
    
    
	/**
	 * 退出
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		ShiroUtils.logout();    //将ShiroUtil中的记录清除
		return "redirect:/yuncai/index";
	}
    
    
    
}


