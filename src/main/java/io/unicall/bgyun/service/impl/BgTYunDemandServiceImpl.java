package io.unicall.bgyun.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.unicall.bgyun.dao.BgTYunDemandDao;
import io.unicall.bgyun.service.BgTYunDemandService;
import io.yun.entity.TYunDemandEntity;

@Service("bgTYunDemandService")
public class BgTYunDemandServiceImpl implements BgTYunDemandService {
	
	@Autowired
	private BgTYunDemandDao bgTYunDemandDao;

	@Override
	public List<TYunDemandEntity> queryList(Map<String, Object> map) {
		return bgTYunDemandDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return bgTYunDemandDao.queryTotal(map);
	}

	@Override
	public Object queryObject(Map<String, Object> map) {
		return bgTYunDemandDao.queryObject(map);
	}

	@Override
	public List<TYunDemandEntity> queryMyList(Map<String, Object> map) {
		return bgTYunDemandDao.queryMyList(map);
	}

	@Override
	public int queryMyTotal(Map<String, Object> map) {
		return bgTYunDemandDao.queryMyTotal(map);
	}

	@Override
	public void deleteBatch(String[] ids) {
		bgTYunDemandDao.deleteBatch(ids);
		
	}

	@Override
	public void permit(TYunDemandEntity tYunDemandEntity) {
		bgTYunDemandDao.updateIsPermit(tYunDemandEntity);
		
	}
	
	

}
