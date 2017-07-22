package io.yun.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 求购单表
 * 
 * @author unicall
 * @email bq.zhu@unicall.com
 * @date 2017-06-27 15:39:20
 */
public class TYunDemandEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//会员id
	private String memberId;
	//商品类别
	private String category;
	//商品子类别
	private String subCategory;
	//商品品种id
	private String productId;
	//求购数量
	private Integer amount;
	//商品规格
	private String specification;
	//商品材质
	private String material;
	//卖家所在地区
	private String district;
	//求购公司名称
	private String companyName;
	//求购联系人
	private String contract;
	//求购人电话
	private String phone;
	//发布时间
	private Date createTime;
	//采购产品
	private String productBuy;
	//商品品种名称
	private String productName;
	//求购单标题
	private String name;
	//报价次数
	private Integer replyCount;
	//有效期
	private String validity;
	//备注
	private String remarks;
	//审批状态
	private String isPermit;

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
	 * 设置：商品类别
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 获取：商品类别
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 设置：商品子类别
	 */
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	/**
	 * 获取：商品子类别
	 */
	public String getSubCategory() {
		return subCategory;
	}
	/**
	 * 设置：商品品种id
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * 获取：商品品种id
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * 设置：求购数量
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	/**
	 * 获取：求购数量
	 */
	public Integer getAmount() {
		return amount;
	}
	/**
	 * 设置：商品规格
	 */
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	/**
	 * 获取：商品规格
	 */
	public String getSpecification() {
		return specification;
	}
	/**
	 * 设置：商品材质
	 */
	public void setMaterial(String material) {
		this.material = material;
	}
	/**
	 * 获取：商品材质
	 */
	public String getMaterial() {
		return material;
	}
	/**
	 * 设置：卖家所在地区
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * 获取：卖家所在地区
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * 设置：求购公司名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：求购公司名称
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：求购联系人
	 */
	public void setContract(String contract) {
		this.contract = contract;
	}
	/**
	 * 获取：求购联系人
	 */
	public String getContract() {
		return contract;
	}
	/**
	 * 设置：求购人电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：求购人电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：发布时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：采购产品
	 */
	public void setProductBuy(String productBuy) {
		this.productBuy = productBuy;
	}
	/**
	 * 获取：采购产品
	 */
	public String getProductBuy() {
		return productBuy;
	}
	/**
	 * 设置：商品品种名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 获取：商品品种名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 设置：求购单标题
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：求购单标题
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：报价次数
	 */
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}
	/**
	 * 获取：报价次数
	 */
	public Integer getReplyCount() {
		return replyCount;
	}
	/**
	 * 设置：有效期
	 */
	public void setValidity(String validity) {
		this.validity = validity;
	}
	/**
	 * 获取：有效期
	 */
	public String getValidity() {
		return validity;
	}
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注
	 */
	public String getRemarks() {
		return remarks;
	}

	public String getIsPermit() {
		return isPermit;
	}
	public void setIsPermit(String isPermit) {
		this.isPermit = isPermit;
	}
}
