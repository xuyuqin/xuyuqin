package io.yun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunMerchandiseImageDao;
import io.yun.entity.TYunMerchandiseImageEntity;
import io.yun.service.TYunMerchandiseImageService;



@Service("tYunMerchandiseImageService")
public class TYunMerchandiseImageServiceImpl implements TYunMerchandiseImageService {
	@Autowired
	private TYunMerchandiseImageDao tYunMerchandiseImageDao;
	
	@Override
	public TYunMerchandiseImageEntity queryObject(String id){
		return tYunMerchandiseImageDao.queryObject(id);
	}
	
	@Override
	public List<TYunMerchandiseImageEntity> queryList(Map<String, Object> map){
		return tYunMerchandiseImageDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunMerchandiseImageDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunMerchandiseImageEntity tYunMerchandiseImage){
		tYunMerchandiseImageDao.save(tYunMerchandiseImage);
	}
	
	@Override
	public void update(TYunMerchandiseImageEntity tYunMerchandiseImage){
		tYunMerchandiseImageDao.update(tYunMerchandiseImage);
	}
	
	@Override
	public void delete(String id){
		tYunMerchandiseImageDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunMerchandiseImageDao.deleteBatch(ids);
	}

	@Override
	public List<TYunMerchandiseImageEntity> getByMerchandiseId(String merchandiseId){
		return tYunMerchandiseImageDao.getByMerchandiseId(merchandiseId);
	}

	@Override
	public int queryTotal(String[] ids, String merchandiseId) {
		return tYunMerchandiseImageDao.queryTotal2(ids,merchandiseId);
	}

}
