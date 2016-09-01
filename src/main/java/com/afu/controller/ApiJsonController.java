package com.afu.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 提交参数在request中</br>
 * 
 * @author fulei.yang
 * @date 2016/9/1
 * @version 1.0.0
 */
@Controller
public class ApiJsonController {
	/** http相关参数,常量可以放置到常量类里面去 **/
	private static final String DEFAULT_CHARSET = "UTF-8";
	private static final String DEFAULT_CONTENT_TYPE_NAME = "content-type";
	private static final String DEFAULT_CONTENT_TYPE_VALUE = "application/json;charset=UTF-8";

	/**
	 * @author fulei.yang
	 * @param request
	 * @param response
	 * @param apiName
	 * @param functionName
	 * @date 2016/9/1
	 */
	@RequestMapping(value = "/{serviceName}/{methodName}")
	public void RestfulHandler(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value = "serviceName") String serviceName,
			@PathVariable(value = "methodName") String methodName) {
		String serviceNameTemp = null;
		String methodNameTemp = null;
		String paramsString = null;
		// 获取serviceName和methodName
		serviceNameTemp = serviceName;
		methodNameTemp = methodName;
		// 取得数据流中参数
		try {
			InputStream is = request.getInputStream();
			String inputString = IOUtils.toString(is, DEFAULT_CHARSET);
			paramsString = inputString;
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 业务逻辑处理
		handleJson(response, serviceNameTemp, methodNameTemp, paramsString);
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
		PrintWriter pw = null;
		try {
			System.out.println(serviceName + methodName + paramsString);
			pw = response.getWriter();
			pw.print("hello");
		} catch (Exception e) {
		} finally {
			if (pw != null)
				pw.flush();
			pw.close();
		}
	}
}
