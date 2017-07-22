package io.yun.dto;

import io.unicall.entity.SysUserEntity;

public class MyTraderDto {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    public MyTraderDto() {
    }

    public MyTraderDto(SysUserEntity sysUserEntity) {
        this.userId = sysUserEntity.getUserId();
        this.username = sysUserEntity.getUsername();
        this.mobile = sysUserEntity.getMobile();
        this.email = sysUserEntity.getEmail();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
