package io.yun.service;

import io.unicall.utils.Query;
import io.yun.entity.TYunProviderCollectionEntity;

import java.util.List;
import java.util.Map;

/**
 * 供应商收藏
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-29 14:16:31
 */
public interface TYunProviderCollectionService {
	
	TYunProviderCollectionEntity queryObject(String id);
	
	List<TYunProviderCollectionEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunProviderCollectionEntity tYunProviderCollection);
	
	void update(TYunProviderCollectionEntity tYunProviderCollection);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    TYunProviderCollectionEntity find(Query query);

	TYunProviderCollectionEntity find(Map<String, Object> map);
}
