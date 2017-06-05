package com.zxzh.kjc.holiday;

import javax.servlet.Filter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.zxzh.kjc.holiday.common.LoginFilter;

@SpringBootApplication
@MapperScan("com.zxzh.kjc.holiday.dao")
public class Application {
	public static void main(String args[]) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean register = new FilterRegistrationBean();
		register.setFilter(sessionFilter());
		register.addUrlPatterns("/*");
		return register;
	}

	@Bean(name = "sessionFilter")
	public Filter sessionFilter() {
		// TODO Auto-generated method stub
		return new LoginFilter();
	}
}
