package io.yun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import io.yun.dao.TYunMarketingDao;
import io.yun.entity.TYunMarketingEntity;
import io.yun.service.TYunMarketingService;



@Service("tYunMarketingService")
public class TYunMarketingServiceImpl implements TYunMarketingService {
	@Autowired
	private TYunMarketingDao tYunMarketingDao;
	
	@Override
	public TYunMarketingEntity queryObject(String id){
		return tYunMarketingDao.queryObject(id);
	}
	
	@Override
	public List<TYunMarketingEntity> queryList(Map<String, Object> map){
		return tYunMarketingDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunMarketingDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunMarketingEntity tYunMarketing){
		tYunMarketingDao.save(tYunMarketing);
	}
	
	@Override
	public void update(TYunMarketingEntity tYunMarketing){
		tYunMarketingDao.update(tYunMarketing);
	}
	
	@Override
	public void delete(String id){
		tYunMarketingDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunMarketingDao.deleteBatch(ids);
	}

	@Override
	public List<Map<String, Integer>> queryStatus(Map<String, Object> params) {
		return tYunMarketingDao.queryStatus(params);
	}

	@Override
	public void saveMerchandise(String marketingId, String merchandiseId) {
		tYunMarketingDao.saveMerchandise(marketingId,merchandiseId);
	}

	@Override
	public void deleteMerchandise(String marketingId, Set<String> merchandiseIds) {
		tYunMarketingDao.deleteMerchandise(marketingId,merchandiseIds);
	}

	@Override
	public void deleteAllMerchandise(String marketingId) {
		tYunMarketingDao.deleteAllMerchandise(marketingId);
	}

}
