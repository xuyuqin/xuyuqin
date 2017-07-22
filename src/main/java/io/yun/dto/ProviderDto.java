package io.yun.dto;

import io.yun.entity.TYunProviderEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sr.chen on 2017/6/30.
 */
public class ProviderDto {
    //id
    private String id;
    //供应商名称
    private String name;
    //主营产品
    private String productNames;
    //是否被收藏
    private String isCollection;
    //综和评分
    private BigDecimal score;
    ////地区名称
    private String districtname;

    public ProviderDto() {
    }

    public ProviderDto(TYunProviderEntity tYunProviderEntity) {
        this.id = tYunProviderEntity.getId();
        this.name = tYunProviderEntity.getName();
        this.productNames = tYunProviderEntity.getProductNames();
        this.isCollection = tYunProviderEntity.getIsCollection();
        this.districtname = tYunProviderEntity.getDistrictname();
        BigDecimal ps = tYunProviderEntity.getPriceScore();
        BigDecimal ss = tYunProviderEntity.getServiceScore();
        BigDecimal qs = tYunProviderEntity.getQualityScore();
        if(ps!=null&&ss!=null&qs!=null){
            this.score = ((ps.add(qs).add(ss)).divide(BigDecimal.valueOf(3),2, BigDecimal.ROUND_HALF_EVEN));
        }
     }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }

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

    public String getProductNames() {
        return productNames;
    }

    public void setProductNames(String productNames) {
        this.productNames = productNames;
    }

    public String getIsCollection() {
        return isCollection;
    }

    public void setIsCollection(String isCollection) {
        this.isCollection = isCollection;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public static List<ProviderDto> changeFrom(List<TYunProviderEntity> tYunProviderEntity) {
        List<ProviderDto> providerDtoList = new ArrayList<ProviderDto>();
        for(int i = 0 ; i < tYunProviderEntity.size() ; i++) {
            providerDtoList.add(new ProviderDto(tYunProviderEntity.get(i)));
        }
        return providerDtoList;
    }
}
