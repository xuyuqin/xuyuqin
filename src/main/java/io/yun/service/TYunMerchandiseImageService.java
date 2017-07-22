package io.yun.service;

import io.yun.entity.TYunMerchandiseImageEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品图片表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:31
 */
public interface TYunMerchandiseImageService {
	
	TYunMerchandiseImageEntity queryObject(String id);
	
	List<TYunMerchandiseImageEntity> queryList(Map<String, Object> map);

	int queryTotal(Map<String, Object> map);
	
	void save(TYunMerchandiseImageEntity tYunMerchandiseImage);
	
	void update(TYunMerchandiseImageEntity tYunMerchandiseImage);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    List<TYunMerchandiseImageEntity> getByMerchandiseId(String merchandiseId);

    int queryTotal(String[] ids, String merchandiseId);
}
