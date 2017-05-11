package com.zxzh.kjc.holiday.service.facade;

import java.util.List;

import com.zxzh.kjc.holiday.entitiy.EnvacationEntity;
import com.zxzh.kjc.holiday.entitiy.pojo.EnvocationPojo;

public interface IVocationRecordService {
	public void askForLeave(int userId, int vid);

	public List<EnvacationEntity> getVocationList(int userId);
	
	public List<EnvocationPojo> queryVocationListByUser(int userId);
}
