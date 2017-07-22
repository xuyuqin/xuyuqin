package io.unicall.bgyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.unicall.bgyun.dao.BgTYunMerchandiseDao;
import io.unicall.bgyun.service.BgTYunMerchandiseService;
import io.yun.entity.TYunMerchandiseEntity;

import java.util.List;
import java.util.Map;





@Service("bgTYunMerchandiseService")
public class BgTYunMerchandiseServiceImpl implements BgTYunMerchandiseService {
	@Autowired
	private BgTYunMerchandiseDao tYunMerchandiseDao;
	
	@Override
	public TYunMerchandiseEntity queryObject(String id){
		return tYunMerchandiseDao.queryObject(id);
	}
	
	@Override
	public List<TYunMerchandiseEntity> queryList(Map<String, Object> map){
		return tYunMerchandiseDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunMerchandiseDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunMerchandiseEntity tYunMerchandise){
		tYunMerchandiseDao.save(tYunMerchandise);
	}
	
	@Override
	public void update(TYunMerchandiseEntity tYunMerchandise){
		tYunMerchandiseDao.update(tYunMerchandise);
	}
	
	@Override
	public void delete(String id){
		tYunMerchandiseDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunMerchandiseDao.deleteBatch(ids);
	}
	
}
