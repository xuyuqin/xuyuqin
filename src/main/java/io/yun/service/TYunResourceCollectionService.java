package io.yun.service;

import io.unicall.utils.Query;
import io.yun.entity.TYunResourceCollectionEntity;

import java.util.List;
import java.util.Map;

/**
 * 资源单-用户关系表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-19 13:52:10
 */
public interface TYunResourceCollectionService {
	
	TYunResourceCollectionEntity queryObject(String id);
	
	List<TYunResourceCollectionEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunResourceCollectionEntity tYunResourceCollection);
	
	void update(TYunResourceCollectionEntity tYunResourceCollection);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);


	TYunResourceCollectionEntity find(Query query);
}
