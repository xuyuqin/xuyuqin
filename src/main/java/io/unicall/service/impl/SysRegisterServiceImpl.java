package io.unicall.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.unicall.dao.SysRegisterDao;
import io.unicall.entity.SysRegisterEntity;
import io.unicall.service.SysRegisterService;

@Service ("registerService")
public class SysRegisterServiceImpl implements SysRegisterService {
	
	@Autowired
	private SysRegisterDao sysRegisterDao;

	/******************LoginController使用*********************/
	
	@Override
	public SysRegisterEntity queryByRegisterMobile(String mobile) {
	
		return sysRegisterDao.queryByRegisterMobile(mobile);
	}

	@Override
	public void save(SysRegisterEntity register) {
		register.setCreateTime(new Date());
		//sha256加密
		register.setPassword(new Sha256Hash(register.getPassword()).toHex());
		register.setLevel(1);
		//随机设置trader 暂定5、6、7
		register.setTrader(RandomStringUtils.random(1, new char[]{'5','6','7'}));
		
		sysRegisterDao.save(register);
	
		
	}
	/**
	 * 修改密码
	 */
	@Override
	public void updatePW(SysRegisterEntity register){
		register.setPassword(new Sha256Hash(register.getPassword()).toHex());
		sysRegisterDao.updatePW(register);
	}
	
	/***************************************************************/
	
	
	/******************SysRegisterController使用*********************/
	@Override
	public SysRegisterEntity queryObject1(Long id){
		return sysRegisterDao.queryObject1(id);
	}
	
	@Override
	public List<SysRegisterEntity> queryList(Map<String, Object> map){
		return sysRegisterDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysRegisterDao.queryTotal(map);
	}
	
	
	@Override
	public void update(SysRegisterEntity sysRegister){
		sysRegisterDao.update(sysRegister);
	}
	
	
	
	@Override
	public void delete(Long id){
		sysRegisterDao.delete(id);
	}

	@Override
	public void deleteBatch(Long[] ids){
		sysRegisterDao.deleteBatch(ids);
	}
	
	/*****************************************************/
	
	/******************权限使用*********************/
	@Override
	public List<String> queryAllPerms(Long registerId) {
		return sysRegisterDao.queryAllPerms(registerId);
	}
	@Override
	public List<String> queryRole(Long registerId) {
		return sysRegisterDao.queryRole(registerId);
	}
	
	/***************************************************************/
	
	

}
