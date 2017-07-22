package io.yun.service;

import io.yun.entity.TYunCategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品类别表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-19 16:20:37
 */
public interface TYunCategoryService {
	
	TYunCategoryEntity queryObject(String id);
	
	List<TYunCategoryEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunCategoryEntity tYunCategory);
	
	void update(TYunCategoryEntity tYunCategory);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
