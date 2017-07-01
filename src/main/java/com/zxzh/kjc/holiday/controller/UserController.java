package com.zxzh.kjc.holiday.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zxzh.kjc.holiday.dao.IEnvoationDao;
import com.zxzh.kjc.holiday.entitiy.EnvacationEntity;
import com.zxzh.kjc.holiday.entitiy.LOGINSTATUS;
import com.zxzh.kjc.holiday.entitiy.RecordEntity;
import com.zxzh.kjc.holiday.entitiy.UserEntity;
import com.zxzh.kjc.holiday.entitiy.VocationEntity;
import com.zxzh.kjc.holiday.entitiy.pojo.EnvocationPojo;
import com.zxzh.kjc.holiday.service.facade.IRecordService;
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
	@Autowired
	private IRecordService recordService;
	@Autowired
	private IEnvoationDao envocationDao;

	@RequestMapping(value = "/dologin", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest req, @RequestParam("username") String userName,
			@RequestParam("passwd") String passwd, ModelMap model) {
		HttpSession session=req.getSession();
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
		LOGINSTATUS status = userService.userLogin(user);
		if (status == LOGINSTATUS.SUCESS) {
			UserEntity userInfo = userService.getIdByuserNameAndPwd(userName, passwd);
			int uId = userInfo.getUserId();
			List<EnvocationPojo> vocationList = vocationRecordService.queryVocationListByUser(uId);
			model.addAttribute("userVocation", vocationList);
			model.addAttribute("userInfo", userInfo); 
			sessionService.userLoginToSession(userInfo, session);
			view = new ModelAndView("index", model);
		} else if (status == LOGINSTATUS.PASSWDERROR) {
			model.addAttribute("msg", "密码错误");
			view = new ModelAndView("/error", model);
			// view ="/error";
		} else if (status == LOGINSTATUS.NOUSER) {
			model.addAttribute("msg", "用户不存在");
			view = new ModelAndView("/error", model);
		}
		return view;
	}

	@RequestMapping("/forLeave")
	public ModelAndView forLeave() {
		return null;
	}

	@RequestMapping("/getUerVocation")
	public String getUserVocaton(@RequestParam("userId") int userId) {
		List<VocationEntity> list = userService.getUserEnvocationList(userId);
		return JSON.toJSONString(list);
	}

	@RequestMapping("/getRole")
	public String getUserRole(@RequestParam("userId") int userId) {
		String roleName = userService.getRoleName(userId);
		return roleName;
	}

	@RequestMapping("/getAdmin")
	public String getAdminList(@RequestParam("roleId") int roleId) {
		List<UserEntity> nameList = userService.getAdminList(roleId);
		System.out.println(JSON.toJSONString(nameList));
		return JSON.toJSONString(nameList);
	}

	@RequestMapping(value = "/postRecord", method = { RequestMethod.POST})
	public int addRecord(@RequestBody RecordEntity record) {
		int ret=recordService.addVocationRecord(record);
		return ret;
	}

	@RequestMapping(value = "/getEnvotionInfo")
	public String getEnvocationInfo(int vId, int uId) {
		EnvacationEntity envocation = envocationDao.queryVocation(vId, uId);
		return JSON.toJSONString(envocation);
	}

}
