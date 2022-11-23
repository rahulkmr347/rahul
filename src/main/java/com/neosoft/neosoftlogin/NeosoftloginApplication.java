package com.neosoft.neosoftlogin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = "com.neosoft.neosoftlogin")
public class NeosoftloginApplication {

	@Value("${swagger.enabled}")
	public boolean isSwaggerEnabled;

	public static void main(String[] args) {
		SpringApplication.run(NeosoftloginApplication.class, args);
	}

	@Bean
	public Docket swagger(){
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(isSwaggerEnabled)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.neosoft.neosoftlogin"))
				.paths(PathSelectors.any())
				.build();
	}
}
