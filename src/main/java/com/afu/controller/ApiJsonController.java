package com.afu.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.afu.utils.SpringBeanUtil;

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
	@Autowired(required = false)
	private SpringBeanUtil springBeanUtil;

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
		String targetApiName = methodName;
		String result = "";
		// 2:泛型执行对应的方法
		Object bean = springBeanUtil.getBeanByType(serviceName);
		for (Class<?> beanInterfaces : bean.getClass().getInterfaces()) {
			for (Method method : beanInterfaces.getMethods()) {
				String localMethodName = method.getName();
				// 判断methodName是否与apiName相同，忽略大小写
				if (localMethodName.equalsIgnoreCase(targetApiName)) {
					// BizService执行对应业务逻辑
					try {
						// 放入对应入参
						result = (String) method.invoke(bean, paramsString);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
		PrintWriter pw = null;
		try {
			// 输出结果
			pw = response.getWriter();
			pw.print(result);
		} catch (Exception e) {
		} finally {
			// 释放资源
			if (pw != null)
				pw.flush();
			pw.close();
		}
	}
}
