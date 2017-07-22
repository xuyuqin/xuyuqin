package io.unicall.bgyun.dao;


import io.unicall.dao.BaseDao;
import io.yun.entity.TYunOrderEntity;
import io.yun.entity.TYunProductImageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BgTYunOrderDao extends BaseDao<Object>{
	
//	List<Object> queryCategory();
//	List<Object> queryVariety();
//	List<Object> queryVarietyByCategoryName(String s);
//	void saveImage(TYunProductImageEntity tYunProductImageEntity);
//	void updateImage(TYunProductImageEntity tYunProductImageEntity);
	TYunOrderEntity queryByOrderNo(@Param("orderNo") String orderNo);
	void updateDeliverStatus(@Param("orderNo") String orderNo);

}
