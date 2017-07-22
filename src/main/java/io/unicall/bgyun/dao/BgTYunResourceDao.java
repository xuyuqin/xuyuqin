package io.unicall.bgyun.dao;



import java.util.List;
import java.util.Map;

import io.unicall.dao.BaseDao;
import io.yun.entity.TYunResourceEntity;
public interface BgTYunResourceDao extends BaseDao<TYunResourceEntity>{
	
	List<TYunResourceEntity> queryMyList(Map<String, Object> map);
	int queryMyTotal(Map<String, Object> map);
	
	
	void updateIsPermit(TYunResourceEntity tYunResourceEntity);

	
}
