package com.plasmit.appointment.logging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class Config {
	
	   @Bean
	    public CommonsRequestLoggingFilter filter() {
	        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
	        filter.setIncludeQueryString(true);
	        filter.setIncludePayload(true);
	        filter.setMaxPayloadLength(10000);
	        return filter;
	    }

}
