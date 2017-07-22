package io.yun.dao;

import io.unicall.dao.BaseDao;
import io.yun.entity.TYunMerchandiseImageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品图片表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:31
 */
public interface TYunMerchandiseImageDao extends BaseDao<TYunMerchandiseImageEntity> {
	List<TYunMerchandiseImageEntity> getByMerchandiseId(@Param("merchandiseId") String merchandiseId);

    int queryTotal2(@Param("ids")String[] ids, @Param("merchandiseId")String merchandiseId);
}
