package io.yun.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 订单表
 *
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:31
 */
public class TYunOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private String id;
	//订单编号
	private String orderNo;
	//订单状态
	private int status;
	//订单金额
	private double orderPrice;
	//订单支付到期时间
	private Date paymentExpire;
	//发票抬头
	private String invoiceHead;
	//发票寄送地址
	private String invoiceAddress;
	//发票状态（1已开票，2已申请未开票，3未申请）
	private Integer invoiceStatus;
	//提货方式（1整单提取，2分批提取，3过户）
	private int deliveryMethod;
	//提货凭证
	private String deliveryCredential;
	//提货注释
	private String deliveryComment;
	//下单时间
	private Date orderTime;
	//会员id
	private String memberId;
	//是否取消订单
	private int isDelete;
	//供应商id
	private String providerId;

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
	 * 设置：订单编号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单编号
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：订单状态
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * 获取：订单状态
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * 设置：订单金额
	 */
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	/**
	 * 获取：订单金额
	 */
	public double getOrderPrice() {
		return orderPrice;
	}
	/**
	 * 设置：订单支付到期时间
	 */
	public void setPaymentExpire(Date paymentExpire) {
		this.paymentExpire = paymentExpire;
	}
	/**
	 * 获取：订单支付到期时间
	 */
	public Date getPaymentExpire() {
		return paymentExpire;
	}
	/**
	 * 设置：发票抬头
	 */
	public void setInvoiceHead(String invoiceHead) {
		this.invoiceHead = invoiceHead;
	}
	/**
	 * 获取：发票抬头
	 */
	public String getInvoiceHead() {
		return invoiceHead;
	}
	/**
	 * 设置：发票寄送地址
	 */
	public void setInvoiceAddress(String invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
	}
	/**
	 * 获取：发票寄送地址
	 */
	public String getInvoiceAddress() {
		return invoiceAddress;
	}
	/**
	 * 设置：发票状态（1已开票，2已申请未开票，3未申请）
	 */
	public void setInvoiceStatus(int invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	/**
	 * 获取：发票状态（1已开票，2已申请未开票，3未申请）
	 */
	public Integer getInvoiceStatus() {
		return invoiceStatus;
	}
	/**
	 * 设置：提货方式（1整单提取，2分批提取，3过户）
	 */
	public void setDeliveryMethod(Integer deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	/**
	 * 获取：提货方式（1整单提取，2分批提取，3过户）
	 */
	public int getDeliveryMethod() {
		return deliveryMethod;
	}
	/**
	 * 设置：提货凭证
	 */
	public void setDeliveryCredential(String deliveryCredential) {
		this.deliveryCredential = deliveryCredential;
	}
	/**
	 * 获取：提货凭证
	 */
	public String getDeliveryCredential() {
		return deliveryCredential;
	}
	/**
	 * 设置：提货注释
	 */
	public void setDeliveryComment(String deliveryComment) {
		this.deliveryComment = deliveryComment;
	}
	/**
	 * 获取：提货注释
	 */
	public String getDeliveryComment() {
		return deliveryComment;
	}
	/**
	 * 设置：下单时间
	 */
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	/**
	 * 获取：下单时间
	 */
	public Date getOrderTime() {
		return orderTime;
	}
	/**
	 * 设置：会员id
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：会员id
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * 设置：是否取消订单
	 */
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：是否取消订单
	 */
	public int getIsDelete() {
		return isDelete;
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
}
