package io.yun.entity;

import java.io.Serializable;



/**
 * 供应商—会员表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-07-11 16:18:24
 */
public class TYunProviderVipEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String memberId;
	//
	private String providerId;
	//
	private String vipRank;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * 设置：
	 */
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	/**
	 * 获取：
	 */
	public String getProviderId() {
		return providerId;
	}
	/**
	 * 设置：
	 */
	public void setVipRank(String vipRank) {
		this.vipRank = vipRank;
	}
	/**
	 * 获取：
	 */
	public String getVipRank() {
		return vipRank;
	}
}
