package com.afu.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.afu.dao.ServiceConfigDao;
import com.afu.dao.databasemodel.ServiceConfig;

/**
 * 业务处理接口</br>
 * 
 * @author fulei.yang
 * @version 1.0.0
 * @date 2016/9/3
 */
public interface BizService {

	/**
	 * 获取资源的方法</br>
	 * 
	 * @author fulei.yang
	 * @version 1.0.0
	 * @return 
	 * @date 2016/9/3
	 */
	public String resourcesName(String paramString);
}
