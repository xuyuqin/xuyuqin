package io.yun.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 价格动态表
 * 
 * @author lankai
 * @email bq.zhu@unicall.com
 * @date 2017-06-30 10:56:33
 */
public class TYunPriceDynamicsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//
	private BigDecimal prePrice;
	//
	private BigDecimal postPrice;
	//
	private BigDecimal trend;
	//
	private Date scaleTime;
	//
	private String merchandiseId;

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
	 * 设置：
	 */
	public void setPrePrice(BigDecimal prePrice) {
		this.prePrice = prePrice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getPrePrice() {
		return prePrice;
	}
	/**
	 * 设置：
	 */
	public void setPostPrice(BigDecimal postPrice) {
		this.postPrice = postPrice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getPostPrice() {
		return postPrice;
	}
	/**
	 * 设置：
	 */
	public void setTrend(BigDecimal trend) {
		this.trend = trend;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getTrend() {
		return trend;
	}
	/**
	 * 设置：
	 */
	public void setScaleTime(Date scaleTime) {
		this.scaleTime = scaleTime;
	}
	/**
	 * 获取：
	 */
	public Date getScaleTime() {
		return scaleTime;
	}
	/**
	 * 设置：
	 */
	public void setMerchandiseId(String merchandiseId) {
		this.merchandiseId = merchandiseId;
	}
	/**
	 * 获取：
	 */
	public String getMerchandiseId() {
		return merchandiseId;
	}
}
