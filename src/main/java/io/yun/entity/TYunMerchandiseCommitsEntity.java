package io.yun.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 商品评价表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:31
 */
public class TYunMerchandiseCommitsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private String id;
	//评价人账号id
	private String memberId;
	//商品id
	private String merchandiseId;
	//订单id
	private String orderId;
	//评价内容
	private String commits;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//回复
	private String reply;

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
	 * 设置：评价人账号id
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：评价人账号id
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * 设置：商品id
	 */
	public void setMerchandiseId(String merchandiseId) {
		this.merchandiseId = merchandiseId;
	}
	/**
	 * 获取：商品id
	 */
	public String getMerchandiseId() {
		return merchandiseId;
	}
	/**
	 * 设置：订单id
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单id
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * 设置：评价内容
	 */
	public void setCommits(String commits) {
		this.commits = commits;
	}
	/**
	 * 获取：评价内容
	 */
	public String getCommits() {
		return commits;
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
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：回复
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}
	/**
	 * 获取：回复
	 */
	public String getReply() {
		return reply;
	}
}
