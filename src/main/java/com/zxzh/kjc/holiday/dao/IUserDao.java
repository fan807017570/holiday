package com.zxzh.kjc.holiday.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zxzh.kjc.holiday.entitiy.UserEntity;

/**
 * @author zqy
 *
 */
@Mapper
public interface IUserDao {
	// 根据用户Id获取用户信息
	public UserEntity getUserById(@Param("userId") int userId);

	// 根据用户名称获取用户信息
	public List<UserEntity> getUserByName(@Param("userName") String userName);

	// 根据用户的名和用户密码
	public UserEntity getByNameAndPasswd(@Param("userName") String userName, @Param("passwd") String passwd);

}