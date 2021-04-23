package com.appl.studentsbooks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//@Component
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.appl")
public class ApplicationConfig extends WebMvcConfigurationSupport {


    @Bean
   public ResourceBundleMessageSource messageSource(){
      ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
      messageSource.setBasenames("application","messages");
      return messageSource;
   }




}
