package io.yun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunDemandReplyDao;
import io.yun.entity.TYunDemandReplyEntity;
import io.yun.service.TYunDemandReplyService;



@Service("tYunDemandReplyService")
public class TYunDemandReplyServiceImpl implements TYunDemandReplyService {
	@Autowired
	private TYunDemandReplyDao tYunDemandReplyDao;
	
	@Override
	public TYunDemandReplyEntity queryObject(String id){
		return tYunDemandReplyDao.queryObject(id);
	}
	
	@Override
	public List<TYunDemandReplyEntity> queryList(Map<String, Object> map){
		return tYunDemandReplyDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunDemandReplyDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunDemandReplyEntity tYunDemandReply){
		tYunDemandReplyDao.save(tYunDemandReply);
	}
	
	@Override
	public void update(TYunDemandReplyEntity tYunDemandReply){
		tYunDemandReplyDao.update(tYunDemandReply);
	}
	
	@Override
	public void delete(String id){
		tYunDemandReplyDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunDemandReplyDao.deleteBatch(ids);
	}
	
}
