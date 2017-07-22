package io.yun.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kai.lan on 2017/6/30.
 */
public class MerchandiseDto {
    //商品id
    private String id;
    //商品名称
    private String name;
    //商品单价
    private BigDecimal price;
    //是否推荐商品
    private BigDecimal isRecommend;
    //创建时间
    private Date createTime;
    //标题
    private String title;
    //商品单位
    private String unit;
    //商品库存
    private BigDecimal number;
    //商品信息/商品规格（多个）
    private String detail;
    //更新日期
    private Date updateTime;
    //商品材质
    private String material;
    //商品状态/是否在售
    private BigDecimal inSale;
    //商品品种ID
    private String productName;
    //商品供应商ID
    private String providerName;
    //子类别id
    private String subCategoryName;
    //子类别id
    private String weight;
    //地区
    private String region;
    //商品规格
    private String specification;
    //销量
    private int salenum;

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public int getSalenum() {
        return salenum;
    }

    public void setSalenum(int salenum) {
        this.salenum = salenum;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(BigDecimal isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public BigDecimal getInSale() {
        return inSale;
    }

    public void setInSale(BigDecimal inSale) {
        this.inSale = inSale;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}
