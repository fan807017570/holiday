package com.zxzh.kjc.holiday.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxzh.kjc.holiday.entitiy.VocationEntity;

public interface IVocationDao {
	// 根据假期的id获取假期的名字
	public VocationEntity getVocationList(@Param("vocationId") int vId);
}
