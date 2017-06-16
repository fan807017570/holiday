package com.zxzh.kjc.holiday.service.facade;

import java.util.List;

import com.zxzh.kjc.holiday.entitiy.LOGINSTATUS;
import com.zxzh.kjc.holiday.entitiy.UserEntity;
import com.zxzh.kjc.holiday.entitiy.VocationEntity;

public interface IUserService {
	public LOGINSTATUS userLogin(UserEntity user);

	public UserEntity getIdByuserNameAndPwd(String userName, String passwd);

	public List<VocationEntity> getUserEnvocationList(int userId);
	//根据用户id获取用户的角色信息
	public String getRoleName(int userId);
	//获取管理员列表
	public  List<UserEntity> getAdminList(int roleId);
}
