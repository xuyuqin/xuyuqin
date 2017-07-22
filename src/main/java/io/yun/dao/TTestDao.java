package io.yun.dao;

import io.unicall.dao.BaseDao;
import io.yun.entity.TYunProductEntity;

/**
 * Created by Administrator on 2017/7/19.
 */
public interface TTestDao extends BaseDao<TYunProductEntity>{
    @Override
    TYunProductEntity queryObject(Object id);
}
