package io.yun.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员中心我的订单dto
 * Created by sr.chen on 2017/6/27.
 */
public class MyOrderDto {
    //订单编号
    private String orderNo;
    //订单状态
    private int status;
    //订单金额
    private BigDecimal orderPrice;
    //订单支付到期时间
    private Date paymentExpire;
    //下单时间
    private Date orderTime;
    //购买件数
    private String amount;
    //商品名称
    private String merchandiseName;
    //商品单价
    private String price;
    //商品规格
    private String detail;
    //商品材质
    private String material;
    //商品重量
    private String weight;
    //商品品种
    private String productName;
    //商品分类
    private String categoryName;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getPaymentExpire() {
        return paymentExpire;
    }

    public void setPaymentExpire(Date paymentExpire) {
        this.paymentExpire = paymentExpire;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMerchandiseName() {
        return merchandiseName;
    }

    public void setMerchandiseName(String merchandiseName) {
        this.merchandiseName = merchandiseName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
