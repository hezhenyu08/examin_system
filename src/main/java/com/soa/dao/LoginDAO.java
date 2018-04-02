package com.soa.dao;

import java.util.Map;

public interface LoginDAO {
	/**
	 * 查询当前用户名是否存在，并返回该用户密码
	 * @param name
	 * @return
	 */
	public Map<String,Object> findUserIdByName(String user_name);
}
