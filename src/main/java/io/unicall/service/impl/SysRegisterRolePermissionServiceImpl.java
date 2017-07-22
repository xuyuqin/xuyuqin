package io.unicall.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.unicall.service.SysRegisterRolePermissionService;
import io.unicall.service.SysRegisterService;



@Service("sysRegisterRolePermissionService")
public class SysRegisterRolePermissionServiceImpl implements SysRegisterRolePermissionService {
	
	@Autowired
	private SysRegisterService sysRegisterService;

	@Override
	public Set<String> getRegisterPermissions(long registerId) {
		List<String> permsList;
		
		permsList = sysRegisterService.queryAllPerms(registerId);
	
		//云材网注册会员权限
		Set<String> permsSet = new HashSet<String>();
		for(String perms : permsList){
			if(StringUtils.isBlank(perms)){
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}
		
		System.out.println(permsSet);
		return permsSet;
		}

	@Override
	public Set<String> getRegisterRole(long registerId) {
		List<String> roleList;
		
		roleList = sysRegisterService.queryRole(registerId);
	
		//云材网注册会员角色权限
		Set<String> roleSet = new HashSet<String>();
		for(String role : roleList){
			if(StringUtils.isBlank(role)){
				continue;
			}
			roleSet.addAll(Arrays.asList(role.trim().split(",")));
		}
		
		System.out.println(roleSet);
		return roleSet;
	}
	

}
