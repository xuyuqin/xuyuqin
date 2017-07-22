package io.yun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunNewsDao;
import io.yun.entity.TYunNewsEntity;
import io.yun.service.TYunNewsService;



@Service("tYunNewsService")
public class TYunNewsServiceImpl implements TYunNewsService {
	@Autowired
	private TYunNewsDao tYunNewsDao;
	
	@Override
	public TYunNewsEntity queryObject(String id){
		return tYunNewsDao.queryObject(id);
	}
	
	@Override
	public List<TYunNewsEntity> queryList(Map<String, Object> map){
		return tYunNewsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunNewsDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunNewsEntity tYunNews){
		tYunNewsDao.save(tYunNews);
	}
	
	@Override
	public void update(TYunNewsEntity tYunNews){
		tYunNewsDao.update(tYunNews);
	}
	
	@Override
	public void delete(String id){
		tYunNewsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunNewsDao.deleteBatch(ids);
	}
	
}
