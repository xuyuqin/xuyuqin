package io.yun.service;

import io.unicall.utils.Query;
import io.yun.entity.TYunResourceEntity;

import java.util.List;
import java.util.Map;

/**
 * 资源单表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-19 13:52:09
 */
public interface TYunResourceService {
	
	TYunResourceEntity queryObject(String id);
	
	List<TYunResourceEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunResourceEntity tYunResource);
	
	void update(TYunResourceEntity tYunResource);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    TYunResourceEntity queryObject(Query query);
}
