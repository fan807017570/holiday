package com.zxzh.kjc.holiday.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zxzh.kjc.holiday.dao.IEnvoationDao;
import com.zxzh.kjc.holiday.dao.IRoleDao;
import com.zxzh.kjc.holiday.dao.IUserDao;
import com.zxzh.kjc.holiday.dao.IVocationDao;
import com.zxzh.kjc.holiday.entitiy.EnvacationEntity;
import com.zxzh.kjc.holiday.entitiy.LOGINSTATUS;
import com.zxzh.kjc.holiday.entitiy.RoleEntity;
import com.zxzh.kjc.holiday.entitiy.UserEntity;
import com.zxzh.kjc.holiday.entitiy.VocationEntity;
import com.zxzh.kjc.holiday.service.facade.IUserService;

@Component
public class UserServiceImpl implements IUserService {
	// 1.登录成功0.密码错误-1.用户不存在-2,没有输入用户的信息
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IRoleDao roleDao;

	@Autowired
	private IVocationDao vocationDao;
	@Autowired
	private IEnvoationDao envocationDao;

	public LOGINSTATUS userLogin(UserEntity user) {
		String userName = user.getUserName();
		String passwd = user.getPassWord();
		UserEntity innerUser = null;
		if (userDao.getUserByName(userName).size() != 0) {
			innerUser = userDao.getByNameAndPasswd(userName, passwd);
			if (innerUser != null) {
				return LOGINSTATUS.SUCESS;
			} else {
				return LOGINSTATUS.PASSWDERROR;
			}
		} else {
			return LOGINSTATUS.NOUSER;
		}
	}

	public UserEntity getIdByuserNameAndPwd(String userName, String passwd) {
		return userDao.getByNameAndPasswd(userName, passwd);
	}

	// 根据用户的id获取用户的所有假期类型
	public List<VocationEntity> getUserEnvocationList(int userId) {
		ArrayList<VocationEntity> envocationList = new ArrayList<VocationEntity>();
		List<EnvacationEntity> list = envocationDao.queryByUserId(userId);
		for (EnvacationEntity vocation : list) {
			int vId = vocation.getVocationId();
			VocationEntity holiday = vocationDao.getVocationList(vId);
			if (holiday != null) {
				envocationList.add(holiday);
			}
		}
		return envocationList;
	}

	@Override
	public String getRoleName(int userId) {
		// TODO Auto-generated method stub
		UserEntity user = userDao.getUserById(userId);
		RoleEntity role = null;
		if (user != null) {
			role = roleDao.getRoleById(user.getRoleId());
			return role.getRoleName();
		} else {
			return null;
		}
	}

	@Override
	public List<UserEntity> getAdminList(int roleId) {
		// TODO Auto-generated method stub
		List<UserEntity> userList=userDao.getAdminList(roleId);
		return userList;
	}
}
//
// public static void main(String args[]) {
// UserServiceImpl userService = new UserServiceImpl();
// UserEntity user = new UserEntity();
// user.setPassWord("admin");
// user.setUserName("admin");
// int status = userService.userLogin(user);
// System.out.println(status);
// }
