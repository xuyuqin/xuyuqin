package io.yun.service;

import io.yun.dto.HomeProviderDto;
import io.yun.entity.TYunDemandEntity;
import io.yun.entity.TYunMerchandiseEntity;
import io.yun.entity.TYunNewsEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by sr.chen on 2017/6/30.
 */
public interface HomeService {

    List<TYunMerchandiseEntity> merchandisesList(Map<String, Object> map);

    int merchandisesTotal(Map<String, Object> map);

    List<HomeProviderDto> providerList(Map<String, Object> map);

    int providerTotal(Map<String, Object> map);

    List<TYunDemandEntity> demandList(Map<String, Object> map);

    int demandTotal(Map<String, Object> map);

    List<TYunNewsEntity> newsList(Map<String, Object> map);

    int newsTotal(Map<String, Object> map);
}
