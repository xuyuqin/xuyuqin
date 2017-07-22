package io.yun.service;

import io.yun.entity.TYunNewsEntity;

import java.util.List;
import java.util.Map;

/**
 * 新闻资讯表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:31
 */
public interface TYunNewsService {
	
	TYunNewsEntity queryObject(String id);
	
	List<TYunNewsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunNewsEntity tYunNews);
	
	void update(TYunNewsEntity tYunNews);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
