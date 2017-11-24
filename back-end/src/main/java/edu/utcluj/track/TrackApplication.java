package edu.utcluj.track;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TrackApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TrackApplication.class, args);
	}
	
	  @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	      return builder.sources(TrackApplication.class);
	  }

	@Bean
	public DataSource dataSource() throws IOException {
		Properties dsProps = PropertiesLoaderUtils.loadAllProperties("datasource.properties");
		Properties hikariProps = PropertiesLoaderUtils.loadAllProperties("hikari.properties");
		hikariProps.put("dataSourceProperties", dsProps);
		return new HikariDataSource(new HikariConfig(hikariProps));
	}



	// for swagger: http://localhost:8085/swagger-ui.html
	@Bean
	public Docket apiTest() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("edu.utcluj.track"))
				.paths(PathSelectors.any())
				.build();
	}
}
