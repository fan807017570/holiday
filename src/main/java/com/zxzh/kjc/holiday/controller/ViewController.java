package com.zxzh.kjc.holiday.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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
		List<EnvacationEntity> envocations = envoationDao.queryVocation(1, 1);
		System.out.println(envocations.get(0).getOwnYear());
		return "hello world!";
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req, ModelMap model) {
		HttpSession session = req.getSession();
		UserEntity userInfo = sessionService.getUserInfoFromSession(req);
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

	@RequestMapping("/forLeave")
	public ModelAndView forLeave() {
		ModelAndView view = new ModelAndView("forLeave");
		return view;
	}
}
