package io.yun.dao;

import io.unicall.dao.BaseDao;
import io.unicall.utils.Query;
import io.yun.entity.TYunResourceEntity;

/**
 * 资源单表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-19 13:52:09
 */
public interface TYunResourceDao extends BaseDao<TYunResourceEntity> {

    TYunResourceEntity queryResource(Query query);
}
