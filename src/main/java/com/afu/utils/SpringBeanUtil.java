package com.afu.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 获取spring的core container</br>
 * 
 * @author fulei.yang
 * @version 1.0.0
 * @date 2016/8/17
 * 
 */
public class SpringBeanUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	private static Logger springBeanUtiLogger = Logger.getLogger(SpringBeanUtil.class.getSimpleName());

	@Override
	public void setApplicationContext(ApplicationContext appliContext) throws BeansException {
		applicationContext = appliContext;
	}

	/**
	 * 依据名字获取bean实例</br>
	 * 
	 * @param beanName
	 * @return 获取的bean
	 * @author fulei.yang
	 * @version 1.0.0
	 * @date 2016/9/3
	 */
	public Object getBeanByName(String beanName) {
		return applicationContext.getBean(beanName);
	}

	/**
	 * 依据类型（classType）获取bean实例</br>
	 * 
	 * @param classType
	 * @return 获取的bean
	 * @author fulei.yang
	 * @version 1.0.0
	 * @date 2016/9/3
	 */
	public Object getBeanByType(String classType) {
		Class<?> beanType = null;
		try {
			// 1:获取class类
			beanType = Class.forName(classType);
		} catch (ClassNotFoundException classE) {
			springBeanUtiLogger.info("项目空间内并不存在请求的bean类型");
			springBeanUtiLogger.info(classE.fillInStackTrace());
		}
		// 2:判断beanType是否存在，如果存在，则取出对应的bean，否则返回null.
		if (beanType != null) {
			return applicationContext.getBean(beanType);
		} else {
			return "您所请求的bean类型并不存在";
		}
	}
}
