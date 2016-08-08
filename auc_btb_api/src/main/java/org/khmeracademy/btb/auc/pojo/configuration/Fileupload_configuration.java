/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.configuration;

import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author KUYLIM
 */
@Configuration
@EnableWebMvc
public class Fileupload_configuration extends WebMvcConfigurerAdapter{
    
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() throws IOException
    {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        
        resolver.setMaxUploadSizePerFile(5242880);
        
        return resolver;
    }
    
    @Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("").setViewName("upload");
	}
    
    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {	
		registry.addResourceHandler("/files/images/**").addResourceLocations("file:/opt/images/");
	}
}
