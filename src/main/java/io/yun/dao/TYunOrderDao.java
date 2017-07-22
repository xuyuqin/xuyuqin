package io.yun.dao;

import io.unicall.dao.BaseDao;
import io.yun.entity.TYunOrderEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:31
 */
public interface TYunOrderDao extends BaseDao<TYunOrderEntity> {
	List<String> statusTotal(@Param("memberId") String memberId);

	int queryOrderNumToday();
}
