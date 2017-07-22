package io.yun.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 供应商收藏
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-29 14:16:31
 */
public class TYunProviderCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private String id;
	//供应商id
	private String providerId;
	//用户ID
	private String memberId;
	//创建时间
	private Date createTime;

	/**
	 * 设置：id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：供应商id
	 */
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	/**
	 * 获取：供应商id
	 */
	public String getProviderId() {
		return providerId;
	}
	/**
	 * 设置：用户ID
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：用户ID
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
