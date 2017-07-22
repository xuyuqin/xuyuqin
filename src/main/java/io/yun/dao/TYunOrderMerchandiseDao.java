package io.yun.dao;

import io.unicall.dao.BaseDao;
import io.yun.entity.TYunOrderMerchandiseEntity;

import java.util.List;

/**
 * 订单—商品关系表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:31
 */
public interface TYunOrderMerchandiseDao extends BaseDao<TYunOrderMerchandiseEntity> {

    List<TYunOrderMerchandiseEntity> getBuyPrice(String productid);
}
