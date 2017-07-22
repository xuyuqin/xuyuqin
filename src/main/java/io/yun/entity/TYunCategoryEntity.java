package io.yun.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 商品类别表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-19 16:20:37
 */
public class TYunCategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private int id;
	//类别名称
	private String name;
	//父类别id
	private int parent;
	
	private Date updateTime;

	
	/**
	 * 设置：id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public int getId() {
		return id;
	}
	/**
	 * 设置：类别名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：类别名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：父类别id
	 */
	public void setParent(int parent) {
		this.parent = parent;
	}
	/**
	 * 获取：父类别id
	 */
	public int getParent() {
		return parent;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
