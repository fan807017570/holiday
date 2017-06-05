package com.zxzh.kjc.holiday.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zxzh.kjc.holiday.entitiy.LOGINSTATUS;
import com.zxzh.kjc.holiday.entitiy.UserEntity;
import com.zxzh.kjc.holiday.entitiy.pojo.EnvocationPojo;
import com.zxzh.kjc.holiday.service.facade.IUserService;
import com.zxzh.kjc.holiday.service.facade.IVocationRecordService;
import com.zxzh.kjc.holiday.service.impl.SessionService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IVocationRecordService vocationRecordService;
	@Autowired
	private SessionService sessionService;

	@RequestMapping(value = "/dologin", method = RequestMethod.GET)
	public ModelAndView login(HttpSession session, @RequestParam("username") String userName,
			@RequestParam("passwd") String passwd, ModelMap model) {
		UserEntity user = sessionService.getUserInfoFromSession(session);
		ModelAndView view = null;
		if (user != null) {
			// int uId = user.getUserId();
			// List<EnvocationPojo> vocationList =
			// vocationRecordService.queryVocationListByUser(uId);
			// model.addAttribute("userVocation", vocationList);
			model.addAttribute("userInfo", user);
			sessionService.userLoginToSession(user, session);
			view = new ModelAndView("vocationinfo", model);
		}
		user = new UserEntity();
		user.setUserName(userName);
		user.setPassWord(passwd);
		// String view = null;
		LOGINSTATUS status = userService.userLogin(user);
		if (status == LOGINSTATUS.SUCESS) {
			UserEntity userInfo = userService.getIdByuserNameAndPwd(userName, passwd);
			int uId = userInfo.getUserId();
			List<EnvocationPojo> vocationList = vocationRecordService.queryVocationListByUser(uId);
			model.addAttribute("userVocation", vocationList);
			model.addAttribute("userInfo", userInfo);
			sessionService.userLoginToSession(userInfo, session);
			view = new ModelAndView("vocationinfo", model);
		} else if (status == LOGINSTATUS.PASSWDERROR) {
			model.addAttribute("msg", "密码错误");
			view = new ModelAndView("/error", model);
			// view ="/error";
		} else if (status == LOGINSTATUS.NOUSER) {
			model.addAttribute("msg", "用户不存在");
			view = new ModelAndView("/error", model);
			// view ="error";
		}
		return view;
	}

	@RequestMapping("/forLeave")
	public ModelAndView forLeave() {
		return null;
	}
}
