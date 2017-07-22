package io.yun.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 会员表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-20 16:58:14
 */
public class TYunMemberEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//姓名
	private String name;
	//手机号
	private String mobile;
	//邮箱
	private String email;
	//密码
	private String password;
	//头像
	private String avatar;
	//
	private String qq;
	//手机验证：0 未验证，1 已验证
	private Integer mobileVerified;
	//邮箱验证：0 未验证，1 已验证
	private Integer emailVerified;
	//注册时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//盐
	private String salt;
	//是否是提供商
	private int isProvider;
	//住址
	private String address;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：头像
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * 获取：头像
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * 设置：
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	/**
	 * 获取：
	 */
	public String getQq() {
		return qq;
	}
	/**
	 * 设置：手机验证：0 未验证，1 已验证
	 */
	public void setMobileVerified(Integer mobileVerified) {
		this.mobileVerified = mobileVerified;
	}
	/**
	 * 获取：手机验证：0 未验证，1 已验证
	 */
	public Integer getMobileVerified() {
		return mobileVerified;
	}
	/**
	 * 设置：邮箱验证：0 未验证，1 已验证
	 */
	public void setEmailVerified(Integer emailVerified) {
		this.emailVerified = emailVerified;
	}
	/**
	 * 获取：邮箱验证：0 未验证，1 已验证
	 */
	public Integer getEmailVerified() {
		return emailVerified;
	}
	/**
	 * 设置：注册时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：注册时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：盐
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * 获取：盐
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * 设置：是否是提供商
	 */
	public void setIsProvider(int isProvider) {
		this.isProvider = isProvider;
	}
	/**
	 * 获取：是否是提供商
	 */
	public int getIsProvider() {
		return isProvider;
	}
	/**
	 * 设置：住址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：住址
	 */
	public String getAddress() {
		return address;
	}
}
