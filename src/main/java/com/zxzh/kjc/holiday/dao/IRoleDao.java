package com.zxzh.kjc.holiday.dao;

import org.apache.ibatis.annotations.Param;

import com.zxzh.kjc.holiday.entitiy.RoleEntity;

public interface IRoleDao {
	//根据roleid 获取角色信息
	public RoleEntity getRoleById(@Param("roleId") int roleId);

}
