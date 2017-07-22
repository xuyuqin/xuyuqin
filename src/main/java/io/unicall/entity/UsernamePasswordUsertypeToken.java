package io.unicall.entity;

import java.io.Serializable;

import org.apache.shiro.authc.UsernamePasswordToken;

/*
 * @author maxellen
 * 
 * @date 2017-06-17 13:42:06
 * 
 */

public class UsernamePasswordUsertypeToken extends UsernamePasswordToken implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private String usertype;
	
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public UsernamePasswordUsertypeToken(String loginName, String password, String usertype){
		
		super(loginName, password);
		this.usertype = usertype;
	}
	
	

}
