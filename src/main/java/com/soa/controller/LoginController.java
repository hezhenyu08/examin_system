package com.soa.controller;

import javax.annotation.Resource;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soa.entity.Admin;
import com.soa.service.LoginService;
import com.soa.service.MyException;
import com.soa.util.JsonResult;
@Controller
@RequestMapping("/login")
public class LoginController extends ExceptionController{
	@Resource
	private LoginService loginService;
	/**
	 * 检查登录用户
	 * @return 一个json对象
	 * @throws LoginException 
	 */
	@ResponseBody
	@RequestMapping("/checkUser.do")
	public JsonResult checkLoginUser(HttpServletRequest req,Admin admin) throws MyException {
		return loginService.checkLoginUser(req,admin);
	}
}
