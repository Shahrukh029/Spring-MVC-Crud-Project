package com.sevenmentor.spring.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class WebApplictionInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] clazz= {AppConfig.class};
		return clazz;
	}

	@Override
	protected String[] getServletMappings() {
		String [] array= {"/"};
		return array;
	}
}
