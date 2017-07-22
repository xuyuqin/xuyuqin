package io.yun.dto;

/**
 * Created by sr.chen on 2017/7/6.
 */
public class HomeProviderDto {
    //id
    private String id;
    //供应商名称
    private String name;
    //商标（图片路径）
    private String logo;

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
