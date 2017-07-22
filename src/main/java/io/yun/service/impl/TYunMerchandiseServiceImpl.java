package io.yun.service.impl;

import io.yun.dao.TYunMerchandiseDao;
import io.yun.dto.MerchandiseDto;
import io.yun.entity.TYunMerchandiseEntity;
import io.yun.service.TYunMerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("tYunMerchandiseService")
public class TYunMerchandiseServiceImpl implements TYunMerchandiseService {
	@Autowired
	private TYunMerchandiseDao tYunMerchandiseDao;
	
	@Override
	public TYunMerchandiseEntity queryObject(String id){
		return tYunMerchandiseDao.queryObject(id);
	}
	
	@Override
	public List<TYunMerchandiseEntity> queryList(Map<String, Object> map){
		return tYunMerchandiseDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunMerchandiseDao.queryTotal(map);
	}

	@Override
	public void save(TYunMerchandiseEntity tYunMerchandise){
		tYunMerchandiseDao.save(tYunMerchandise);
	}
	
	@Override
	public void update(TYunMerchandiseEntity tYunMerchandise){
		tYunMerchandiseDao.update(tYunMerchandise);
	}
	
	@Override
	public void delete(String id){
		tYunMerchandiseDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunMerchandiseDao.deleteBatch(ids);
	}

	@Override
	public List<MerchandiseDto> getByProviderId(Map<String, Object> map){
		return tYunMerchandiseDao.getByProviderId(map);
	}

    @Override
    public int getByProviderIdTotal(String providerId){
        return tYunMerchandiseDao.getByProviderIdTotal(providerId);
    }

	@Override
	public void saveImg(String merchandiseId, String url) {
		tYunMerchandiseDao.saveImg(merchandiseId,url);
	}
}
