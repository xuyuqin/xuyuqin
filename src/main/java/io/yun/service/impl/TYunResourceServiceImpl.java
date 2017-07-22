package io.yun.service.impl;

import io.unicall.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunResourceDao;
import io.yun.entity.TYunResourceEntity;
import io.yun.service.TYunResourceService;



@Service("tYunResourceService")
public class TYunResourceServiceImpl implements TYunResourceService {
	@Autowired
	private TYunResourceDao tYunResourceDao;
	
	@Override
	public TYunResourceEntity queryObject(String id){
		return tYunResourceDao.queryObject(id);
	}
	
	@Override
	public List<TYunResourceEntity> queryList(Map<String, Object> map){
		return tYunResourceDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunResourceDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunResourceEntity tYunResource){
		tYunResourceDao.save(tYunResource);
	}
	
	@Override
	public void update(TYunResourceEntity tYunResource){
		tYunResourceDao.update(tYunResource);
	}
	
	@Override
	public void delete(String id){
		tYunResourceDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunResourceDao.deleteBatch(ids);
	}

	@Override
	public TYunResourceEntity queryObject(Query query) {
		return tYunResourceDao.queryResource(query);
	}

}
