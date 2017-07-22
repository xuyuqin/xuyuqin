package io.yun.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 商品收藏表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-16 10:38:12
 */
public class TYunMerchandiseCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private String id;
	//收藏用户id
	private String memberId;
	//商品id
	private String merchandiseId;
	//规格id
	private String specificationId;
	//创建时间
	private Date createTime;

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
	 * 设置：收藏用户id
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：收藏用户id
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
	 * 设置：规格id
	 */
	public void setSpecificationId(String specificationId) {
		this.specificationId = specificationId;
	}
	/**
	 * 获取：规格id
	 */
	public String getSpecificationId() {
		return specificationId;
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
