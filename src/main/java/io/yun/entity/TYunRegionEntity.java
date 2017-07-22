package io.yun.entity;

import java.io.Serializable;



/**
 * 地区表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-22 15:38:04
 */
public class TYunRegionEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//区域代码
	private String code;
	//地区名称
	private String name;
	//地区级别
	private Integer level;

	/**
	 * 设置：区域代码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：区域代码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：地区名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：地区名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：地区级别
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：地区级别
	 */
	public Integer getLevel() {
		return level;
	}
}
