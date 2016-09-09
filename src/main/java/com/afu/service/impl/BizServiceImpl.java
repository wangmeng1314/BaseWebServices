package com.afu.service.impl;

import org.apache.log4j.Logger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.afu.dao.ServiceConfigDao;
import com.afu.service.BizService;
import com.afu.thread.AsynLogsTask;
import com.afu.utils.SpringBeanUtil;
import com.alibaba.fastjson.JSON;

public class BizServiceImpl implements BizService {

	private static Logger bizServiceImplLogger = Logger.getLogger(SpringBeanUtil.class.getSimpleName());
	private ServiceConfigDao serviceConfigDao;
	private ThreadPoolTaskExecutor logsTaskExecutor;

	@Override
	public String resourcesName(String paramString) {
		bizServiceImplLogger.debug(paramString);
		// 放入线程池执行异步日志任务
		logsTaskExecutor.execute(new AsynLogsTask());
		String jsonString = JSON.toJSONString(serviceConfigDao.getServiceConfig());
		return jsonString;
	}

	public void setServiceConfigDao(ServiceConfigDao serviceConfigDao) {
		this.serviceConfigDao = serviceConfigDao;
	}
}
