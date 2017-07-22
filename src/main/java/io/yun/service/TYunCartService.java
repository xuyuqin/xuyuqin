package io.yun.service;

import io.yun.entity.TYunCartEntity;

import java.util.List;
import java.util.Map;

/**
 * 购物车表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:32
 */
public interface TYunCartService {
	
	TYunCartEntity queryObject(String id);
	
	List<TYunCartEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunCartEntity tYunCart);
	
	void update(TYunCartEntity tYunCart);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	TYunCartEntity findByMemberAndMerchandise(String memberId, String MerchandisId);
}
