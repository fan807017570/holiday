package com.zxzh.kjc.holiday.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBuilders {
	private static final String resource = "mybatis/mybatis.xml";
	private static SqlSession sqlSession;

	private static SqlSession getSessionFactory() {
		if (sqlSession != null) {
			return sqlSession;
		} else {
			InputStream stream = null;
			try {
				stream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (stream != null) {
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
				sqlSession = sqlSessionFactory.openSession(true);
				return sqlSession;
			}
			return null;
		}
	}
	public static  <T> T getDaoFromMapper(Class<T> clazz)
	{
		SqlSession session=getSessionFactory();
		T dao=session.getMapper(clazz);
		return dao;
	}
}
