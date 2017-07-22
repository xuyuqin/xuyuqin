package io.unicall.bgyun.dao;


import java.util.List;

import io.unicall.dao.BaseDao;
import io.yun.entity.TYunProductImageEntity;

public interface BgTYunProductDao extends BaseDao<Object>{
	
	List<Object> queryCategory();
	List<Object> queryVariety();
	List<Object> queryVarietyByCategoryName(String s);
	void saveImage(TYunProductImageEntity tYunProductImageEntity);
	void updateImage(TYunProductImageEntity tYunProductImageEntity);
	

}
