package io.yun.service;

import io.yun.entity.TYunDemandEntity;

import java.util.List;
import java.util.Map;

/**
 * 求购单表
 * 
 * @author unicall
 * @email bq.zhu@unicall.com
 * @date 2017-06-27 15:39:20
 */
public interface TYunDemandService {
	
	TYunDemandEntity queryObject(String id);

	List<TYunDemandEntity> queryList1(Map<String, Object> map);

	List<TYunDemandEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);

	int queryTotal1(Map<String, Object> map);

	void save(TYunDemandEntity tYunDemand);

	void save1(TYunDemandEntity tYunDemand);
	
	void update(TYunDemandEntity tYunDemand);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
