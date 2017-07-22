package io.unicall.bgyun.entity;

import org.joda.time.DateTime;

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
public class BgTYunOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String orderNo;
    private String status;
    private DateTime paymentExpire;
    private BigDecimal orderPrice;
    private Boolean integral;



    public BgTYunOrderEntity() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Boolean getIntegral() {
        return integral;
    }

    public void setIntegral(Boolean integral) {
        this.integral = integral;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DateTime getPaymentExpire() {
        return paymentExpire;
    }

    public void setPaymentExpire(DateTime paymentExpire) {
        this.paymentExpire = paymentExpire;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }
}
