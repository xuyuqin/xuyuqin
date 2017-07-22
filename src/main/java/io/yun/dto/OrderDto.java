package io.yun.dto;

import java.util.Set;

/**
 * Created by sr.chen on 2017/7/6.
 */
public class OrderDto {
    //订单金额
    private double orderPrice;
    //订单支付到期时间
    private String paymentExpire;
    //发票抬头
    private String invoiceHead;
    //发票寄送地址
    private String invoiceAddress;
    //发票状态（1已开票，2已申请未开票，3未申请）
    private int invoiceStatus;
    //提货方式（1整单提取，2分批提取，3过户）
    private int deliveryMethod;
    //提货凭证
    private String deliveryCredential;
    //提货注释
    private String deliveryComment;
    //供应商id
    private String providerId;

    private Set<OrderSpecDto> specifications;

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getPaymentExpire() {
        return paymentExpire;
    }

    public void setPaymentExpire(String paymentExpire) {
        this.paymentExpire = paymentExpire;
    }

    public String getInvoiceHead() {
        return invoiceHead;
    }

    public void setInvoiceHead(String invoiceHead) {
        this.invoiceHead = invoiceHead;
    }

    public String getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(String invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public int getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(int invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public int getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(int deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getDeliveryCredential() {
        return deliveryCredential;
    }

    public void setDeliveryCredential(String deliveryCredential) {
        this.deliveryCredential = deliveryCredential;
    }

    public String getDeliveryComment() {
        return deliveryComment;
    }

    public void setDeliveryComment(String deliveryComment) {
        this.deliveryComment = deliveryComment;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public Set<OrderSpecDto> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Set<OrderSpecDto> specifications) {
        this.specifications = specifications;
    }
}
