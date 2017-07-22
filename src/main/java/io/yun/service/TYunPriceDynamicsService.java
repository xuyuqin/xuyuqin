package io.yun.service;

import io.yun.entity.TYunPriceDynamicsEntity;

import java.util.List;
import java.util.Map;

/**
 * 价格动态表
 * 
 * @author lankai
 * @email bq.zhu@unicall.com
 * @date 2017-06-30 10:56:33
 */
public interface TYunPriceDynamicsService {
	
	TYunPriceDynamicsEntity queryObject(String id);
	
	List<TYunPriceDynamicsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunPriceDynamicsEntity tYunPriceDynamics);
	
	void update(TYunPriceDynamicsEntity tYunPriceDynamics);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
