package com.hxrainbow.rule.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {
	public static void toJson(String result) throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");

		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

	public static void toJson(Object r) throws Exception {
		ObjectMapper om = new ObjectMapper();

		String result = om.writeValueAsString(r);

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");

		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}
}