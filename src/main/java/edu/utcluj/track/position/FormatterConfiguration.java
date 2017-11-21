package edu.utcluj.track.position;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class FormatterConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd HH:mm:ss"));
	}
}
