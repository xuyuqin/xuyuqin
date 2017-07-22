package io.yun.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kai.lan on 2017/7/10.
 */
public class BaikeIndexDto {
    private int id;
    private String categoryName;
    private String subCategoryName;
    private Date editTime;
    private String name;
    private String upName;
    private String aliasName;
    private String material;
    private String unit;
    private BigDecimal price;
    private String hotSearch;

    private String memberId;
    private String createTime;
    private String buyPrice;

    private String prividerName;
    private BigDecimal prividerPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getPrividerName() {
        return prividerName;
    }

    public void setPrividerName(String prividerName) {
        this.prividerName = prividerName;
    }

    public BigDecimal getPrividerPrice() {
        return prividerPrice;
    }

    public void setPrividerPrice(BigDecimal prividerPrice) {
        this.prividerPrice = prividerPrice;
    }
}
