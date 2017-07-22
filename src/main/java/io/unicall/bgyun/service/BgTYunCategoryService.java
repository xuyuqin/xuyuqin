package io.unicall.bgyun.service;

import java.util.List;

import io.yun.entity.TYunCategoryEntity;

public interface BgTYunCategoryService {
	List<Object> queryCategory();
	List<Object> queryVarietyByCategoryId(int id);
	
	Object queryObject(int id);
	void deleteBatch(String[] id);
	void save(TYunCategoryEntity tYunCategoryEntity);
	void update(TYunCategoryEntity tYunCategoryEntity);

}
