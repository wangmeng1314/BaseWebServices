package com.afu.service.impl;

import org.apache.log4j.Logger;

import com.afu.service.BizService;
import com.afu.utils.SpringBeanUtil;

public class BizServiceImpl implements BizService {
	private static Logger bizServiceImplLogger = Logger.getLogger(SpringBeanUtil.class.getSimpleName());

	@Override
	public void resourcesName(String paramString) {
		bizServiceImplLogger.debug(paramString);
	}

}
