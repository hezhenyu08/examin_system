package com.soa.controller;

import javax.annotation.Resource;
import javax.security.auth.login.LoginException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soa.entity.Admin;
import com.soa.service.IndexService;
import com.soa.service.LoginService;
import com.soa.service.MyException;
import com.soa.util.JsonResult;
@Controller
@RequestMapping("/index")
public class IndexController extends ExceptionController{
	@Resource
	private IndexService indexService;
	
	/**
	 * 根据用户ID查询对应的用户模块
	 * @param user_id 用户ID
	 * @return json对象
	 */
	@ResponseBody
	@RequestMapping("/findUserModule.do")
	public JsonResult findUserModule(String user_id) throws MyException {
		System.out.println(1);
		return indexService.findUserModule(user_id);
	}
}
