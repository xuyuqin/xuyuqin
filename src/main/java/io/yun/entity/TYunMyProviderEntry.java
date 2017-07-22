package io.yun.entity;

/**
 * Created by Zhanglei on 2017/7/11.
 */
/*我的供应商列表*/
public class TYunMyProviderEntry {
    //供应商id
    private String providerId;
    //供应商名称
    private String providerName;
    //主营产品
    private String productName;
    //买房的头衔等级
    private String title;

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
