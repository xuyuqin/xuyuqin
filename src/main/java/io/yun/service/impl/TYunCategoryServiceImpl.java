package io.yun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunCategoryDao;
import io.yun.entity.TYunCategoryEntity;
import io.yun.service.TYunCategoryService;



@Service("tYunCategoryService")
public class TYunCategoryServiceImpl implements TYunCategoryService {
	@Autowired
	private TYunCategoryDao tYunCategoryDao;
	
	@Override
	public TYunCategoryEntity queryObject(String id){
		return tYunCategoryDao.queryObject(id);
	}
	
	@Override
	public List<TYunCategoryEntity> queryList(Map<String, Object> map){
		return tYunCategoryDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunCategoryDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunCategoryEntity tYunCategory){
		tYunCategoryDao.save(tYunCategory);
	}
	
	@Override
	public void update(TYunCategoryEntity tYunCategory){
		tYunCategoryDao.update(tYunCategory);
	}
	
	@Override
	public void delete(String id){
		tYunCategoryDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunCategoryDao.deleteBatch(ids);
	}
	
}
