package io.unicall.dao;

import io.unicall.entity.TokenEntity;

/**
 * 用户Token
 * 
 * @author unicall
 * 
 * @date 2017-03-23 15:22:07
 */
public interface TokenDao extends BaseDao<TokenEntity> {
    
    TokenEntity queryByUserId(Long userId);

    TokenEntity queryByToken(String token);
	
}
