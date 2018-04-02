package com.soa.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.soa.util.ExaminUtil;
import com.soa.util.JsonResult;
/**
 * 登录拦截器
 * 拦截请求,验证用户名和密码是否正确
 * 正确：通过登录拦截检查
 * 不正确：向前端发送一个error的标识符
 * @author hezy何振宇
 *
 */
public class LoginIntercepter implements HandlerInterceptor{
	/**
	 * 控制层前进行登录拦截
	 */
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		res.setContentType("text/html; charset=utf-8");
		HttpSession session = req.getSession();
		String user_id=(String)session.getAttribute("user_id");
		//用户没有登录则跳转到登录页面
		if(user_id==null) {
			ExaminUtil.returnPromptMessage(res, new JsonResult(1,null,"login.html"));
			return false;
			
		}
		//如果用户不是同一个人则跳转到登录页面
		String id =req.getParameter("user_id");
		if(!user_id.equals(id)) {
			ExaminUtil.returnPromptMessage(res, new JsonResult(1,null,"login.html"));
			return false;
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
