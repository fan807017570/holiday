package com.zxzh.kjc.holiday.controller;

import java.util.List;

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

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IVocationRecordService vocationRecordService;

	@RequestMapping(value = "/dologin", method = RequestMethod.GET)
	public ModelAndView login(HttpSession sessoin, @RequestParam("username") String userName,
			@RequestParam("passwd") String passwd, ModelMap model) {
		UserEntity user = new UserEntity();
		user.setUserName(userName);
		user.setPassWord(passwd);
		ModelAndView view = null;
		LOGINSTATUS status = userService.userLogin(user);
		if (status == LOGINSTATUS.SUCESS) {
			UserEntity userInfo = userService.getIdByuserNameAndPwd(userName, passwd);
			int uId = userInfo.getUserId();
			List<EnvocationPojo> vocationList = vocationRecordService.queryVocationListByUser(uId);
			model.addAttribute("userVocation", vocationList);
			model.addAttribute("userInfo", userInfo);
			view = new ModelAndView("/vocationinfo", model);
		} else if (status == LOGINSTATUS.PASSWDERROR) {
			model.addAttribute("msg", "密码错误");
			view = new ModelAndView("/error", model);
		} else if (status == LOGINSTATUS.NOUSER) {
			model.addAttribute("msg", "用户不存在");
			view = new ModelAndView("/error", model);
		}
		return view;
	}
	@RequestMapping("/forLeave")
	public ModelAndView forLeave()
	{
		return null;
	}
}
