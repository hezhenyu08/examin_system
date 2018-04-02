package com.soa.dao;

import java.util.List;
import java.util.Map;

public interface IndexDAO {
	/**
	 * 根据用户ID查询对应的用户模块
	 * @param user_id 用户ID
	 * @return
	 */
	public List<Map<String,Object>> findUserModule(String user_id);
}
