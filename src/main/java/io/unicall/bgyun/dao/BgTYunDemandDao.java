package io.unicall.bgyun.dao;

import java.util.List;
import java.util.Map;

import io.unicall.dao.BaseDao;
import io.yun.entity.TYunDemandEntity;;
public interface BgTYunDemandDao extends BaseDao<TYunDemandEntity>{
	
	List<TYunDemandEntity> queryMyList(Map<String, Object> map);
	int queryMyTotal(Map<String, Object> map);
	
	void updateIsPermit(TYunDemandEntity tYunDemandEntity);


}
