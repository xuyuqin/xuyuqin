package io.unicall.bgyun.service;

import java.util.List;
import java.util.Map;

import io.yun.entity.TYunDemandEntity;

public interface BgTYunDemandService {
	List<TYunDemandEntity> queryList(Map<String, Object> map);
	int queryTotal(Map<String, Object> map);
	Object queryObject(Map<String,Object> map);
	
	List<TYunDemandEntity> queryMyList(Map<String, Object> map);
	int queryMyTotal(Map<String, Object> map);
	
	void deleteBatch(String[] id);
	void permit(TYunDemandEntity tYunDemandEntity);

}
