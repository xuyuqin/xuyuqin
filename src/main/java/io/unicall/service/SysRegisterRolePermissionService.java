package io.unicall.service;

import java.util.Set;

public interface SysRegisterRolePermissionService {
	
	/**
	 * 获取用户权限列表
	 */
	
	Set<String> getRegisterPermissions(long registerId);
	
	Set<String> getRegisterRole(long registerId);

}
