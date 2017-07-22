package io.yun.entity;

import java.io.Serializable;
import java.math.BigDecimal;



/**
 * 供应商信息表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-16 16:45:27
 */
public class TYunProviderEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private String id;
	//供应商名称
	private String name;
	//商标（图片路径）
	private String logo;
	//账户id
	private String memberId;
	//供应商联系人
	private String contactName;
	//联系电话
	private String contactPhone;
	//供应商地址
	private String contactAddress;
	//简介
	private String profile;
	//质量评分
	private BigDecimal qualityScore;
	//价格评分
	private BigDecimal priceScore;
	//服务评分
	private BigDecimal serviceScore;
	//地区code
	private String region;
	//类型
	private String type;
	//认证材料
	private String file;
	//身份证号
	private String contactIdnum;
	//主营产品id
	private String productIds;
	//主营产品
	private String productNames;
    //是否被收藏
    private String isCollection;
    ////地区名称
    private String districtname;

	public String getProductIds() {
		return productIds;
	}

	public void setProductIds(String productIds) {
		this.productIds = productIds;
	}

	public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }

    public String getIsCollection() {
        return isCollection;
    }

    public void setIsCollection(String isCollection) {
        this.isCollection = isCollection;
    }

    public String getProductNames() {
		return productNames;
	}

	public void setProductNames(String productNames) {
		this.productNames = productNames;
	}

	public String getContactIdnum() {
		return contactIdnum;
	}

	public void setContactIdnum(String contactIdnum) {
		this.contactIdnum = contactIdnum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

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
	 * 设置：供应商名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：供应商名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：商标（图片路径）
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	/**
	 * 获取：商标（图片路径）
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * 设置：账户id
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：账户id
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * 设置：供应商联系人
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * 获取：供应商联系人
	 */
	public String getContactName() {
		return contactName;
	}
	/**
	 * 设置：联系电话
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getContactPhone() {
		return contactPhone;
	}
	/**
	 * 设置：供应商地址
	 */
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	/**
	 * 获取：供应商地址
	 */
	public String getContactAddress() {
		return contactAddress;
	}
	/**
	 * 设置：简介
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}
	/**
	 * 获取：简介
	 */
	public String getProfile() {
		return profile;
	}
	/**
	 * 设置：质量评分
	 */
	public void setQualityScore(BigDecimal qualityScore) {
		this.qualityScore = qualityScore;
	}
	/**
	 * 获取：质量评分
	 */
	public BigDecimal getQualityScore() {
		return qualityScore;
	}
	/**
	 * 设置：价格评分
	 */
	public void setPriceScore(BigDecimal priceScore) {
		this.priceScore = priceScore;
	}
	/**
	 * 获取：价格评分
	 */
	public BigDecimal getPriceScore() {
		return priceScore;
	}
	/**
	 * 设置：服务评分
	 */
	public void setServiceScore(BigDecimal serviceScore) {
		this.serviceScore = serviceScore;
	}
	/**
	 * 获取：服务评分
	 */
	public BigDecimal getServiceScore() {
		return serviceScore;
	}
	/**
	 * 设置：地区code
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * 获取：地区code
	 */
	public String getRegion() {
		return region;
	}
}
