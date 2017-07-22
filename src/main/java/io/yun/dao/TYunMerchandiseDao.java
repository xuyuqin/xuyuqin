package io.yun.dao;

import io.unicall.dao.BaseDao;
import io.yun.dto.MerchandiseDto;
import io.yun.entity.TYunMerchandiseEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 商品表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-16 10:38:12
 */
public interface TYunMerchandiseDao extends BaseDao<TYunMerchandiseEntity> {
    List<MerchandiseDto> getByProviderId(Map<String, Object> map);

    int getByProviderIdTotal(String providerId);

    void saveImg(@Param(value = "merchandiseId")String merchandiseId, @Param(value = "url")String url);
}
