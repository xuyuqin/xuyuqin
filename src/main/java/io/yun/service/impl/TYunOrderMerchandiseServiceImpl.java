package io.yun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunOrderMerchandiseDao;
import io.yun.entity.TYunOrderMerchandiseEntity;
import io.yun.service.TYunOrderMerchandiseService;



@Service("tYunOrderMerchandiseService")
public class TYunOrderMerchandiseServiceImpl implements TYunOrderMerchandiseService {
	@Autowired
	private TYunOrderMerchandiseDao tYunOrderMerchandiseDao;
	
	@Override
	public TYunOrderMerchandiseEntity queryObject(String id){
		return tYunOrderMerchandiseDao.queryObject(id);
	}
	
	@Override
	public List<TYunOrderMerchandiseEntity> queryList(Map<String, Object> map){
		return tYunOrderMerchandiseDao.queryList(map);
	}

	@Override
	public List<TYunOrderMerchandiseEntity> getBuyPrice(String productid){
		return tYunOrderMerchandiseDao.getBuyPrice(productid);
	};

	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunOrderMerchandiseDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunOrderMerchandiseEntity tYunOrderMerchandise){
		tYunOrderMerchandiseDao.save(tYunOrderMerchandise);
	}
	
	@Override
	public void update(TYunOrderMerchandiseEntity tYunOrderMerchandise){
		tYunOrderMerchandiseDao.update(tYunOrderMerchandise);
	}
	
	@Override
	public void delete(String id){
		tYunOrderMerchandiseDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunOrderMerchandiseDao.deleteBatch(ids);
	}
	
}
