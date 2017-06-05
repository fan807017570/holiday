package com.zxzh.kjc.holiday.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.zxzh.kjc.holiday.entitiy.UserEntity;

@Component
public class SessionService {
	final private String USER_INFO_SESSION_KEY = "user_info_session_key";

	public UserEntity getUserInfoFromSession(HttpSession session) {
		// HttpSession session = req.getSession();
		UserEntity user = null;
		if (session == null || session.getAttribute(USER_INFO_SESSION_KEY) == null) {
			return null;
		} else {
			user = (UserEntity) session.getAttribute(USER_INFO_SESSION_KEY);
			return user;
		}
	}

	public void userLoginToSession(UserEntity user, HttpSession session) {
		session.setAttribute(USER_INFO_SESSION_KEY, user);
	}

}
