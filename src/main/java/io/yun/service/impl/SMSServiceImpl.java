package io.yun.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.unicall.dao.SysRegisterDao;
import io.yun.dao.TYunVerifyCodeDao;
import io.yun.entity.TYunVerifyCodeEntity;
import io.yun.service.SMSService;

@Service("SMSService")
public class SMSServiceImpl implements SMSService {
	
	
	@Autowired
	private TYunVerifyCodeDao verifyCodeDao;
	@Autowired
	private TYunVerifyCodeDao tYunVerifyCodeDao;
	@Autowired
	private SysRegisterDao registerDao;
	
	

	@Override
	public boolean sendVerifyCode(String phone){
		CloseableHttpResponse response = null;
		
		String returncode = null;
		String code = genCode();
	    String message = "【云材网】您本次操作的验证码是:"+code;
	    response = send(phone, message);	 
	
			try {
				returncode = EntityUtils.toString(response.getEntity());
			} catch (ParseException | IOException e) {
		
				e.printStackTrace();
			}
	    if(returncode != null && "00".equals(returncode)){
		    TYunVerifyCodeEntity verifyCode = new TYunVerifyCodeEntity(phone, code);
		    verifyCodeDao.save(verifyCode);
		    return true;
		    
	    }else{
	    	return false;
	    	
	    }

	}

	@Override
	public String genCode() {
		 return RandomStringUtils.randomNumeric(6);
	}

		
	
	
	@Override
	public CloseableHttpResponse send(String phoneNumber, String message) {
		
		String url="http://q.hl95.com:8061/";
		String epid="121727";
		String username="jhxx";
		String password="2e5890c9c851631f20446cce683e8a5b";

		
		CloseableHttpClient client = HttpClients.createDefault();
		String encodedContent = null;
		try {
			encodedContent = URLEncoder.encode(message, "GB2312");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		StringBuffer strBuf = new StringBuffer(url);
		strBuf.append("?username=").append(username);
		strBuf.append("&password=").append(password);
		strBuf.append("&phone=").append(phoneNumber);
		strBuf.append("&message=").append(encodedContent);
		strBuf.append("&epid=").append(epid);
		strBuf.append("&linkid=").append("");
		strBuf.append("&subcode=").append("");

		HttpGet get = new HttpGet( strBuf.toString() );
		
		try {
			
			return client.execute(get);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
}

	@Override
	public boolean checkVerifyCode(String mobile,String verifyCode) {
		TYunVerifyCodeEntity vc = tYunVerifyCodeDao.queryByMobileAndVerifyCode(mobile, verifyCode);
		if(vc!=null){
			return DateTime.now().isBefore(new DateTime(vc.getExpire()).plusMinutes(30));
		
		}
		return false;
	}

	@Override
	public boolean isRegisted(String mobile) {
		if(null!=registerDao.queryObject(mobile)){    //t通过registerDao.queryObject对手机号是否已经存在于数据库
			return false;
			
		}else
			return true;
		
	}
}
