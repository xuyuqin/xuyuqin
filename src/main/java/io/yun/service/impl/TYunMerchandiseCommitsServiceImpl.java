package io.yun.service.impl;

import io.yun.dto.MerchandiseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunMerchandiseCommitsDao;
import io.yun.entity.TYunMerchandiseCommitsEntity;
import io.yun.service.TYunMerchandiseCommitsService;



@Service("tYunMerchandiseCommitsService")
public class TYunMerchandiseCommitsServiceImpl implements TYunMerchandiseCommitsService {
	@Autowired
	private TYunMerchandiseCommitsDao tYunMerchandiseCommitsDao;
	
	@Override
	public TYunMerchandiseCommitsEntity queryObject(String id){
		return tYunMerchandiseCommitsDao.queryObject(id);
	}
	
	@Override
	public List<TYunMerchandiseCommitsEntity> queryList(Map<String, Object> map){
		return tYunMerchandiseCommitsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunMerchandiseCommitsDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunMerchandiseCommitsEntity tYunMerchandiseCommits){
		tYunMerchandiseCommitsDao.save(tYunMerchandiseCommits);
	}
	
	@Override
	public void update(TYunMerchandiseCommitsEntity tYunMerchandiseCommits){
		tYunMerchandiseCommitsDao.update(tYunMerchandiseCommits);
	}
	
	@Override
	public void delete(String id){
		tYunMerchandiseCommitsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunMerchandiseCommitsDao.deleteBatch(ids);
	}

	@Override
	public List<MerchandiseDto> getByMerchandiseId(Map<String, Object> map){
		return tYunMerchandiseCommitsDao.getByMerchandiseId(map);
	}

	@Override
    public int listTotal(Map<String, Object> map){
	    return tYunMerchandiseCommitsDao.listTotal(map);
    }
}
