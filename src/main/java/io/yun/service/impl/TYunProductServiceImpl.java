package io.yun.service.impl;

import io.yun.dto.BaikeDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunProductDao;
import io.yun.entity.TYunProductEntity;
import io.yun.service.TYunProductService;



@Service("tYunProductService")
public class TYunProductServiceImpl implements TYunProductService {
	@Autowired
	private TYunProductDao tYunProductDao;
	
	@Override
	public TYunProductEntity queryObject(String id){
		return tYunProductDao.queryObject(id);
	}
	
	@Override
	public List<TYunProductEntity> queryList(Map<String, Object> map){
		return tYunProductDao.queryList(map);
	}


	@Override
	public List<TYunProductEntity> hotList(Map<String, Object> map){
		return tYunProductDao.hotList(map);
	}

	@Override
	public List<TYunProductEntity> baikeList(Map<String, Object> map){
		return tYunProductDao.baikeList(map);
	}

	@Override
	public List<TYunProductEntity> nameList(Map<String, Object> map){
		return tYunProductDao.nameList(map);
	}

	@Override
	public List<TYunProductEntity> getProduct(String productid){
		return tYunProductDao.getProduct(productid);
	};


	@Override
	public List<BaikeDetailsDto> getProductImg(Map<String, Object> map){
		return tYunProductDao.getProductImg(map);
	};


	@Override
	public List<BaikeDetailsDto> getProductmodule(Map<String, Object> map){
		return tYunProductDao.getProductmodule(map);
	};


	@Override
	public List<BaikeDetailsDto> getDownProduct(Map<String, Object> map){
		return tYunProductDao.getDownProduct(map);
	};
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunProductDao.queryTotal(map);
	}

	@Override
	public int baikeTotal(Map<String, Object> map){
		return tYunProductDao.baikeTotal(map);
	}

	@Override
	public int nameTotal(Map<String, Object> map){
		return tYunProductDao.nameTotal(map);
	}
	
	@Override
	public void save(TYunProductEntity tYunProduct){
		tYunProductDao.save(tYunProduct);
	}
	
	@Override
	public void update(TYunProductEntity tYunProduct){
		tYunProductDao.update(tYunProduct);
	}
	
	@Override
	public void delete(String id){
		tYunProductDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunProductDao.deleteBatch(ids);
	}

}
