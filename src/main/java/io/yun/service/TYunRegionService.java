package io.yun.service;

import io.yun.entity.TYunRegionEntity;

import java.util.List;
import java.util.Map;

/**
 * 地区表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-22 15:38:04
 */
public interface TYunRegionService {
	
	TYunRegionEntity queryObject(String code);
	
	List<TYunRegionEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunRegionEntity tYunRegion);
	
	void update(TYunRegionEntity tYunRegion);
	
	void delete(String code);
	
	void deleteBatch(String[] codes);
}
