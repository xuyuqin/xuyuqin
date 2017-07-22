package io.yun.service;

import io.yun.dto.BaikeDetailsDto;
import io.yun.dto.ProviderDto;
import io.yun.entity.TYunProviderEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 供应商信息表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-16 16:45:27
 */
public interface TYunProviderService {
	
	TYunProviderEntity queryObject(String id);

	TYunProviderEntity getProviderId(String product_id);


    List<ProviderDto> providerList(Map<String, Object> map);
	
	List<TYunProviderEntity> queryList(Map<String, Object> map);

	List<TYunProviderEntity> getProvider(String id);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunProviderEntity tYunProvider);
	
	void update(TYunProviderEntity tYunProvider);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    TYunProviderEntity findByMemberId(String id);

    void saveProduct(String providerId, String productId);

	void deleteProduct(String providerId, Set productId);
}
