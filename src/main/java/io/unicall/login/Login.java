package io.unicall.login;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.unicall.utils.ShiroUtils;

@Controller
@RequestMapping("/login_controller")
public class Login {
	
	    @RequestMapping
	    public String yun(Map<String,Object> map){
//	       map.put("name", "匿名");
//	       return "freemarker";
	       return "/yun/index";
	    }
	    @RequestMapping("/UADF")
	    public String uadf(){
	    	//登出
	    	ShiroUtils.logout();
	    	//是否登录
	    	System.out.println(ShiroUtils.isLogin());
			return "redirect:/login_uadf.html";
	    }
	    @RequestMapping("/redirect")
		public String redirect(Map<String,Object> map,HttpServletResponse response) throws IOException{
	    	Subject subject = SecurityUtils.getSubject();
	    	if("io.unicall.entity.SysRegisterEntity".equals(subject.getPrincipal().getClass().getName())){
		    	map.put("name", ShiroUtils.getRegisterEntity().getMobile());
//			    return "freemarker";	   
			    return "/yun/index";	   
	    		
	    	}else
//	    		response.sendRedirect("/index_unicall.html");
	    	    return "redirect:/index_uadf.html";


		}
	    

}
