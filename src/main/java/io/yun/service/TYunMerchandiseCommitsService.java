package io.yun.service;

import io.yun.dto.MerchandiseDto;
import io.yun.entity.TYunMerchandiseCommitsEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品评价表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:31
 */
public interface TYunMerchandiseCommitsService {
	
	TYunMerchandiseCommitsEntity queryObject(String id);
	
	List<TYunMerchandiseCommitsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunMerchandiseCommitsEntity tYunMerchandiseCommits);
	
	void update(TYunMerchandiseCommitsEntity tYunMerchandiseCommits);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    List<MerchandiseDto> getByMerchandiseId(Map<String, Object> map);

    int listTotal(Map<String, Object> map);
}
