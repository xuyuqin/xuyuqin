package io.yun.dao;

import io.unicall.dao.BaseDao;
import io.unicall.utils.Query;
import io.yun.entity.TYunMerchandiseCollectionEntity;

import java.util.Map;

/**
 * 商品收藏表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-16 10:38:12
 */
public interface TYunMerchandiseCollectionDao extends BaseDao<TYunMerchandiseCollectionEntity> {

    TYunMerchandiseCollectionEntity find(Query query);

    TYunMerchandiseCollectionEntity find(Map<String, Object> map);
}
