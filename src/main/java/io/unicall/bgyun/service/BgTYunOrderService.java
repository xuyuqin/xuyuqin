package io.unicall.bgyun.service;

import io.unicall.bgyun.entity.BgTYunProductEntity;
import io.yun.entity.TYunOrderEntity;

import java.util.List;
import java.util.Map;


public interface BgTYunOrderService {

//	List<Object> queryCategory();
//	List<Object> queryVariety();
//	List<Object> queryVarietyByCategoryName(String s);
	List<Object> queryList(Map<String, Object> map);
	int queryTotal(Map<String, Object> map);
	Object queryObject(Object id);
//	void deleteBatch(String[] id);
//
//
//	void save(BgTYunProductEntity tYunProductEntity);
//	void update(BgTYunProductEntity tYunProductEntity);
    TYunOrderEntity queryByOrderNo(String orderNo);
	void updateDeliverStatus(String orderNo);



	

}
