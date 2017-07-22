package io.yun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunDemandDao;
import io.yun.entity.TYunDemandEntity;
import io.yun.service.TYunDemandService;



@Service("tYunDemandService")
public class TYunDemandServiceImpl implements TYunDemandService {
	@Autowired
	private TYunDemandDao tYunDemandDao;
	
	@Override
	public TYunDemandEntity queryObject(String id){
		return tYunDemandDao.queryObject(id);
	}
	
	@Override
	public List<TYunDemandEntity> queryList1(Map<String, Object> map){
		return tYunDemandDao.queryList1(map);
	}

	@Override
	public List<TYunDemandEntity> queryList(Map<String, Object> map){
		return tYunDemandDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunDemandDao.queryTotal(map);
	}

	@Override
	public int queryTotal1(Map<String, Object> map){
		return tYunDemandDao.queryTotal1(map);
	}

	@Override
	public void save(TYunDemandEntity tYunDemand){
		tYunDemandDao.save(tYunDemand);
	}

	@Override
	public void save1(TYunDemandEntity tYunDemand){
		tYunDemandDao.save1(tYunDemand);
	}
	
	@Override
	public void update(TYunDemandEntity tYunDemand){
		tYunDemandDao.update(tYunDemand);
	}
	
	@Override
	public void delete(String id){
		tYunDemandDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunDemandDao.deleteBatch(ids);
	}

}
