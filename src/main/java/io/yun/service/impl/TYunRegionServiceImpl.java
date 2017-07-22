package io.yun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunRegionDao;
import io.yun.entity.TYunRegionEntity;
import io.yun.service.TYunRegionService;



@Service("tYunRegionService")
public class TYunRegionServiceImpl implements TYunRegionService {
	@Autowired
	private TYunRegionDao tYunRegionDao;
	
	@Override
	public TYunRegionEntity queryObject(String code){
		return tYunRegionDao.queryObject(code);
	}
	
	@Override
	public List<TYunRegionEntity> queryList(Map<String, Object> map){
		return tYunRegionDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunRegionDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunRegionEntity tYunRegion){
		tYunRegionDao.save(tYunRegion);
	}
	
	@Override
	public void update(TYunRegionEntity tYunRegion){
		tYunRegionDao.update(tYunRegion);
	}
	
	@Override
	public void delete(String code){
		tYunRegionDao.delete(code);
	}
	
	@Override
	public void deleteBatch(String[] codes){
		tYunRegionDao.deleteBatch(codes);
	}
	
}
