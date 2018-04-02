package com.soa.service;

import javax.servlet.http.HttpServletRequest;

import com.soa.entity.Admin;
import com.soa.util.JsonResult;
/**
 * LOGIN的Service层
 * @author hezhe
 *
 */
public interface LoginService {
	/**
	 * 检查登录用户
	 * @return 一个json对象
	 * @throws LoginException 
	 * @throws MyException 
	 */
	public JsonResult checkLoginUser(HttpServletRequest req,Admin admin) throws MyException;
}
