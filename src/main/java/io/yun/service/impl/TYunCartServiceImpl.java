package io.yun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunCartDao;
import io.yun.entity.TYunCartEntity;
import io.yun.service.TYunCartService;



@Service("tYunCartService")
public class TYunCartServiceImpl implements TYunCartService {
	@Autowired
	private TYunCartDao tYunCartDao;
	
	@Override
	public TYunCartEntity queryObject(String id){
		return tYunCartDao.queryObject(id);
	}
	
	@Override
	public List<TYunCartEntity> queryList(Map<String, Object> map){
		return tYunCartDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunCartDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunCartEntity tYunCart){
		tYunCartDao.save(tYunCart);
	}
	
	@Override
	public void update(TYunCartEntity tYunCart){
		tYunCartDao.update(tYunCart);
	}
	
	@Override
	public void delete(String id){
		tYunCartDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunCartDao.deleteBatch(ids);
	}

	@Override
	public  TYunCartEntity findByMemberAndMerchandise(String memberId, String merchandisId){
		return tYunCartDao.findByMemberAndMerchandise(memberId, merchandisId);
	}
}
