package io.yun.dao;

import io.unicall.dao.BaseDao;
import io.unicall.utils.Query;
import io.yun.entity.TYunResourceCollectionEntity;

/**
 * 资源单-用户关系表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-19 13:52:10
 */
public interface TYunResourceCollectionDao extends BaseDao<TYunResourceCollectionEntity> {

    TYunResourceCollectionEntity find(Query query);
}
