package io.yun.dao;

import io.unicall.dao.BaseDao;
import io.yun.entity.TYunMerchandiseSpecEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品规格表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-07-04 10:32:17
 */
public interface TYunMerchandiseSpecDao extends BaseDao<TYunMerchandiseSpecEntity> {
	List<TYunMerchandiseSpecEntity> getByMerchandiseId(@Param("merchandiseId") String merchandiseId);
}
