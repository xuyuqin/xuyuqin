package io.yun.service;

import io.yun.entity.TYunMarketingEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 营销（活动）表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-07-07 11:07:41
 */
public interface TYunMarketingService {
	
	TYunMarketingEntity queryObject(String id);
	
	List<TYunMarketingEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunMarketingEntity tYunMarketing);
	
	void update(TYunMarketingEntity tYunMarketing);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    List<Map<String,Integer>> queryStatus(Map<String, Object> params);

	void saveMerchandise(String marketingId, String merchandiseId);

    void deleteMerchandise(String marketingId, Set<String> merchandiseIds);

	void deleteAllMerchandise(String marketingId);
}
