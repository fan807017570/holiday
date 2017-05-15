package com.zxzh.kjc.holiday.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zxzh.kjc.holiday.dao.IEnvoationDao;
import com.zxzh.kjc.holiday.entitiy.EnvacationEntity;

@RestController
@RequestMapping("/index")
public class ViewController {
	@Autowired
	private IEnvoationDao envoationDao;

	@RequestMapping("/test")
	public String test() {
		List<EnvacationEntity> envocations = envoationDao.queryVocation(1, 1);
		System.out.println(envocations.get(0).getOwnYear());
		return "hello world!";
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView view = new ModelAndView("login");
		return view;
	}

	@RequestMapping("/forLeave")
	public ModelAndView forLeave() {
		ModelAndView view = new ModelAndView("forLeave");
		return view;
	}
}
