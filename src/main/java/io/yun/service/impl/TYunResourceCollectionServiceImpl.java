package io.yun.service.impl;

import io.unicall.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunResourceCollectionDao;
import io.yun.entity.TYunResourceCollectionEntity;
import io.yun.service.TYunResourceCollectionService;



@Service("tYunResourceCollectionService")
public class TYunResourceCollectionServiceImpl implements TYunResourceCollectionService {
	@Autowired
	private TYunResourceCollectionDao tYunResourceCollectionDao;
	
	@Override
	public TYunResourceCollectionEntity queryObject(String id){
		return tYunResourceCollectionDao.queryObject(id);
	}
	
	@Override
	public List<TYunResourceCollectionEntity> queryList(Map<String, Object> map){
		return tYunResourceCollectionDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunResourceCollectionDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunResourceCollectionEntity tYunResourceCollection){
		tYunResourceCollectionDao.save(tYunResourceCollection);
	}
	
	@Override
	public void update(TYunResourceCollectionEntity tYunResourceCollection){
		tYunResourceCollectionDao.update(tYunResourceCollection);
	}
	
	@Override
	public void delete(String id){
		tYunResourceCollectionDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunResourceCollectionDao.deleteBatch(ids);
	}

	@Override
	public TYunResourceCollectionEntity find(Query query) {
		return tYunResourceCollectionDao.find(query);
	}

}
