package io.yun.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 营销（活动）表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-07-07 11:07:41
 */
public class TYunMarketingEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//活动名称
	private String name;
	//活动内容
	private int marketingType;
	//折扣
	private BigDecimal discount;
	//满金额
	private BigDecimal fulfilAmount;
	//减免金额
	private BigDecimal reduceAmount;
	//
	private String providerId;
	//
	private Date createTime;
	//
	private Date updateTime;
	//
	private String status;
	//
	private Date startTime;
	//
	private Date endTime;
	//参加商品ID
	private String merchandiseIds;
	//参加商品名称
	private String merchandiseNames;

	public String getMerchandiseIds() {
		return merchandiseIds;
	}

	public void setMerchandiseIds(String merchandiseIds) {
		this.merchandiseIds = merchandiseIds;
	}

	public String getMerchandiseNames() {
		return merchandiseNames;
	}

	public void setMerchandiseNames(String merchandiseNames) {
		this.merchandiseNames = merchandiseNames;
	}

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
	 * 设置：活动名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：活动名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：活动内容
	 */
	public void setMarketingType(int marketingType) {
		this.marketingType = marketingType;
	}
	/**
	 * 获取：活动内容
	 */
	public int getMarketingType() {
		return marketingType;
	}
	/**
	 * 设置：折扣
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	/**
	 * 获取：折扣
	 */
	public BigDecimal getDiscount() {
		return discount;
	}
	/**
	 * 设置：满金额
	 */
	public void setFulfilAmount(BigDecimal fulfilAmount) {
		this.fulfilAmount = fulfilAmount;
	}
	/**
	 * 获取：满金额
	 */
	public BigDecimal getFulfilAmount() {
		return fulfilAmount;
	}
	/**
	 * 设置：减免金额
	 */
	public void setReduceAmount(BigDecimal reduceAmount) {
		this.reduceAmount = reduceAmount;
	}
	/**
	 * 获取：减免金额
	 */
	public BigDecimal getReduceAmount() {
		return reduceAmount;
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
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：
	 */
	public Date getEndTime() {
		return endTime;
	}
}
