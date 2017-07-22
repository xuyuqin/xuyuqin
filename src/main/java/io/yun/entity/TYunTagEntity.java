package io.yun.entity;

import java.io.Serializable;



/**
 * 产品标签表（百科按标签查找产品功能）
 * 
 * @author unicall
 * @email bq.zhu@unicall.com
 * @date 2017-06-23 11:15:52
 */
public class TYunTagEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String name;
	//
	private String id;

	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
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
}
