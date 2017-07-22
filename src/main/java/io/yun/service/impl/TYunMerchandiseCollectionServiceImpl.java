package io.yun.service.impl;

import io.unicall.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.dao.TYunMerchandiseCollectionDao;
import io.yun.entity.TYunMerchandiseCollectionEntity;
import io.yun.service.TYunMerchandiseCollectionService;



@Service("tYunMerchandiseCollectionService")
public class TYunMerchandiseCollectionServiceImpl implements TYunMerchandiseCollectionService {
	@Autowired
	private TYunMerchandiseCollectionDao tYunMerchandiseCollectionDao;
	
	@Override
	public TYunMerchandiseCollectionEntity queryObject(String id){
		return tYunMerchandiseCollectionDao.queryObject(id);
	}
	
	@Override
	public List<TYunMerchandiseCollectionEntity> queryList(Map<String, Object> map){
		return tYunMerchandiseCollectionDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tYunMerchandiseCollectionDao.queryTotal(map);
	}
	
	@Override
	public void save(TYunMerchandiseCollectionEntity tYunMerchandiseCollection){
		tYunMerchandiseCollectionDao.save(tYunMerchandiseCollection);
	}
	
	@Override
	public void update(TYunMerchandiseCollectionEntity tYunMerchandiseCollection){
		tYunMerchandiseCollectionDao.update(tYunMerchandiseCollection);
	}
	
	@Override
	public void delete(String id){
		tYunMerchandiseCollectionDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tYunMerchandiseCollectionDao.deleteBatch(ids);
	}

    /**
     * 带分页条件查询
     * @param query
     * @return
     */
	@Override
	public TYunMerchandiseCollectionEntity find(Query query) {
		return tYunMerchandiseCollectionDao.find(query);
	}

    /**
     * 不带分页条件查询
     * @param map
     * @return
     */
	@Override
    public TYunMerchandiseCollectionEntity find(Map<String, Object> map) {
        return tYunMerchandiseCollectionDao.find(map);
    }
}
