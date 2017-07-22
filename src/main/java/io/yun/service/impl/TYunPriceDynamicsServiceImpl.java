package io.yun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunPriceDynamicsDao;
import io.yun.entity.TYunPriceDynamicsEntity;
import io.yun.service.TYunPriceDynamicsService;



@Service("tYunPriceDynamicsService")
public class TYunPriceDynamicsServiceImpl implements TYunPriceDynamicsService {
	@Autowired
	private TYunPriceDynamicsDao tYunPriceDynamicsDao;
	
	@Override
	public TYunPriceDynamicsEntity queryObject(String id){
		return tYunPriceDynamicsDao.queryObject(id);
	}
	
	@Override
	public List<TYunPriceDynamicsEntity> queryList(Map<String, Object> map){
		return tYunPriceDynamicsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunPriceDynamicsDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunPriceDynamicsEntity tYunPriceDynamics){
		tYunPriceDynamicsDao.save(tYunPriceDynamics);
	}
	
	@Override
	public void update(TYunPriceDynamicsEntity tYunPriceDynamics){
		tYunPriceDynamicsDao.update(tYunPriceDynamics);
	}
	
	@Override
	public void delete(String id){
		tYunPriceDynamicsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunPriceDynamicsDao.deleteBatch(ids);
	}
	
}
