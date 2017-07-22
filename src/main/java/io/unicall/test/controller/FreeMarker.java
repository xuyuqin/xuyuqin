package io.unicall.test.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



	@Controller
	@RequestMapping("/freemarker")
	public class FreeMarker {
		

	    
	    @RequestMapping
	    public String freemarker(Map<String,Object> map){
	       map.put("name", "云材网");
	       return "freemarker";
	    }
	    @RequestMapping("/redirect")
		public String redirect(Map<String,Object> map,HttpServletResponse response) throws IOException{
	    	Subject subject = SecurityUtils.getSubject();
	    	if("io.unicall.entity.RegisterEntity".equals(subject.getPrincipal().getClass().getName())){
		    	map.put("name", "云材网已登录");
			    return "freemarker";	   
	    		
	    	}else
//	    		response.sendRedirect("/index_unicall.html");
	    	    return "redirect:/index_unicall.html";


		}
	    
	
	}


