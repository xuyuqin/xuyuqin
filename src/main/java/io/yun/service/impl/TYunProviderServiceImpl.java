package io.yun.service.impl;

import io.yun.dao.TYunProviderDao;
import io.yun.dto.BaikeDetailsDto;
import io.yun.dto.ProviderDto;
import io.yun.entity.TYunProviderEntity;
import io.yun.service.TYunProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;


@Service("tYunProviderService")
public class TYunProviderServiceImpl implements TYunProviderService {
	@Autowired
	private TYunProviderDao tYunProviderDao;
	
	@Override
	public TYunProviderEntity queryObject(String id){
		return tYunProviderDao.queryObject(id);
	}

	@Override
	public TYunProviderEntity getProviderId(String id){
		return tYunProviderDao.getProviderId(id);
	}

	@Override
	public List<ProviderDto> providerList(Map<String, Object> map){
		return tYunProviderDao.providerList(map);
	};

	@Override
	public List<TYunProviderEntity> queryList(Map<String, Object> map){
		return tYunProviderDao.queryList(map);
	}

	@Override
	public List<TYunProviderEntity> getProvider(String productid){
		return tYunProviderDao.getProvider(productid);
	};
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunProviderDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunProviderEntity tYunProvider){
		tYunProviderDao.save(tYunProvider);
	}
	
	@Override
	public void update(TYunProviderEntity tYunProvider){
		tYunProviderDao.update(tYunProvider);
	}
	
	@Override
	public void delete(String id){
		tYunProviderDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunProviderDao.deleteBatch(ids);
	}

	@Override
	public TYunProviderEntity findByMemberId(String id) {
		return tYunProviderDao.findByMemberId(id);
	}

	@Override
	public void saveProduct(String providerId, String productId) {
		tYunProviderDao.saveProduct(providerId,productId);
	}

	@Override
	public void deleteProduct(String providerId, Set productId) {
		tYunProviderDao.deleteProduct(providerId,productId);
	}

}
