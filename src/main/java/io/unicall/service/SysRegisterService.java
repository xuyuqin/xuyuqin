package io.unicall.service;


import java.util.List;
import java.util.Map;

import io.unicall.entity.SysRegisterEntity;

/**
 * @author maxellen
 * @email bq.zhu@unicall.net.cn
 * @date 2017-06-22 15:55:18
 */
public interface SysRegisterService {

	/*********LoginController使用*************
	
	/**
	 * 根据手机号，查询前台注册用户
	 */
	SysRegisterEntity queryByRegisterMobile(String mobile);
	
	/**
	 * 注册用户
	 */
	void save(SysRegisterEntity register);
	
	/******************************************/
	
	
	/*********SysRegisterController使用*************/
    SysRegisterEntity queryObject1(Long id);
	
	List<SysRegisterEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);

	
	void update(SysRegisterEntity sysRegister);
	
	void updatePW(SysRegisterEntity sysRegister);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
	
	
	
	/******************权限使用****************/
	/**
	 * 查询注册会员的所有权限
	 * @param registerId  会员ID
	 */
	List<String> queryAllPerms(Long registerId);
	/**
	 * 查询注册会员的角色权限
	 * @param registerId  会员ID
	 */
	List<String> queryRole(Long registerId);
	
	/******************************************/
	

}
