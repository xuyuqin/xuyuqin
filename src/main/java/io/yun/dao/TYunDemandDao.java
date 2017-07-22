package io.yun.dao;

import io.unicall.dao.BaseDao;
import io.yun.entity.TYunDemandEntity;

/**
 * 求购单表
 * 
 * @author unicall
 * @email bq.zhu@unicall.com
 * @date 2017-06-27 14:04:56
 */
public interface TYunDemandDao extends BaseDao<TYunDemandEntity> {

    void save1(TYunDemandEntity tYunDemand);
}
