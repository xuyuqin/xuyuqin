package io.yun.entity;

import java.io.Serializable;



/**
 * 商品规格表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-07-04 10:32:17
 */
public class TYunMerchandiseSpecEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private String id;
	//商品id
	private String merchandiseId;
	//规格
	private String specification;
	//单价
	private Double price;
	//质量
	private Double weight;
	//库存
	private Double stock;

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
	 * 设置：规格
	 */
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	/**
	 * 获取：规格
	 */
	public String getSpecification() {
		return specification;
	}
	/**
	 * 设置：单价
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取：单价
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * 设置：质量
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	/**
	 * 获取：质量
	 */
	public Double getWeight() {
		return weight;
	}
	/**
	 * 设置：库存
	 */
	public void setStock(Double stock) {
		this.stock = stock;
	}
	/**
	 * 获取：库存
	 */
	public Double getStock() {
		return stock;
	}
}
