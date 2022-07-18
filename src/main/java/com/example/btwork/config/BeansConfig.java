package com.example.btwork.config;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class BeansConfig {
	
	@Bean
	MappingJackson2HttpMessageConverter httpObjectMapper() {
		MappingJackson2HttpMessageConverter config = new MappingJackson2HttpMessageConverter();
		ObjectMapper om = new ObjectMapper();
		om.setDateFormat(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));
		List<MediaType> mediaTypeList = List.of(MediaType.APPLICATION_JSON,
				MediaType.parseMediaType("application/javascript"));
		config.setObjectMapper(om);
		config.setSupportedMediaTypes(mediaTypeList);
		
		return config;
	}
	
}
