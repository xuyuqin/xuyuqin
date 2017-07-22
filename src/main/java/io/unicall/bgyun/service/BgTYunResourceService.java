package io.unicall.bgyun.service;

import java.util.List;
import java.util.Map;


import io.yun.entity.TYunResourceEntity;

public interface BgTYunResourceService {
	
	List<TYunResourceEntity> queryList(Map<String, Object> map);
	int queryTotal(Map<String, Object> map);
	
	List<TYunResourceEntity> queryMyList(Map<String, Object> map);
	int queryMyTotal(Map<String, Object> map);
	TYunResourceEntity queryObject(Map<String, Object> map);
	void deleteBatch(String[] id);
	void permit(TYunResourceEntity tYunResourceEntity);
}
