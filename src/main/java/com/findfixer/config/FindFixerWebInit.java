package com.findfixer.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class FindFixerWebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class<?>[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration){
        //上传文件的绝对路径,限制文件的大小，限制整个请求的文件大小
        registration.setMultipartConfig(new MultipartConfigElement("D:/",2097152,4194304,0));

	}
}
