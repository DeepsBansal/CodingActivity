package com.ibm.OrderProcessService.configurer;

import org.springframework.context.annotation.Configuration;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


@Configuration
public class WebConfiguration {

	@Bean
	 ServletRegistrationBean<WebServlet> h2servletRegistration(){
		ServletRegistrationBean<WebServlet> registrationBean  = new ServletRegistrationBean<WebServlet>( new WebServlet());
        registrationBean.addUrlMappings("/h2-console/*");
        return registrationBean;

}
}
