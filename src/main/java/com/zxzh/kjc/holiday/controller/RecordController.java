package com.zxzh.kjc.holiday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxzh.kjc.holiday.dao.IEnvoationDao;
import com.zxzh.kjc.holiday.service.facade.IRecordService;
import com.zxzh.kjc.holiday.service.facade.IUserService;
import com.zxzh.kjc.holiday.service.facade.IVocationRecordService;
import com.zxzh.kjc.holiday.service.impl.SessionService;

@RestController
@RequestMapping("/record")
public class RecordController {
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

}
