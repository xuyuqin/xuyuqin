package io.yun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunProviderVipDao;
import io.yun.entity.TYunProviderVipEntity;
import io.yun.service.TYunProviderVipService;



@Service("tYunProviderVipService")
public class TYunProviderVipServiceImpl implements TYunProviderVipService {
	@Autowired
	private TYunProviderVipDao tYunProviderVipDao;
	
	@Override
	public TYunProviderVipEntity queryObject(Integer id){
		return tYunProviderVipDao.queryObject(id);
	}
	
	@Override
	public List<TYunProviderVipEntity> queryList(Map<String, Object> map){
		return tYunProviderVipDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunProviderVipDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunProviderVipEntity tYunProviderVip){
		tYunProviderVipDao.save(tYunProviderVip);
	}
	
	@Override
	public void update(TYunProviderVipEntity tYunProviderVip){
		tYunProviderVipDao.update(tYunProviderVip);
	}
	
	@Override
	public void delete(Integer id){
		tYunProviderVipDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		tYunProviderVipDao.deleteBatch(ids);
	}

	@Override
	public TYunProviderVipEntity getByProviderAndMember(Map<String, Object> map){
		return tYunProviderVipDao.getByProviderIdAndMemberId(map);
	}
}
