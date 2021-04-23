package com.appl.studentsbooks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
//@Component
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.appl")
public class ApplicationConfig extends WebMvcConfigurationSupport {



   @Bean
   public ResourceBundleMessageSource messageSource(){
      ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
      messageSource.setBasename("application");
//    This method is throwing no
      return messageSource;
   }


   @Bean
    public InternalResourceViewResolver resolver(){
      System.out.println("View Resolver");
       InternalResourceViewResolver resolver=new InternalResourceViewResolver();
       resolver.setPrefix("/WEB-INF/jsp/");
       resolver.setSuffix(".jsp");
       resolver.setViewClass(JstlView.class);
       return resolver;
   }


}
