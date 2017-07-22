package io.unicall.entity;

import java.io.Serializable;
import java.util.Date;

/*
 * @author maxellen
 * 
 * @date 2017-06-18 12:22:06
 * 
 */

public class SysRegisterEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	/**
	 * 用户ID
	 */
	private Long Id;
	
	/**
	 * 用户名
	 */
//	@NotBlank(message="用户名不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	
	
	/**
	 * 手机号
	 */
	private String mobile;
	
	/**
	 * 邮箱
	 */
//	@NotBlank(message="邮箱不能为空", groups = {AddGroup.class, UpdateGroup.class})
//	@Email(message="邮箱格式不正确", groups = {AddGroup.class, UpdateGroup.class})
	private String email;
	/**
	 * 密码
	 */
//	@NotBlank(message="密码不能为空", groups = AddGroup.class)
	private transient String password;
	

	private String avatar;

	private String qq;

	private int mobileVerified;	
	private int emailVerified;	
	private Date createTime;
	private Date updateTime;
	private String salt;
	private int isProvider;
	private String address;
	
	//会员等级
	private int level;

	/**
	 * 交易员
	 */
	private String trader;

	public String getTrader() {
		return trader;
	}
	public void setTrader(String trader) {
		this.trader = trader;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public int getMobileVerified() {
		return mobileVerified;
	}
	public void setMobileVerified(int mobileVerified) {
		this.mobileVerified = mobileVerified;
	}
	public int getEmailVerified() {
		return emailVerified;
	}
	public void setEmailVerified(int emailVerified) {
		this.emailVerified = emailVerified;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getIsProvider() {
		return isProvider;
	}
	public void setIsProvider(int isProvider) {
		this.isProvider = isProvider;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	

	
}