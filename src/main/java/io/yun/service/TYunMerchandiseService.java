package io.yun.service;

import io.yun.dto.MerchandiseDto;
import io.yun.entity.TYunMerchandiseEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-16 10:38:12
 */
public interface TYunMerchandiseService {
	
	TYunMerchandiseEntity queryObject(String id);
	
	List<TYunMerchandiseEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);

	void save(TYunMerchandiseEntity tYunMerchandise);
	
	void update(TYunMerchandiseEntity tYunMerchandise);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    List<MerchandiseDto> getByProviderId(Map<String, Object> map);

	int getByProviderIdTotal(String providerId);

    void saveImg(String merchandiseId, String url);
}
