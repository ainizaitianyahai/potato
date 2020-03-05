package com.potato.web.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.potato"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() { 
		return new ApiInfoBuilder()
            //页面标题
            .title("Spring Boot使用 Swagger2 构建RestFul API")
            //创建人
            .contact(new Contact("耿宏伟", "http://localhost:9090/swagger-ui.html#/", "1015333732@qq.com"))
            //版本号
            .version("1.0")
            //描述
            .description("跑圈模块接口文档")
            .build();
	}
}