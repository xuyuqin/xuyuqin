package io.unicall.dao;

import io.unicall.entity.UserEntity;

/**
 * 用户
 * 
 * @author unicall
 * 
 * @date 2017-03-23 15:22:06
 */
public interface UserDao extends BaseDao<UserEntity> {

    UserEntity queryByMobile(String mobile);
}
