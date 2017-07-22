package io.yun.service;

import org.apache.http.client.methods.CloseableHttpResponse;

public interface SMSService {
	String genCode();
	CloseableHttpResponse send(String phone, String message);
	boolean sendVerifyCode(String phone);
	boolean isRegisted(String phone);
	
	boolean checkVerifyCode(String mobile,String verifycode);

}
