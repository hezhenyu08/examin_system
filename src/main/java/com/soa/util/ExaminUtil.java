package com.soa.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ExaminUtil {
	/**
	 * 将用户的密码通过MD5和Base64进行加密处理
	 * @param password 用户密码
	 * @return
	 */
	public static String toMD5(String password) {
		//获取MD5对象
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			//加密处理
			byte[] output=md.digest(password.getBytes());
			//利用Base64转换成字符串结果
			String result=Base64.encodeBase64String(output);
			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 获取UUID
	 * @return
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}
	/**
	 * 返回用户提示信息
	 * @param req
	 * @param res
	 * @param jsonResult 返回用户封装的提示信息
	 */
	public static void returnPromptMessage(HttpServletResponse res,JsonResult jsonResult) {
		PrintWriter out;
		try {
			out = res.getWriter();
			ObjectMapper mapper = new ObjectMapper();
			String msg = mapper.writeValueAsString(jsonResult);
			out.write(msg);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
