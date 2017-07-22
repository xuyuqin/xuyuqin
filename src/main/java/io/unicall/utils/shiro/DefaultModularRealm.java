package io.unicall.utils.shiro;

import java.util.Collection;
import java.util.Map;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.unicall.entity.UsernamePasswordUsertypeToken;


@Component
public class DefaultModularRealm extends ModularRealmAuthenticator{
	
    @Autowired
    private UserRealm userRealm;
    
    @Autowired
    private RegisterRealm registerRealm;
	
	private Map<String, Object> definedRealms;
	
	/**
     * 多个realm实现
     */
    @Override
    protected AuthenticationInfo doMultiRealmAuthentication(Collection<Realm> realms, AuthenticationToken token) {
        return super.doMultiRealmAuthentication(realms, token);
    }
    
    /**
     * 调用单个realm执行操作
     */
    @Override
    protected AuthenticationInfo doSingleRealmAuthentication(Realm realm,AuthenticationToken token) {

        // 如果该realms不支持(不能验证)当前token
    	
        if (!realm.supports(token)) {
            throw new ShiroException("token错误!");
        }
        AuthenticationInfo info = null;
        try {
        	System.out.println(info+"总realm");
            info = realm.getAuthenticationInfo(token);
            System.out.println(info+"总realm");

            if (info == null) {
                throw new ShiroException("token不存在!");
            }
        } catch (Exception e) {
            throw new ShiroException("用户名或者密码错误!");
        }
        return info;
    }
    
    /** 
     * 判断登录类型执行操作 
     */  
    @Override  
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)  
            throws AuthenticationException { 
    	
    	 DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    
       // this.assertRealmsConfigured();  
  
         Realm realm = null;  
  
         UsernamePasswordUsertypeToken token = (UsernamePasswordUsertypeToken) authenticationToken;  

//        if("admin".equals(authenticationToken.getPrincipal())){
         if("1".equals(token.getUsertype())){
        	System.out.println("后台管理登录");
            securityManager.setRealm(userRealm);
        	return  this.doSingleRealmAuthentication(userRealm, authenticationToken); 
            
        // 前台管理登录
        }else{
        	System.out.println("前台管理登录");
        	securityManager.setRealm(registerRealm);
        	return  this.doSingleRealmAuthentication(registerRealm, authenticationToken); 
        }
  

  
         
    }  





}
