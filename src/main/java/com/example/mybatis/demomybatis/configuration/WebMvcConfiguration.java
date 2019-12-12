package com.example.mybatis.demomybatis.configuration;

import com.example.mybatis.demomybatis.interceptor.CsrfInterceptor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.Arrays;
import java.util.List;


@Configuration
@EnableAutoConfiguration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

	private static List<String> pathMatch = Arrays.asList("/index*");
	public WebMvcConfiguration() {
	}

	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(this.csrfInterceptor()).addPathPatterns(pathMatch);
		super.addInterceptors(registry);
	}



	public CsrfInterceptor csrfInterceptor() {
		return new CsrfInterceptor();
	}


}
