package io.yun.service;

import io.yun.entity.TYunMerchandiseSpecEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品规格表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-07-04 10:32:17
 */
public interface TYunMerchandiseSpecService {
	
	TYunMerchandiseSpecEntity queryObject(String id);
	
	List<TYunMerchandiseSpecEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunMerchandiseSpecEntity tYunMerchandiseSpec);
	
	void update(TYunMerchandiseSpecEntity tYunMerchandiseSpec);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    List<TYunMerchandiseSpecEntity> getByMerchandiseId(String merchandiseId);
}
