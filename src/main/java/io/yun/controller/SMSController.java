package io.yun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.unicall.utils.R;
import io.yun.service.SMSService;

@Controller
@RequestMapping("/yun")
public class SMSController {
	
	@Autowired 
	private SMSService smsService;
	
	 /**
     * 短信验证码
     * 
     */
    @ResponseBody
    @RequestMapping(value = "/verifyCode")
    public R verifyMobile(@RequestParam (name = "mobile") String mobile){
   	    if(smsService.sendVerifyCode(mobile)){
   	    	
   	    	return R.ok();
   	    }else{
   	    	return R.error("验证码发送失败");
   	    	
   	    }

    	
    	
    }

}
