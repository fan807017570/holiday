package com.zxzh.kjc.holiday.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zxzh.kjc.holiday.dao.IEnvoationDao;
import com.zxzh.kjc.holiday.dao.IUserDao;
import com.zxzh.kjc.holiday.dao.IVocationDao;
import com.zxzh.kjc.holiday.entitiy.RecordEntity;
import com.zxzh.kjc.holiday.entitiy.UserEntity;
import com.zxzh.kjc.holiday.entitiy.pojo.EnvocationPojo;
import com.zxzh.kjc.holiday.entitiy.pojo.RecordListPojo;
import com.zxzh.kjc.holiday.service.facade.IRecordService;
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
	@Autowired
	private IRecordService recordService;
	@Autowired
	private IVocationDao vocationDao;
	@Autowired
	private IUserDao userDao;

	@RequestMapping("/test")
	public ModelAndView test(ModelMap model) {
		ModelAndView view = new ModelAndView("test");
		model.put("userId", 1);
		return view;
	}

	@RequestMapping("/myLeaveList")
	public ModelAndView myLeaveList(ModelMap model, HttpSession session) {
		UserEntity userInfo = sessionService.getUserInfoFromSession(session);
		ModelAndView view = null;
		if (userInfo == null) {
			model.addAttribute("msg", "session已经过期，请重新登录");
			view = new ModelAndView("error");
			return view;
		} else {
			List<RecordListPojo> recordPojoList = new ArrayList<RecordListPojo>();
			int userId = userInfo.getUserId();
			List<RecordEntity> recordList = recordService.getRecordListByUser(userId);
			for (RecordEntity record : recordList) {
				RecordListPojo recordPojo = new RecordListPojo();
				String approvalName = userDao.getUserById(record.getApproverId()).getRealName();
				String vocationName = vocationDao.getVocationList(record.getVid()).getVname();
				recordPojo.setApprovalName(approvalName);
				recordPojo.setVocationName(vocationName);
				recordPojo.setStartTime(record.getStart());
				recordPojo.setEndTime(record.getEnd());
				recordPojo.setInterval(record.getDuration());
				switch(record.getStatus())
				{
				case 1:
					recordPojo.setStatus("待提交");break;
				case 2:
					recordPojo.setStatus("待审批");break;
				case 3:
					recordPojo.setApprovalName("已审批");break;
				}
//				recordPojo.setStatus(record.getStatus());
				recordPojoList.add(recordPojo);
				System.out.println("假单信息："+JSON.toJSONString(recordPojo));
			}
			model.addAttribute("recordPojoList", recordPojoList);
			// model.addAttribute("userInfo", userInfo);
			view = new ModelAndView("myvocationList", model);
		}
		return view;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest req, ModelMap model) {
		HttpSession session = req.getSession();
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
	public ModelAndView forLeave(ModelMap model, HttpSession session) {
		ModelAndView view = new ModelAndView("forLeave");

		model.put("userId", 1);
		return view;
	}

	@RequestMapping("/toLeave")
	public ModelAndView toLeave(ModelMap model, HttpSession session) {
		ModelAndView view = new ModelAndView("toLeave");
		UserEntity userInfo = sessionService.getUserInfoFromSession(session);
		if (userInfo == null) {
			model.addAttribute("msg", "session已经过期，请重新登录");
			view = new ModelAndView("error");
			return view;
		}
		model.put("userId", userInfo.getUserId());
		return view;
	}

	@RequestMapping("/vocationList")
	public ModelAndView vocationList(ModelMap model, HttpSession session) {
		ModelAndView view = new ModelAndView("vocationList");
		UserEntity userInfo = sessionService.getUserInfoFromSession(session);
		if (userInfo == null) {
			model.addAttribute("msg", "session已经过期，请重新登录");
			view = new ModelAndView("error");
			return view;
		}
		model.put("userId", userInfo.getUserId());
		return view;
	}

	@RequestMapping("/index")
	public ModelAndView index(HttpSession session, ModelMap model) {
		// HttpSession session = req.getSession(false);
		session.setMaxInactiveInterval(1000 * 5);
		ModelAndView view = null;
		UserEntity userInfo = sessionService.getUserInfoFromSession(session);
		if (userInfo == null) {
			model.addAttribute("msg", "session已经过期，请重新登录");
			view = new ModelAndView("error");
			return view;
		}
		List<EnvocationPojo> vocationList = vocationRecordService.queryVocationListByUser(userInfo.getUserId());
		model.addAttribute("userVocation", vocationList);
		model.addAttribute("userInfo", userInfo);
		sessionService.userLoginToSession(userInfo, session);
		view = new ModelAndView("index", model);
		return view;
	}
}
