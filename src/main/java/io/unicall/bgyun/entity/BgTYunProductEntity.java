package io.unicall.bgyun.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 产品表
 * 
 * @author unicall
 * @email bq.zhu@unicall.com
 * @date 2017-06-23 12:02:43
 */
public class BgTYunProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String cName;
	private String sCName;
	private Date editTime;
	private String name;
	private String upName;
	private String aliasName;
	private String material;
	private String unit;
	private BigDecimal price;
	private String hotSearch;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getsCName() {
		return sCName;
	}

	public void setsCName(String sCName) {
		this.sCName = sCName;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpName() {
		return upName;
	}

	public void setUpName(String upName) {
		this.upName = upName;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getHotSearch() {
		return hotSearch;
	}

	public void setHotSearch(String hotSearch) {
		this.hotSearch = hotSearch;
	}
}
