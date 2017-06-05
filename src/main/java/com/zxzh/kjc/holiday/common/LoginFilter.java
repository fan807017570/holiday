package com.zxzh.kjc.holiday.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.zxzh.kjc.holiday.entitiy.UserEntity;
import com.zxzh.kjc.holiday.service.impl.SessionService;

public class LoginFilter implements Filter {
	@Autowired
	private SessionService sessionService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		// HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		UserEntity user = sessionService.getUserInfoFromSession(session);
		chain.doFilter(request, response);
		// if (user != null) {
		// RequestDispatcher dispatcher =
		// request.getRequestDispatcher("longin");
		// dispatcher.forward(request, response);
		// chain.doFilter(request, response);
		// } else {
		// RequestDispatcher dispatcher =
		// request.getRequestDispatcher("longin");
		// dispatcher.forward(request, response);
		// chain.doFilter(request, response);
		// }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
