package io.yun.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kai.lan on 2017/6/30.
 */
public class PriceDynamicsDto {
    //
    private String id;
    //
    private String pname;
    //
    private String mname;
    //
    private String unit;
    //
    private String material;
    //
    private BigDecimal prePrice;
    //
    private BigDecimal postPrice;
    //
    private BigDecimal trend;
    //
    private Date scaleTime;
    //
    private String merchandiseId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public BigDecimal getPrePrice() {
        return prePrice;
    }

    public void setPrePrice(BigDecimal prePrice) {
        this.prePrice = prePrice;
    }

    public BigDecimal getPostPrice() {
        return postPrice;
    }

    public void setPostPrice(BigDecimal postPrice) {
        this.postPrice = postPrice;
    }

    public BigDecimal getTrend() {
        return trend;
    }

    public void setTrend(BigDecimal trend) {
        this.trend = trend;
    }

    public Date getScaleTime() {
        return scaleTime;
    }

    public void setScaleTime(Date scaleTime) {
        this.scaleTime = scaleTime;
    }

    public String getMerchandiseId() {
        return merchandiseId;
    }

    public void setMerchandiseId(String merchandiseId) {
        this.merchandiseId = merchandiseId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
