package io.yun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunOrderDao;
import io.yun.entity.TYunOrderEntity;
import io.yun.service.TYunOrderService;



@Service("tYunOrderService")
public class TYunOrderServiceImpl implements TYunOrderService {
	@Autowired
	private TYunOrderDao tYunOrderDao;
	
	@Override
	public TYunOrderEntity queryObject(String id){
		return tYunOrderDao.queryObject(id);
	}
	
	@Override
	public List<TYunOrderEntity> queryList(Map<String, Object> map){
		return tYunOrderDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunOrderDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunOrderEntity tYunOrder){
		tYunOrderDao.save(tYunOrder);
	}
	
	@Override
	public void update(TYunOrderEntity tYunOrder){
		tYunOrderDao.update(tYunOrder);
	}
	
	@Override
	public void delete(String id){
		tYunOrderDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunOrderDao.deleteBatch(ids);
	}

	@Override
	public int queryOrderNumToday(){
		return tYunOrderDao.queryOrderNumToday();
	}
	
}
