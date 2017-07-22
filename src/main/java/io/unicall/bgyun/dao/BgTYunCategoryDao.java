package io.unicall.bgyun.dao;


import java.util.List;

import io.unicall.dao.BaseDao;


public interface BgTYunCategoryDao extends BaseDao<Object>{
	
	List<Object> queryVarietyByCategoryId(int id);
	List<Object> queryCategory();

}
