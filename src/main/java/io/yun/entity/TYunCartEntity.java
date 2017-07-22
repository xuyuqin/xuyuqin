package io.yun.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 购物车表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:32
 */
public class TYunCartEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//用户id
	private String memberId;
	//商品id
	private String merchandiseId;
	//供应商id
	private String providerId;
	//商品数量
	private BigDecimal amount;
	//加入时间
	private Date addTime;
	//商品单价
	private BigDecimal price;
	//商品规格
	private String specificationId;

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
	 * 设置：用户id
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：用户id
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
	 * 设置：商品数量
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：商品数量
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * 设置：加入时间
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：加入时间
	 */
	public Date getAddTime() {
		return addTime;
	}
	/**
	 * 设置：商品单价
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：商品单价
	 */
	public BigDecimal getPrice() {
		return price;
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
}
