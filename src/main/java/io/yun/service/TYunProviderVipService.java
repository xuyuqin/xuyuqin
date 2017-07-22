package io.yun.service;

import io.yun.entity.TYunProviderVipEntity;

import java.util.List;
import java.util.Map;

/**
 * 供应商—会员表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-07-11 16:18:24
 */
public interface TYunProviderVipService {
	
	TYunProviderVipEntity queryObject(Integer id);
	
	List<TYunProviderVipEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunProviderVipEntity tYunProviderVip);
	
	void update(TYunProviderVipEntity tYunProviderVip);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	TYunProviderVipEntity getByProviderAndMember(Map<String, Object> map);
}
