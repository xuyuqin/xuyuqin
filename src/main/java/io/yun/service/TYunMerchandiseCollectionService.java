package io.yun.service;

import io.unicall.utils.Query;
import io.yun.entity.TYunMerchandiseCollectionEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品收藏表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-16 10:38:12
 */
public interface TYunMerchandiseCollectionService {
	
	TYunMerchandiseCollectionEntity queryObject(String id);
	
	List<TYunMerchandiseCollectionEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunMerchandiseCollectionEntity tYunMerchandiseCollection);
	
	void update(TYunMerchandiseCollectionEntity tYunMerchandiseCollection);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    TYunMerchandiseCollectionEntity find(Query query);

	TYunMerchandiseCollectionEntity find(Map<String, Object> map);
}
