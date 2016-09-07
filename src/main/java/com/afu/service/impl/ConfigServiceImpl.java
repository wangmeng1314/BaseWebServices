package com.afu.service.impl;

import com.afu.dao.ServiceConfigDao;
import com.afu.service.ConfigService;

public class ConfigServiceImpl implements ConfigService {

	private ServiceConfigDao serviceConfigDao;

	@Override
	public ConfigService getConfig() {
		return (ConfigService) serviceConfigDao.getServiceConfig();
	}

	public void setServiceConfigDao(ServiceConfigDao serviceConfigDao) {
		this.serviceConfigDao = serviceConfigDao;
	}

}
