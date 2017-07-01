package com.zxzh.kjc.holiday.service.facade;

import java.util.List;

import com.zxzh.kjc.holiday.entitiy.RecordEntity;

public interface IRecordService {
	// 插入加单功能
	public int addVocationRecord(RecordEntity record);

	public List<RecordEntity> getRecordListByUser(int userId);
}
