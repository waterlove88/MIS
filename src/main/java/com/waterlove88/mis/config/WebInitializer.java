package com.waterlove88.mis.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

// web.xml을 대체
public class WebInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		CharacterEncodingFilter cef = new CharacterEncodingFilter();
		cef.setEncoding("UTF-8");
		cef.setForceEncoding(true);

		servletContext.addFilter("characterEncodingFilter", cef).addMappingForUrlPatterns(null, false, "/*");

		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(RootConfig.class);
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("appServlet", new DispatcherServlet(webContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}
