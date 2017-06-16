package com.zxzh.kjc.holiday.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zxzh.kjc.holiday.dao.IRecordDao;
import com.zxzh.kjc.holiday.entitiy.RecordEntity;
import com.zxzh.kjc.holiday.service.facade.IRecordService;

@Component
public class RecordServiceImpl implements IRecordService {
	@Autowired
	private IRecordDao recordDao;

	@Override
	public int addVocationRecord(RecordEntity record) {
		// TODO Auto-generated method stub
		if (recordDao.queryRecordBystatus(1, record.getUserId()) != null) {
			return -1;// 已经有暂存加单
		} else {
			int ret = recordDao.addRecord(record);
			return ret;
		}

	}

}
