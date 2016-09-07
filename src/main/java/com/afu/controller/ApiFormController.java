package com.afu.controller;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 提交参数为form表单</br>
 * 
 * @author fulei.yang
 * @date 2016/9/1
 * @version 1.0.0
 */
@Controller
public class ApiFormController {
	/** http相关参数 **/
	private static final String DEFAULT_CHARSET = "UTF-8";
	private static final String DEFAULT_CONTENT_TYPE_NAME = "content-type";
	private static final String DEFAULT_CONTENT_TYPE_VALUE = "application/json;charset=UTF-8";
	/**
	 * 解析表单第一种方式</br>
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/proxy")
	public void restfulHandlerForm(HttpServletRequest request, HttpServletResponse response) {
		// 判断是否是表单方式提交数据
		// Map<String, String> mapParams = request.getParameterMap();
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<?> enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			// 获取参数名
			String paramName = (String) enumeration.nextElement();
			// 获取对应的参数value
			String paramValue = request.getParameter(paramName);
			// 形成键值对应的map
			map.put(paramName, paramValue);
		}
		
		String serviceName = null;
		String methodName = null;
		String paramsString = null;
		// 获取业务处理需要的参数
		serviceName = map.get("serviceName");
		methodName = map.get("methodName");
		paramsString = map.get("paramsString");
		// 业务逻辑处理
		handleJson(response, serviceName, methodName, paramsString);
	}

	/**
	 * 解析表单第二种方式</br>
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/proxy1")
	public void restfulHandlerForm1(HttpServletRequest request, HttpServletResponse response) {
		// 判断是否是表单方式提交数据
		@SuppressWarnings("unchecked")
		Map<String, String[]> mapParams = request.getParameterMap();
		String serviceName = null;
		String methodName = null;
		String paramsString = null;
		// 获取业务处理需要的参数
		serviceName = mapParams.get("serviceName")[0];
		methodName = mapParams.get("methodName")[0];
		paramsString = mapParams.get("paramsString")[0];
		// 业务逻辑处理
		handleJson(response, serviceName, methodName, paramsString);
	}

	/**
	 * @author fulei.yang
	 * @param response
	 * @param serviceName
	 * @param methodName
	 * @param paramsString
	 * @date 2016/9/1
	 */
	private void handleJson(HttpServletResponse response, String serviceName, String methodName, String paramsString) {
		// 设置返回参数的编码格式
		response.setCharacterEncoding(DEFAULT_CHARSET);
		response.setHeader(DEFAULT_CONTENT_TYPE_NAME, DEFAULT_CONTENT_TYPE_VALUE);
		System.out.println(serviceName + methodName + paramsString);
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.print("{}");
		} catch (Exception e) {
		} finally {
			if (pw != null)
				pw.flush();
			pw.close();
		}
	}
}
