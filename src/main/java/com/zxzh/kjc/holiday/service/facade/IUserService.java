package com.zxzh.kjc.holiday.service.facade;

import com.zxzh.kjc.holiday.entitiy.LOGINSTATUS;
import com.zxzh.kjc.holiday.entitiy.UserEntity;

public interface IUserService {
	public LOGINSTATUS userLogin(UserEntity user);

	public UserEntity getIdByuserNameAndPwd(String userName, String passwd);
}
