package com.afu.dao.databasemodel;

import java.io.Serializable;

/**
 * <p>
 * 数据库映射实体类
 * </p>
 * 
 * @author fulei.yang
 * @version 1.0.0
 * @date 2016/9/5
 */
public class ServiceConfig implements Serializable {

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private static final long serialVersionUID = 3728853057606011851L;
	private Integer id;
	private String serviceName;
	private String methodName;
	private String serviceKey;
	private String methodKey;
	private String createTime;


	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getServiceKey() {
		return serviceKey;
	}

	public void setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
	}

	public String getMethodKey() {
		return methodKey;
	}

	public void setMethodKey(String methodKey) {
		this.methodKey = methodKey;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "ServiceConfig [id=" + id + ", serviceName=" + serviceName + ", methodName=" + methodName
				+ ", serviceKey=" + serviceKey + ", methodKey=" + methodKey + ", createTime=" + createTime + "]";
	}

}
