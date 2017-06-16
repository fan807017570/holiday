package com.zxzh.kjc.holiday.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zxzh.kjc.holiday.dao.IEnvoationDao;
import com.zxzh.kjc.holiday.entitiy.EnvacationEntity;
import com.zxzh.kjc.holiday.entitiy.UserEntity;
import com.zxzh.kjc.holiday.entitiy.pojo.EnvocationPojo;
import com.zxzh.kjc.holiday.service.facade.IVocationRecordService;
import com.zxzh.kjc.holiday.service.impl.SessionService;

@RestController
@RequestMapping("/index")
public class ViewController {
	@Autowired
	private IEnvoationDao envoationDao;

	@Autowired
	private SessionService sessionService;
	@Autowired
	private IVocationRecordService vocationRecordService;

	@RequestMapping("/test")
	public String test() {
		EnvacationEntity envocations = envoationDao.queryVocation(1, 1);
		System.out.println(envocations.getOwnYear());
		return "hello world!";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpSession session, ModelMap model) {
		// HttpSession session = req.getSession();
		UserEntity userInfo = sessionService.getUserInfoFromSession(session);
		ModelAndView view = null;
		if (session == null || userInfo == null) {
			view = new ModelAndView("login");
		} else {
			List<EnvocationPojo> vocationList = vocationRecordService.queryVocationListByUser(userInfo.getUserId());
			model.addAttribute("userVocation", vocationList);
			model.addAttribute("userInfo", userInfo);
			view = new ModelAndView("login", model);
		}
		return view;
	}

	@RequestMapping("forwordTo")
	public ModelAndView forward(UserEntity user, ModelMap model) {
		int uId = user.getUserId();
		List<EnvocationPojo> vocationList = vocationRecordService.queryVocationListByUser(uId);
		model.addAttribute("userVocation", vocationList);
		model.addAttribute("userInfo", user);
		return null;

	}

	@RequestMapping("/forLeave")
	public ModelAndView forLeave(ModelMap model) {
		ModelAndView view = new ModelAndView("forLeave");
		model.put("userId", 1);
		return view;
	}
	@RequestMapping("/toLeave")
	public ModelAndView toLeave(ModelMap model) {
		ModelAndView view = new ModelAndView("toLeave");
		model.put("userId", 1);
		return view;
	}

	@RequestMapping("/vocationList")
	public ModelAndView vocationList(ModelMap model) {
		ModelAndView view = new ModelAndView("vocationList");
		model.put("userId", 1);
		return view;
	}

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("index");
		return view;
	}
}
