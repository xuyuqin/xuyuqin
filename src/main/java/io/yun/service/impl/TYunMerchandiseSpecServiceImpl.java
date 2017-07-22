package io.yun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunMerchandiseSpecDao;
import io.yun.entity.TYunMerchandiseSpecEntity;
import io.yun.service.TYunMerchandiseSpecService;



@Service("tYunMerchandiseSpecService")
public class TYunMerchandiseSpecServiceImpl implements TYunMerchandiseSpecService {
	@Autowired
	private TYunMerchandiseSpecDao tYunMerchandiseSpecDao;
	
	@Override
	public TYunMerchandiseSpecEntity queryObject(String id){
		return tYunMerchandiseSpecDao.queryObject(id);
	}
	
	@Override
	public List<TYunMerchandiseSpecEntity> queryList(Map<String, Object> map){
		return tYunMerchandiseSpecDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunMerchandiseSpecDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunMerchandiseSpecEntity tYunMerchandiseSpec){
		tYunMerchandiseSpecDao.save(tYunMerchandiseSpec);
	}
	
	@Override
	public void update(TYunMerchandiseSpecEntity tYunMerchandiseSpec){
		tYunMerchandiseSpecDao.update(tYunMerchandiseSpec);
	}
	
	@Override
	public void delete(String id){
		tYunMerchandiseSpecDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunMerchandiseSpecDao.deleteBatch(ids);
	}

	@Override
	public List<TYunMerchandiseSpecEntity> getByMerchandiseId(String merchandiseId){
		return tYunMerchandiseSpecDao.getByMerchandiseId(merchandiseId);
	}
}
