package com.afu.dao;

import com.afu.dao.databasemodel.ServiceConfig;

/**
 * <p>
 * mybatis的映射接口-配置表接口
 * </p>
 * 
 * @author fulei.yang
 * @version 1.0.0
 * @date 2016/9/5
 */
public interface ServiceConfigDao {
	/**
	 * <p>获取单条配置表记录</p>
	 * 
	 * @return 单个配置表对象
	 */
	public ServiceConfig getServiceConfig();
}
