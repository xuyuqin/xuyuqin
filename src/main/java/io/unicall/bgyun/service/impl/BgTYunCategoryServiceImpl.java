package io.unicall.bgyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.unicall.bgyun.dao.BgTYunCategoryDao;
import io.unicall.bgyun.service.BgTYunCategoryService;
import io.yun.entity.TYunCategoryEntity;

@Service("bgTYunCategoryService")
public class BgTYunCategoryServiceImpl implements BgTYunCategoryService{
	
	@Autowired
	private BgTYunCategoryDao bgTYunCategoryDao;

	@Override
	public List<Object> queryCategory() {
		return bgTYunCategoryDao.queryCategory();
	}

	@Override
	public List<Object> queryVarietyByCategoryId(int id) {
		return bgTYunCategoryDao.queryVarietyByCategoryId(id);
	}

	@Override
	public void update(TYunCategoryEntity tYunCategoryEntity) {
		bgTYunCategoryDao.update(tYunCategoryEntity);
		
	}

	@Override
	public Object queryObject(int id) {
		return bgTYunCategoryDao.queryObject(id);
	}

	@Override
	public void deleteBatch(String[] ids) {
		 bgTYunCategoryDao.deleteBatch(ids);
		
	}

	@Override
	public void save(TYunCategoryEntity tYunCategoryEntity) {
		bgTYunCategoryDao.save(tYunCategoryEntity);
		
	}

}
