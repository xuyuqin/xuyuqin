package io.yun.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sr.chen on 2017/7/5.
 */
public class MerchandiseCommitDto {
    //评价内容
    private String commits;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //回复
    private String reply;
    //姓名
    private String name;
    //商品数量
    private BigDecimal amount;
    //规格
    private String specification;

    public String getCommits() {
        return commits;
    }

    public void setCommits(String commits) {
        this.commits = commits;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}
