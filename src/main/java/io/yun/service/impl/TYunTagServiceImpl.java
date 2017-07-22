package io.yun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunTagDao;
import io.yun.entity.TYunTagEntity;
import io.yun.service.TYunTagService;



@Service("tYunTagService")
public class TYunTagServiceImpl implements TYunTagService {
	@Autowired
	private TYunTagDao tYunTagDao;
	
	@Override
	public TYunTagEntity queryObject(String id){
		return tYunTagDao.queryObject(id);
	}
	
	@Override
	public List<TYunTagEntity> queryList(Map<String, Object> map){
		return tYunTagDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunTagDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunTagEntity tYunTag){
		tYunTagDao.save(tYunTag);
	}
	
	@Override
	public void update(TYunTagEntity tYunTag){
		tYunTagDao.update(tYunTag);
	}
	
	@Override
	public void delete(String id){
		tYunTagDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunTagDao.deleteBatch(ids);
	}
	
}
