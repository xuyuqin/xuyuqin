package io.yun.dao;

import io.unicall.dao.BaseDao;
import io.yun.dto.MerchandiseDto;
import io.yun.entity.TYunMerchandiseCommitsEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品评价表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:31
 */
public interface TYunMerchandiseCommitsDao extends BaseDao<TYunMerchandiseCommitsEntity> {
	List<MerchandiseDto> getByMerchandiseId(Map<String, Object> map);

	int listTotal(Map<String, Object> map);
}
