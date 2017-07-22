package io.unicall.bgyun.service;

import java.util.List;
import java.util.Map;

import io.unicall.bgyun.entity.BgTYunProductEntity;


public interface BgTYunProductService {
	
	List<Object> queryCategory();
	List<Object> queryVariety();
	List<Object> queryVarietyByCategoryName(String s);
	List<Object> queryList(Map<String, Object> map);
	int queryTotal(Map<String, Object> map);
	Object queryObject(Map<String,Object> map);
	void deleteBatch(String[] id);


	void save(BgTYunProductEntity tYunProductEntity);
	void update(BgTYunProductEntity tYunProductEntity);

	

}
