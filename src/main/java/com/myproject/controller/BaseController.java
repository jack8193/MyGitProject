package com.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BaseController {

	protected HttpServletRequest getHttpRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	}

	protected HttpSession getSession() {
		return getHttpRequest().getSession();
	}

	protected String getSessionId() {
		return getSession().getId();
	}

	protected String getClientIP() {
		HttpServletRequest request = getHttpRequest();

		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	protected String getServerIP() {
		return getHttpRequest().getLocalAddr();
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String testException(Exception ex) {
		ex.printStackTrace();

		return "Something went wrong...<BR/><BR/>" + ExceptionUtils.getStackTrace(ex);
	}

}
