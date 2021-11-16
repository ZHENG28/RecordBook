package com.example.records.demo.DemoApplication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport{
	//配置静态文件访问地址（handler是访问地址、locations是真实地址）
		@Override
		protected void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/**").addResourceLocations("classpath:/static/")
			.addResourceLocations("file:f:/springboot/upload/");
			super.addResourceHandlers(registry);
		}
}
