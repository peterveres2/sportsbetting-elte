package com.epam.training.sportsbetting.web.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.epam.training.sportsbetting.web.controllers","com.epam.training.sportsbetting.web.aop","com.epam.training.sportsbetting.web.delaycontroller"})
public class MVCConfig extends WebMvcConfigurerAdapter {
	
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/pages/*.jsp").addResourceLocations("WEB-INF/pages/");
        registry.addResourceHandler("/js/*.js").addResourceLocations("WEB-INF/js/");
        registry.addResourceHandler("/assets/*.ico").addResourceLocations("WEB-INF/assets/");
        registry.addResourceHandler("/css/*").addResourceLocations("WEB-INF/css/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login");
        registry.addViewController("/test");   
        registry.addViewController("/register");
        registry.addViewController("/").setViewName("/login");
        registry.addViewController("/home");
        registry.addViewController("/status");
        registry.addViewController("/events");
        registry.addViewController("/bet");
        registry.addViewController("/wager_form*");
        registry.addViewController("/setdelay");
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
    	interceptor.setParamName("lang");
    	registry.addInterceptor(interceptor);
    }
    
    
    
    
    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n.lang");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setContentType("text/html;charset=UTF-8");
        return viewResolver;
        
    }
   
    @Bean
    public SessionLocaleResolver localeResolver(){
	SessionLocaleResolver sessionLocaleResolver= new SessionLocaleResolver();
	return sessionLocaleResolver;
	
    }
    
    
}
