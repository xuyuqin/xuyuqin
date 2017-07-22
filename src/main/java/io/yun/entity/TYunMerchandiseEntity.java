package io.yun.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 商品表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-16 10:38:12
 */
public class TYunMerchandiseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
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
	//商品信息
	private String detail;
	//更新日期
	private Date updateTime;
	//商品材质
	private String material;
	//商品状态/是否在售
	private int inSale;
	//商品品种ID
	private String productId;
	//商品供应商ID
	private String providerId;
	//商品质量评价
	private BigDecimal qualityScore;
	//商品价格评价
	private BigDecimal priceScore;
	//服务评价
	private BigDecimal serviceScore;
	//子类别id
	private String subCategoryId;
	//产品分类
	private String categoryName;
	//子类别id
	private String weight;
	//供应商
	private TYunProviderEntity provider;
	//地区:TYunProviderEntity
	private String region;
	//销量
	private int saleNum;
    //一级会员商品单价
    private BigDecimal price1;
    //2级会员商商品单价
    private BigDecimal price2;
    //3级会员商商品单价
    private BigDecimal price3;
    //4级会员商商品单价
    private BigDecimal price4;
    //5级会员商商品单价
    private BigDecimal price5;
    //规格
    private String spe;
    //是否现货商品
    private int isxhsp;
    //其他属性
    private String other;

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public int getIsxhsp() {
        return isxhsp;
    }

    public void setIsxhsp(int isxhsp) {
        this.isxhsp = isxhsp;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public String getSpe() {
        return spe;
    }

    public void setSpe(String spe) {
        this.spe = spe;
    }

    public BigDecimal getPrice1() {
        return price1;
    }

    public void setPrice1(BigDecimal price1) {
        this.price1 = price1;
    }

    public BigDecimal getPrice2() {
        return price2;
    }

    public void setPrice2(BigDecimal price2) {
        this.price2 = price2;
    }

    public BigDecimal getPrice3() {
        return price3;
    }

    public void setPrice3(BigDecimal price3) {
        this.price3 = price3;
    }

    public BigDecimal getPrice4() {
        return price4;
    }

    public void setPrice4(BigDecimal price4) {
        this.price4 = price4;
    }

    public BigDecimal getPrice5() {
        return price5;
    }

    public void setPrice5(BigDecimal price5) {
        this.price5 = price5;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public TYunProviderEntity getProvider() {
		return provider;
	}

	public void setProvider(TYunProviderEntity provider) {
		this.provider = provider;
	}

	/**
	 * 设置：商品id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：商品id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：商品名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：商品名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：商品单价
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：商品单价
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：是否推荐商品
	 */
	public void setIsRecommend(BigDecimal isRecommend) {
		this.isRecommend = isRecommend;
	}
	/**
	 * 获取：是否推荐商品
	 */
	public BigDecimal getIsRecommend() {
		return isRecommend;
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
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：商品库存
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取：商品库存
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * 设置：商品信息/商品规格（多个）
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * 获取：商品信息/商品规格（多个）
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * 设置：更新日期
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新日期
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：商品材质
	 */
	public void setMaterial(String material) {
		this.material = material;
	}
	/**
	 * 获取：商品材质
	 */
	public String getMaterial() {
		return material;
	}
	/**
	 * 设置：商品状态/是否在售
	 */
	public void setInSale(int inSale) {
		this.inSale = inSale;
	}
	/**
	 * 获取：商品状态/是否在售
	 */
	public int getInSale() {
		return inSale;
	}
	/**
	 * 设置：商品品种ID
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * 获取：商品品种ID
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * 设置：商品供应商ID
	 */
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	/**
	 * 获取：商品供应商ID
	 */
	public String getProviderId() {
		return providerId;
	}
	/**
	 * 设置：商品质量评价
	 */
	public void setQualityScore(BigDecimal qualityScore) {
		this.qualityScore = qualityScore;
	}
	/**
	 * 获取：商品质量评价
	 */
	public BigDecimal getQualityScore() {
		return qualityScore;
	}
	/**
	 * 设置：商品价格评价
	 */
	public void setPriceScore(BigDecimal priceScore) {
		this.priceScore = priceScore;
	}
	/**
	 * 获取：商品价格评价
	 */
	public BigDecimal getPriceScore() {
		return priceScore;
	}
	/**
	 * 设置：服务评价
	 */
	public void setServiceScore(BigDecimal serviceScore) {
		this.serviceScore = serviceScore;
	}
	/**
	 * 获取：服务评价
	 */
	public BigDecimal getServiceScore() {
		return serviceScore;
	}
	/**
	 * 设置：子类别id
	 */
	public void setSubCategoryId(String subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	/**
	 * 获取：子类别id
	 */
	public String getSubCategoryId() {
		return subCategoryId;
	}

	public String getWeight() {
		return weight;
	}

	public TYunMerchandiseEntity setWeight(String weight) {
		this.weight = weight;
		return this;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
}
