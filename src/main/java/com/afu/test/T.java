package com.afu.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.afu.dao.ServiceConfigDao;
import com.afu.utils.SpringBeanUtil;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class T {
	@SuppressWarnings("resource")
	@Before
	public void setUp() throws Exception {
		new ClassPathXmlApplicationContext("META-INF/spring/ApplicationContext-*.xml");
	}

	@Test
	public void test() {
		SpringBeanUtil springBeanUtil = new SpringBeanUtil();
		ServiceConfigDao serviceConfigDao = (ServiceConfigDao) springBeanUtil.getBeanByName("configDao");
		System.out.println("test begin");
		Assert.assertNotNull(serviceConfigDao.getServiceConfig());
		System.out.println("test end");
	}
}
