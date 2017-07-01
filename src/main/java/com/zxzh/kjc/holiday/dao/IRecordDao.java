package com.zxzh.kjc.holiday.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zxzh.kjc.holiday.entitiy.RecordEntity;

@Mapper
public interface IRecordDao {
	// 申请请假时
	public int addRecord(RecordEntity record);

	// 更新假单的状态
	public int updateStatus(@Param("status") int status, @Param("recordId") int recordId);

	// 查询假单
	public RecordEntity queryRecord(int recordId);

	// 根据加单状态查询加单
	public List<RecordEntity> queryRecordBystatus(@Param("status") int status, @Param("userId") int userId);
	//根据用户Id和假单的状态查询加单列表
	public List<RecordEntity> getRecordList(int usrId);
}
