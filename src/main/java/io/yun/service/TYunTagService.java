package io.yun.service;

import io.yun.entity.TYunTagEntity;

import java.util.List;
import java.util.Map;

/**
 * 产品标签表（百科按标签查找产品功能）
 * 
 * @author unicall
 * @email bq.zhu@unicall.com
 * @date 2017-06-23 11:15:52
 */
public interface TYunTagService {
	
	TYunTagEntity queryObject(String id);
	
	List<TYunTagEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunTagEntity tYunTag);
	
	void update(TYunTagEntity tYunTag);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
