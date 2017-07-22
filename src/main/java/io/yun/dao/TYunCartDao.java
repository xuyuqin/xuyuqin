package io.yun.dao;

import io.unicall.dao.BaseDao;
import io.yun.entity.TYunCartEntity;
import org.apache.ibatis.annotations.Param;

/**
 * 购物车表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:32
 */
public interface TYunCartDao extends BaseDao<TYunCartEntity> {
	TYunCartEntity findByMemberAndMerchandise(@Param("memberId") String memberId, @Param("merchandiseId") String merchandisId);
}
