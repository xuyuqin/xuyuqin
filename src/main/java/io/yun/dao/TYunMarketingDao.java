package io.yun.dao;

import io.unicall.dao.BaseDao;
import io.yun.entity.TYunMarketingEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 营销（活动）表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-07-07 11:07:41
 */
public interface TYunMarketingDao extends BaseDao<TYunMarketingEntity> {

    List<Map<String,Integer>> queryStatus(Map<String, Object> params);

    void saveMerchandise(@Param(value = "marketingId")String marketingId, @Param(value = "merchandiseId")String merchandiseId);

    void deleteMerchandise(@Param(value = "marketingId")String marketingId, @Param(value = "merchandiseIds")Set<String> merchandiseIds);

    void deleteAllMerchandise(String marketingId);
}
