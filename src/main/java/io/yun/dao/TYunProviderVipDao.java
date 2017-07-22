package io.yun.dao;

import io.unicall.dao.BaseDao;
import io.yun.entity.TYunProviderVipEntity;

import java.util.Map;

/**
 * 供应商—会员表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-07-11 16:18:24
 */
public interface TYunProviderVipDao extends BaseDao<TYunProviderVipEntity> {
    TYunProviderVipEntity getByProviderIdAndMemberId(Map<String, Object> map);
}
