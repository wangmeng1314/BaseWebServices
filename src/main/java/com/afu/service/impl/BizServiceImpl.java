package com.afu.service.impl;

import org.apache.log4j.Logger;

import com.afu.dao.ServiceConfigDao;
import com.afu.service.BizService;
import com.afu.utils.SpringBeanUtil;
import com.alibaba.fastjson.JSON;

public class BizServiceImpl implements BizService {


	private static Logger bizServiceImplLogger = Logger.getLogger(SpringBeanUtil.class.getSimpleName());
	private ServiceConfigDao serviceConfigDao;

	@Override
	public String resourcesName(String paramString) {
		bizServiceImplLogger.debug(paramString);
		String jsonString = JSON.toJSONString(serviceConfigDao.getServiceConfig());
		return jsonString;
	}

	public void setServiceConfigDao(ServiceConfigDao serviceConfigDao) {
		this.serviceConfigDao = serviceConfigDao;
	}
}
