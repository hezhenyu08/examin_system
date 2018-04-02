package com.soa.service;

import com.soa.entity.Admin;
import com.soa.util.JsonResult;
/**
 * Index的Service层
 * @author hezhe
 *
 */
public interface IndexService {
	/**
	 * 根据用户ID查询对应的用户模块
	 * @param user_id 用户ID
	 * @return json对象
	 */
	public JsonResult findUserModule(String user_id) throws MyException;
}
