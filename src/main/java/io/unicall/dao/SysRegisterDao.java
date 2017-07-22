package io.unicall.dao;

import java.util.List;
import io.unicall.entity.SysRegisterEntity;
import io.yun.dto.MyInfoDto;


/**
 * @author maxellen
 * @email bq.zhu@unicall.net.cn
 * @date 2017-06-22 14:55:18
 */
public interface SysRegisterDao extends BaseDao<SysRegisterEntity>{
	/*************LoginController使用*****************
	/**
	 * 根据用户名，查询前端注册用户
	 */
	SysRegisterEntity queryByRegisterMobile(String mobile);
	
	void updatePW(SysRegisterEntity sysRegister);
	
	/************************************************/
	

	/*************权限使用*******************

	 /** 查询云材网会员的所有权限
	 * @param registerId  会员ID
	 */
	List<String> queryAllPerms(Long registerId);
	
	/** 查询云材网会员角色权限
	 * @param registerId  会员ID
	 */
	List<String> queryRole(Long registerId);

	void update1(MyInfoDto myInfoDto);

	/*************权限使用*******************/
	
	
	

}
