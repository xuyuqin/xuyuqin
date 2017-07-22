package io.yun.service;

import io.yun.entity.TYunOrderEntity;

import java.util.List;
import java.util.Map;

/**
 * 订单表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:31
 */
public interface TYunOrderService {
	
	TYunOrderEntity queryObject(String id);
	
	List<TYunOrderEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunOrderEntity tYunOrder);
	
	void update(TYunOrderEntity tYunOrder);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    int queryOrderNumToday();
}
