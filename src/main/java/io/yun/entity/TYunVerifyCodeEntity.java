package io.yun.entity;

import java.util.Date;

import org.joda.time.DateTime;

public class TYunVerifyCodeEntity {
	
	  private String id;
	  private String phone;
	  private String code;
	  private Date expire;
	
	public String getId() {
		return id;
	}
	public TYunVerifyCodeEntity(String id, String phone, String code, Date expire) {
		this.id = id;
		this.phone = phone;
		this.code = code;
		this.expire = expire;
	}
	public TYunVerifyCodeEntity() {
		super();
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getExpire() {
		return expire;
	}
	public void setExpire(Date expire) {
		this.expire = expire;
	}

	public TYunVerifyCodeEntity(String phone, String code) {
	    this.phone = phone;
	    this.code = code;
	    this.expire = DateTime.now().plusMinutes(30).toDate();
	}
	  
	  

}
