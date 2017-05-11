package com.zxzh.kjc.holiday.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zxzh.kjc.holiday.dao.IUserDao;
import com.zxzh.kjc.holiday.entitiy.LOGINSTATUS;
import com.zxzh.kjc.holiday.entitiy.UserEntity;
import com.zxzh.kjc.holiday.service.facade.IUserService;

@Component
public class UserServiceImpl implements IUserService {
	// 1.登录成功0.密码错误-1.用户不存在-2,没有输入用户的信息
	@Autowired
	private IUserDao userDao;

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
