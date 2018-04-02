package com.soa.service;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.soa.dao.LoginDAO;
import com.soa.entity.Admin;
import com.soa.util.JsonResult;

/**
 * Login请求出来的逻辑层
 * 
 * @author hezy
 *
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Resource
	private LoginDAO loginDAO;
	/**
	 * 检查登录的用户名和密码是否正确
	 * @return 一个json对象
	 * @throws LoginException 
	 */
	public JsonResult checkLoginUser(HttpServletRequest req,Admin admin) throws MyException {
		String user_name = admin.getUser_name();
		String user_password = admin.getUser_password();
		if(user_name==null) {
			throw new MyException("用户名不能为空值");
		}
		if(user_password==null) {
			throw new MyException("密码不能为空值");
		}
		Map<String, Object> User = loginDAO.findUserIdByName(user_name);
		String password=(String)User.get("USER_PASSWORD");
		if(password==null) {
			throw new MyException("用户名错误");
		}
		if(!password.equals(user_password)) {
			throw new MyException("密码错误");
		}
		String user_id=(String)User.get("USER_ID");
		Admin user_admin = new Admin();
		user_admin.setUser_name(user_name);
		user_admin.setUser_id(user_id);
		HttpSession session = req.getSession();
		session.setAttribute("user_id", user_id);
		return new JsonResult(user_admin);
	}

}
