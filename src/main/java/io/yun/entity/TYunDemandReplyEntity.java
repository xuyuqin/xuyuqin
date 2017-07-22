package io.yun.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 求购单报价表
 * 
 * @author unicall
 * @email bq.zhu@unicall.com
 * @date 2017-06-27 14:05:08
 */
public class TYunDemandReplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//求购单id
	private String demandId;
	//报价类型
	private BigDecimal priceType;
	//报价金额
	private BigDecimal price;
	//供应商id
	private String providerId;
	//联系人
	private String contract;
	//联系电话
	private String phone;
	//报价备注
	private String remarks;
	//创建时间
	private Date createTime;

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
	 * 设置：求购单id
	 */
	public void setDemandId(String demandId) {
		this.demandId = demandId;
	}
	/**
	 * 获取：求购单id
	 */
	public String getDemandId() {
		return demandId;
	}
	/**
	 * 设置：报价类型
	 */
	public void setPriceType(BigDecimal priceType) {
		this.priceType = priceType;
	}
	/**
	 * 获取：报价类型
	 */
	public BigDecimal getPriceType() {
		return priceType;
	}
	/**
	 * 设置：报价金额
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：报价金额
	 */
	public BigDecimal getPrice() {
		return price;
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
	 * 设置：联系人
	 */
	public void setContract(String contract) {
		this.contract = contract;
	}
	/**
	 * 获取：联系人
	 */
	public String getContract() {
		return contract;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：报价备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：报价备注
	 */
	public String getRemarks() {
		return remarks;
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
