package com.potato.web.conf;
import java.nio.charset.Charset;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
@EnableWebMvc		//开启SpringMVC支持，若无此句 重写WebMvcConfigurerAdapter方法无效
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
		registry.addViewController("/").setViewName("/loginPage");
		registry.addViewController("/message").setViewName("/message");
		
	}
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("*.css").addResourceLocations("classpath:/static/map/");
    }
	
	//设置请求返回数据的字符集
	//begin
	@Bean
	public HttpMessageConverter<String> responseBodyConverter(){
		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		return converter;
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		converters.add(responseBodyConverter());
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		super.configureContentNegotiation(configurer);
		configurer.favorPathExtension(false);
	}
	
	@InitBinder			//通过@InitBinder注解定制webDataBinder
	public void initBlnder(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields("id");			//忽略request参数的id
	}
	//end
	
//	//自定义拦截器
//	@Bean
//	public MenuInterceptor menuInterceptor() {
//		return new MenuInterceptor();
//	}
//	
//	//重写addInterceptors方法，注册拦截器
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(menuInterceptor());
//		super.addInterceptors(registry);
//	}
	
	/**
	 * 转换时间功能
	 */
	@Autowired
    private RequestMappingHandlerAdapter handlerAdapter;
    /**
     * 增加字符串转日期的功能
     */
    @PostConstruct
    public void initEditableValidation() {
        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter.getWebBindingInitializer();
        if (initializer.getConversionService() != null) {
            GenericConversionService genericConversionService = (GenericConversionService) initializer.getConversionService();
            genericConversionService.addConverter(new DateConverterConfig());
        }
    }
    @Bean
    public MultipartResolver multipartResolver() {
    	 CommonsMultipartResolver resolver = new CommonsMultipartResolver();
         resolver.setMaxUploadSize(50*1024*1024);//上传文件大小 50M 50*1024*1024
         return resolver;
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//设置允许跨域的路径
                .allowedOrigins("*")//设置允许跨域请求的域名
                .allowCredentials(true)//是否允许证书 不再默认开启
                .allowedMethods("GET", "POST", "PUT", "DELETE")//设置允许的方法
                .maxAge(3600);//跨域允许时间
    }

}

