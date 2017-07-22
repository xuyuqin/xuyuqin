package io.yun.dao;

import org.apache.ibatis.annotations.Param;

import io.unicall.dao.BaseDao;
import io.yun.entity.TYunVerifyCodeEntity;


/**
 * @author maxellen
 * 
 */


	public interface TYunVerifyCodeDao extends BaseDao<TYunVerifyCodeEntity> {
		

		TYunVerifyCodeEntity queryByMobileAndVerifyCode(@Param("mobile")String mobile,@Param("verifyCode") String verifyCode);
		

}
