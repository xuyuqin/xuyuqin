package io.unicall.bgyun.service.impl;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.unicall.bgyun.dao.BgTYunProductDao;
import io.unicall.bgyun.service.BgTYunProductService;
import io.unicall.bgyun.entity.BgTYunProductEntity;
import io.yun.entity.TYunProductImageEntity;

@Service("bgTYunProductService")
@Transactional
public class BgTYunProductServiceImpl implements BgTYunProductService {
	
	@Autowired
	private BgTYunProductDao bgTYunProductDao;

	

	@Override
	public List<Object> queryCategory() {
	   return bgTYunProductDao.queryCategory();
	}


	@Override
	public List<Object> queryVariety() {
		
		return bgTYunProductDao.queryVariety();
	}


	@Override
	public List<Object> queryList(Map<String, Object> map) {
		
		return bgTYunProductDao.queryList(map);
	}


	@Override
	public int queryTotal(Map<String, Object> map) {
	
		return bgTYunProductDao.queryTotal(map);
	}


	@Override
	public Object queryObject(Map<String, Object> map) {
		return bgTYunProductDao.queryObject(map);
	}


	@Override
	public void deleteBatch(String[] ids) {
		bgTYunProductDao.deleteBatch(ids);
		
	}


	@Override
	@Transactional
	public void save(BgTYunProductEntity tYunProductEntity) {
		
		 TYunProductImageEntity tYunProductImageEntity = new TYunProductImageEntity();
		 tYunProductEntity.setEditTime(new Date());
		 bgTYunProductDao.save(tYunProductEntity);	 
		 tYunProductImageEntity.setProductId(tYunProductEntity.getId());		 
		 bgTYunProductDao.saveImage(tYunProductImageEntity);
		
	}


	@Override
	@Transactional
	public void update(BgTYunProductEntity tYunProductEntity) {
		bgTYunProductDao.update(tYunProductEntity);
	
	}


	@Override
	public List<Object> queryVarietyByCategoryName(String s) {
		return bgTYunProductDao.queryVarietyByCategoryName(s);
	}




}
