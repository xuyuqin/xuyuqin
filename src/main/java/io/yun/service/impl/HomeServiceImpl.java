package io.yun.service.impl;

import io.yun.dao.TYunDemandDao;
import io.yun.dao.TYunMerchandiseDao;
import io.yun.dao.TYunNewsDao;
import io.yun.dao.TYunProviderDao;
import io.yun.dto.HomeProviderDto;
import io.yun.entity.TYunDemandEntity;
import io.yun.entity.TYunMerchandiseEntity;
import io.yun.entity.TYunNewsEntity;
import io.yun.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by sr.chen on 2017/6/30.
 */
@Service("/homeService")
public class HomeServiceImpl implements HomeService{
    @Autowired
    private TYunMerchandiseDao tYunMerchandiseDao;
    @Autowired
    private TYunProviderDao tYunProviderDao;
    @Autowired
    private TYunDemandDao tYunDemandDao;
    @Autowired
    private TYunNewsDao tYunNewsDao;

    @Override
    public List<TYunMerchandiseEntity> merchandisesList(Map<String, Object> map){
        return tYunMerchandiseDao.queryList(map);
    }

    @Override
    public int merchandisesTotal(Map<String, Object> map){
        return tYunMerchandiseDao.queryTotal(map);
    }

    @Override
    public List<HomeProviderDto> providerList(Map<String, Object> map){
        return tYunProviderDao.getHomeProvider(map);
    }

    @Override
    public int providerTotal(Map<String, Object> map){
        return tYunProviderDao.queryTotal(map);
    }

    @Override
    public List<TYunDemandEntity> demandList(Map<String, Object> map){
        return tYunDemandDao.queryList(map);
    }

    @Override
    public int demandTotal(Map<String, Object> map){
        return tYunNewsDao.queryTotal(map);
    }

    @Override
    public List<TYunNewsEntity> newsList(Map<String, Object> map){
        return tYunNewsDao.queryList(map);
    }

    @Override
    public int newsTotal(Map<String, Object> map){
        return tYunDemandDao.queryTotal(map);
    }
}
