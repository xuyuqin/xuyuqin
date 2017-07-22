package io.yun.entity;

import java.io.Serializable;



/**
 * 商品图片表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:31
 */
public class TYunMerchandiseImageEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//商品id
	private String merchandiseId;
	//图片存储路径
	private String url;

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
	 * 设置：图片存储路径
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：图片存储路径
	 */
	public String getUrl() {
		return url;
	}
}
