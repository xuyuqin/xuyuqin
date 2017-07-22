package io.yun.dto;

import io.unicall.entity.SysRegisterEntity;

public class MyInfoDto {
    /**
     * 用户ID
     */
    private Long Id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;

    /**
     * QQ
     */
    private String qq;

    /**
     * 地址
     */
    private String address;

    /**
     * 邀请码
     */
    private String yqm;

    private int mobileVerified;
    private int emailVerified;

    public MyInfoDto() {
    }

    public MyInfoDto(SysRegisterEntity member) {
        this.Id = member.getId();
        this.name = member.getName();
        this.mobile = member.getMobile();
        this.email = member.getEmail();
        this.avatar = member.getAvatar();
        this.qq = member.getQq();
        this.address = member.getAddress();
        this.mobileVerified = member.getMobileVerified();
        this.emailVerified = member.getEmailVerified();
    }

    public int getMobileVerified() {
        return mobileVerified;
    }

    public void setMobileVerified(int mobileVerified) {
        this.mobileVerified = mobileVerified;
    }

    public int getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(int emailVerified) {
        this.emailVerified = emailVerified;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getYqm() {
        return yqm;
    }

    public void setYqm(String yqm) {
        this.yqm = yqm;
    }
}
