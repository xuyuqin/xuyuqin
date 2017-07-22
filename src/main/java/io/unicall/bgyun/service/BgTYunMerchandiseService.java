package io.unicall.bgyun.service;

import io.yun.entity.TYunMerchandiseEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品表
 * 
 * @author unicall
 * @email bq.zhu@unicall.com
 * @date 2017-07-11 20:16:19
 */
public interface BgTYunMerchandiseService {
	
	TYunMerchandiseEntity queryObject(String id);
	
	List<TYunMerchandiseEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunMerchandiseEntity tYunMerchandise);
	
	void update(TYunMerchandiseEntity tYunMerchandise);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
