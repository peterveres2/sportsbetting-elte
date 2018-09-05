package com.epam.training.sportsbetting.web.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.h2.server.web.WebServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;




public class WebAppInitializer implements WebApplicationInitializer {
	
    @Override
    public void onStartup(ServletContext container) {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);
        rootContext.register(WebSecurityConfig.class);
        

        container.addListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(MVCConfig.class);
        

        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        ServletRegistration.Dynamic h2servlet = container.addServlet("h2-console", new WebServlet());
        h2servlet.setLoadOnStartup(2);
        h2servlet.addMapping("/h2/*");
        
        FilterRegistration.Dynamic characterEncodingFilter = container.addFilter("encoding-filter", new CharacterEncodingFilter());
    	characterEncodingFilter.setInitParameter("encoding", "UTF-8");
    	characterEncodingFilter.setInitParameter("forceEncoding", "true");
    	characterEncodingFilter.addMappingForUrlPatterns(null, true, "/*");
    	
        
        
    }
    
    
}
