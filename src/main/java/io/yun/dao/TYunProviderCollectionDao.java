package io.yun.dao;

import io.unicall.dao.BaseDao;
import io.unicall.utils.Query;
import io.yun.entity.TYunProviderCollectionEntity;

import java.util.Map;

/**
 * 供应商收藏
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-29 14:16:31
 */
public interface TYunProviderCollectionDao extends BaseDao<TYunProviderCollectionEntity> {

    TYunProviderCollectionEntity find(Query query);

    TYunProviderCollectionEntity find(Map<String, Object> map);
}
