package io.unicall.bgyun.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.unicall.bgyun.dao.BgTYunResourceDao;
import io.unicall.bgyun.service.BgTYunResourceService;
import io.yun.entity.TYunResourceEntity;


@Service("bgTYunResourceService")
public class BgTYunResourceServiceImpl implements BgTYunResourceService {
	
	@Autowired
	private BgTYunResourceDao bgTYunResourceDao;
	

	@Override
	public List<TYunResourceEntity> queryMyList(Map<String, Object> map) {
		return bgTYunResourceDao.queryMyList(map);
	}

	@Override
	public int queryMyTotal(Map<String, Object> map) {
		return bgTYunResourceDao.queryMyTotal(map);
	}
	@Override
	public TYunResourceEntity queryObject(Map<String, Object> map) {
		return bgTYunResourceDao.queryObject(map);
	}

	@Override
	public void deleteBatch(String[] ids) {
		System.out.println(ids[0]);
		bgTYunResourceDao.deleteBatch(ids);
		
	}

	@Override
	public void permit(TYunResourceEntity tYunResourceEntity) {
		bgTYunResourceDao.updateIsPermit(tYunResourceEntity);
		
	}

	@Override
	public List<TYunResourceEntity> queryList(Map<String, Object> map) {
		return bgTYunResourceDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return bgTYunResourceDao.queryTotal(map);
	}


}
