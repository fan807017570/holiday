package com.zxzh.kjc.holiday.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.zxzh.kjc.holiday.common.SqlSessionFactoryBuilders;
import com.zxzh.kjc.holiday.entitiy.EnvacationEntity;
import com.zxzh.kjc.holiday.entitiy.RecordEntity;

public class test {

	private static long duration = 24 * 60 * 60 * 1000;

	public static void testEnvocationDao() {
		IEnvoationDao dao = SqlSessionFactoryBuilders.getDaoFromMapper(IEnvoationDao.class);
		List<EnvacationEntity> list = dao.queryVocation(1, 1);
		for (EnvacationEntity vocation : list) {
			System.out.println(vocation.getOwnYear());
		}
	}

	public static void testIRecordDao() {
		IRecordDao recordDao = SqlSessionFactoryBuilders.getDaoFromMapper(IRecordDao.class);
		RecordEntity record = new RecordEntity();
		record.setUserId(1);
		record.setVid(1);
		record.setStatus(1);
		;
		record.setDuration(1);
		record.setStart(new java.sql.Date(new java.util.Date().getTime()));
		record.setEnd(new java.sql.Date(duration + (new java.util.Date().getTime())));
		record.setCommitTime(new Timestamp(System.currentTimeMillis()));
		// int count =recordDao.addRecord(record);
		// System.out.println(count);
		int count = recordDao.updateStatus(2, 13);
		System.out.println(count);
	}

	public static void main(String args[]) {
		/*
		 * String resource = "mybatis/mybatis.xml"; InputStream inputStream =
		 * null; try { inputStream = Resources.getResourceAsStream(resource); }
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } SqlSessionFactory sqlSessionFactory = new
		 * SqlSessionFactoryBuilder().build(inputStream); SqlSession
		 * session=sqlSessionFactory.openSession(); IUserDao
		 * userDao=session.getMapper(IUserDao.class); UserBean
		 * user=userDao.getUserById(2); System.out.println(user.getUserName());
		 */
		/*
		 * IUserDao userDao =
		 * SqlSessionFactoryBuilders.getDaoFromMapper(IUserDao.class);
		 * List<UserEntity> user = userDao.getUserByName("zqy");
		 * System.out.println(user.get(0).getRealName());
		 */
		//testIRecordDao();
		testEnvocationDao();
	}
}
