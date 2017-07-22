package io.yun.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 资源单表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-19 13:52:09
 */
public class TYunResourceEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//资源单名称
	private String name;
	//公司抬头
	private String companyHead;
	//资源调价比列
	private BigDecimal scale;
	//所属类别
	private String categoryId;
	//资源单描述
	private String description;
	//资源单存储路径
	private String url;
	//上传资源表时间
	private Date uploadTime;
	//地区
	private String district;
	//供应商id
	private String providerId;

	private String category;

	private String providername;

	private String districtname;

	private String isCollection;

	private int downloadtimes;

	private String productnames;
	
	private int isPermit;
	
	private String mobile; 



	public String getProductnames() {
		return productnames;
	}

	public void setProductnames(String productname) {
		this.productnames = productname;
	}

	public int getDownloadtimes() {
		return downloadtimes;
	}

	public void setDownloadtimes(int downloadtimes) {
		this.downloadtimes = downloadtimes;
	}

	public String getIsCollection() {
		return isCollection;
	}

	public void setIsCollection(String isCollection) {
		this.isCollection = isCollection;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public String getProvidername() {
		return providername;
	}

	public void setProvidername(String providername) {
		this.providername = providername;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyHead() {
		return companyHead;
	}

	public void setCompanyHead(String companyHead) {
		this.companyHead = companyHead;
	}

	public BigDecimal getScale() {
		return scale;
	}

	public void setScale(BigDecimal scale) {
		this.scale = scale;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public int getIsPermit() {
		return isPermit;
	}

	public void setIsPermit(int isPermit) {
		this.isPermit = isPermit;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
