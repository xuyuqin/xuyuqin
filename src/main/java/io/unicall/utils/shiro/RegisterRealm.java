package io.unicall.utils.shiro;

import io.unicall.entity.SysRegisterEntity;
import io.unicall.entity.SysUserEntity;
import io.unicall.service.SysRegisterService;
import io.unicall.service.SysMenuService;
import io.unicall.service.SysRegisterRolePermissionService;

import io.unicall.utils.ShiroUtils;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 认证
 * 
 * @author unicall
 * 
 * @date 2017年6月17日 上午11:55:49
 */
@Component
public class RegisterRealm extends AuthorizingRealm {

    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysRegisterService registerService;
    @Autowired
    private SysRegisterRolePermissionService  sysRegisterRolePermissionService;

    
    
    /**
     *
     * 授权(验证权限时调用)
     *   
     * 为当前登录的Subject授予角色和权限 ,该方法的调用时机为需授权资源被访问时
     * 并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
     * 个人感觉若使用了Spring3.1开始提供的ConcurrentMapCache支持,则可灵活决定是否启用AuthorizationCache
     * 比如说这里从数据库获取权限信息时,先去访问Spring3.1提供的缓存,而不使用Shior提供的AuthorizationCache
     * 
     */
 
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		Subject subject = ShiroUtils.getSubject();

		if("io.unicall.entity.SysUserEntity".equals(subject.getPrincipal().getClass().getName())){
			SysUserEntity user = (SysUserEntity)principals.getPrimaryPrincipal();
			Long userId = user.getUserId();
	        System.out.println("进入授权验证");
			//用户权限列表
			Set<String> permsSet = sysMenuService.getUserPermissions(userId);

			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.setStringPermissions(permsSet);
			return info;
			
		}else{
			System.out.println("进入授权验证");
			SysRegisterEntity register = (SysRegisterEntity)principals.getPrimaryPrincipal();
			Long registerId = register.getId();

			//云材网注册会员权限  @RequiresPermission       
			Set<String> permsSet = sysRegisterRolePermissionService.getRegisterPermissions(registerId);
			
			
			//云材网注册会员角色权限	   @hasRole
			Set<String> roleSet = sysRegisterRolePermissionService.getRegisterRole(registerId);
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			
			info.setStringPermissions(permsSet);
			info.setRoles(roleSet);
			
			
			return info;
		}

	}

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String mobile = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        
        //查询前端注册信息

       SysRegisterEntity register = registerService.queryByRegisterMobile(mobile);
        
        //账号不存在
        if(register == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        
        //密码错误
        if(!password.equals(register.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        

        
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(register, password, getName());


        return info;
	}

}
