package com.zxzh.kjc.holiday.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zxzh.kjc.holiday.dao.IEnvoationDao;
import com.zxzh.kjc.holiday.entitiy.EnvacationEntity;
import com.zxzh.kjc.holiday.entitiy.pojo.EnvocationPojo;
import com.zxzh.kjc.holiday.service.facade.IVocationRecordService;

@Component
public class VocationRecordServiceImpl implements IVocationRecordService {
	// 根据用户Id和请假的类型，请假
	@Autowired
	private IEnvoationDao envocationDao;
	// IRecordDao recordDao =
	// SqlSessionFactoryBuilders.getDaoFromMapper(IRecordDao.class);
	// IEnvoationDao envocatoinDao =
	// SqlSessionFactoryBuilders.getDaoFromMapper(IEnvoationDao.class);

	@Override
	public void askForLeave(int userId, int vid) {
		// TODO Auto-generated method stub
		// 1.首先查询今年该用户是否具有该类型的假期，如果有就在record
		// 表中插入加单，加单的状态为1，提交以后状态为2，待管理员批准以后
		// 将假单的状态改为3，同时将该用户对应的所属假期类型的结余时间，减去该次请假的天数
		// l另外，在用户具有这种加单存在的时候，不允许用户进行请假。
		// List<EnvacationEntity> list = envocatoinDao.queryVocation(vid,
		// userId);
		// if ()) {
		// // 插入对应的 假期类型
		//
		// } else {// 1.如果有对应的假期类型，那么久生产简单，然后将发起事务，跟新
		// // 用户所具有的假期表和加单表
		//
		// }
	}

	@Override
	public List<EnvacationEntity> getVocationList(int userId) {
		// TODO Auto-generated method stub
		List<EnvacationEntity> vocationList = envocationDao.queryByUserId(userId);
		return vocationList;
	}
	public List<EnvocationPojo> queryVocationListByUser(int userId){
		List<EnvocationPojo> envocationList=envocationDao.queryVocationList(userId);
		return envocationList;
	}

}
