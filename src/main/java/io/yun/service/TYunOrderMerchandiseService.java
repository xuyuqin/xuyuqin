package io.yun.service;

import io.yun.entity.TYunOrderMerchandiseEntity;

import java.util.List;
import java.util.Map;

/**
 * 订单商品评价表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:31
 */
public interface TYunOrderMerchandiseService {
	
	TYunOrderMerchandiseEntity queryObject(String id);
	
	List<TYunOrderMerchandiseEntity> queryList(Map<String, Object> map);

	List<TYunOrderMerchandiseEntity> getBuyPrice(String id);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunOrderMerchandiseEntity tYunOrderMerchandise);
	
	void update(TYunOrderMerchandiseEntity tYunOrderMerchandise);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
