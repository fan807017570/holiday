package com.zxzh.kjc.holiday.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxzh.kjc.holiday.entitiy.EnvacationEntity;
import com.zxzh.kjc.holiday.entitiy.pojo.EnvocationPojo;

//@Mapper
public interface IEnvoationDao {
	public List<EnvacationEntity> queryVocation(@Param("vocationId") int vId, @Param("userId") int userId);

	public List<EnvacationEntity> queryByUserId(@Param("userId") int uid);
	
	public List<EnvocationPojo> queryVocationList(@Param("userId") int uid);
}
