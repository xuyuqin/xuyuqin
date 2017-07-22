package io.yun.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 新闻资讯表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:31
 */
public class TYunNewsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//新闻标题
	private String title;
	//新闻概要
	private String summary;
	//新闻内容
	private String content;
	//发布时间
	private Date posttime;
	//新闻分类
	private int category;

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
	 * 设置：新闻标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：新闻标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：新闻概要
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * 获取：新闻概要
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * 设置：新闻内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：新闻内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：发布时间
	 */
	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getPosttime() {
		return posttime;
	}
	/**
	 * 设置：新闻分类
	 */
	public void setCategory(int category) {
		this.category = category;
	}
	/**
	 * 获取：新闻分类
	 */
	public int getCategory() {
		return category;
	}
}
