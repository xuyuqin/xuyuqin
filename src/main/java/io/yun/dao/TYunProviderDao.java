package io.yun.dao;

import io.unicall.dao.BaseDao;
import io.yun.dto.BaikeDetailsDto;
import io.yun.dto.HomeProviderDto;
import io.yun.dto.ProviderDto;
import io.yun.entity.TYunProviderEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

import java.util.List;
import java.util.Map;

/**
 * 供应商信息表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-16 16:45:27
 */
public interface TYunProviderDao extends BaseDao<TYunProviderEntity> {

    TYunProviderEntity findByMemberId(String id);


    void saveProduct(@Param(value="providerId")String providerId, @Param(value="productId") String productId);

    void deleteProduct(@Param(value="providerId")String providerId, @Param(value="productId") Set productId);

    List<HomeProviderDto> getHomeProvider(Map<String, Object> map);

    List<TYunProviderEntity> getProvider(String productid);

    TYunProviderEntity getProviderId(String id);


    List<ProviderDto> providerList(Map<String, Object> map);
}
