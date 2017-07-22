package io.yun.service.impl;

import io.unicall.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunProviderCollectionDao;
import io.yun.entity.TYunProviderCollectionEntity;
import io.yun.service.TYunProviderCollectionService;



@Service("tYunProviderCollectionService")
public class TYunProviderCollectionServiceImpl implements TYunProviderCollectionService {
	@Autowired
	private TYunProviderCollectionDao tYunProviderCollectionDao;
	
	@Override
	public TYunProviderCollectionEntity queryObject(String id){
		return tYunProviderCollectionDao.queryObject(id);
	}
	
	@Override
	public List<TYunProviderCollectionEntity> queryList(Map<String, Object> map){
		return tYunProviderCollectionDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunProviderCollectionDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunProviderCollectionEntity tYunProviderCollection){
		tYunProviderCollectionDao.save(tYunProviderCollection);
	}
	
	@Override
	public void update(TYunProviderCollectionEntity tYunProviderCollection){
		tYunProviderCollectionDao.update(tYunProviderCollection);
	}
	
	@Override
	public void delete(String id){
		tYunProviderCollectionDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunProviderCollectionDao.deleteBatch(ids);
	}

	@Override
	public TYunProviderCollectionEntity find(Query query) {
		return tYunProviderCollectionDao.find(query);
	}

	@Override
	public TYunProviderCollectionEntity find(Map<String, Object> map) {
		return tYunProviderCollectionDao.find(map);
	}
}
