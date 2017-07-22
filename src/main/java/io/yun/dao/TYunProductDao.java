package io.yun.dao;

import io.unicall.dao.BaseDao;
import io.yun.dto.BaikeDetailsDto;
import io.yun.entity.TYunProductEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品品种表
 * 
 * @author unicall
 * @email bq.zhu@unicall.com
 * @date 2017-06-23 12:02:43
 */
public interface TYunProductDao extends BaseDao<TYunProductEntity> {

    List<TYunProductEntity> baikeList(Map<String, Object> map);

    int baikeTotal(Map<String, Object> map);

    List<TYunProductEntity> nameList(Map<String, Object> map);

    int nameTotal(Map<String, Object> map);

    List<TYunProductEntity> hotList(Map<String, Object> map);

    List<TYunProductEntity> getProduct(String productid);

    List<BaikeDetailsDto> getProductImg(Map<String, Object> map);

    List<BaikeDetailsDto> getProductmodule(Map<String, Object> map);

    List<BaikeDetailsDto> getDownProduct(Map<String, Object> map);
}
