package io.yun.entity;

import java.io.Serializable;
import java.math.BigDecimal;



/**
 * 订单—商品关系表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:31
 */
public class TYunOrderMerchandiseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//订单id
	private String orderId;
	//商品规格
	private String specificationId;
	//商品数量
	private int amount;
	//商品id
	private String orderMerchandiseId;
	//产品质量评星
	private BigDecimal qualityScore;
	//产品价格评星
	private BigDecimal priceScore;
	//客服服务评星
	private BigDecimal serviceScore;
	//评价
	private String comments;
	//商品价格
	private double price;

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
	 * 设置：商品规格
	 */
	public void setSpecificationId(String specificationId) {
		this.specificationId = specificationId;
	}
	/**
	 * 获取：商品规格
	 */
	public String getSpecificationId() {
		return specificationId;
	}
	/**
	 * 设置：商品数量
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * 获取：商品数量
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * 设置：商品id
	 */
	public void setOrderMerchandiseId(String orderMerchandiseId) {
		this.orderMerchandiseId = orderMerchandiseId;
	}
	/**
	 * 获取：商品id
	 */
	public String getOrderMerchandiseId() {
		return orderMerchandiseId;
	}
	/**
	 * 设置：产品质量评星
	 */
	public void setQualityScore(BigDecimal qualityScore) {
		this.qualityScore = qualityScore;
	}
	/**
	 * 获取：产品质量评星
	 */
	public BigDecimal getQualityScore() {
		return qualityScore;
	}
	/**
	 * 设置：产品价格评星
	 */
	public void setPriceScore(BigDecimal priceScore) {
		this.priceScore = priceScore;
	}
	/**
	 * 获取：产品价格评星
	 */
	public BigDecimal getPriceScore() {
		return priceScore;
	}
	/**
	 * 设置：客服服务评星
	 */
	public void setServiceScore(BigDecimal serviceScore) {
		this.serviceScore = serviceScore;
	}
	/**
	 * 获取：客服服务评星
	 */
	public BigDecimal getServiceScore() {
		return serviceScore;
	}
	/**
	 * 设置：评价
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * 获取：评价
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * 设置：商品价格
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * 获取：商品价格
	 */
	public double getPrice() {
		return price;
	}

}
