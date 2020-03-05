package com.potato.web.conf;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

@Configuration
public class BeetlConf { 
	
	@Value("${RESOURCE.root:/templates}")
    String resourceRoot;// 模板跟目录
//	
//	@Autowired
//	GroupTemplate groupTemplate;
//	
//	@PostConstruct
//	public void config() {
//		groupTemplate.registerFunctionPackage("so", new ShiroExt());
//	}
	@Bean(initMethod = "init", name = "beetlConfig")  
	public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
		BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        ClasspathResourceLoader classPathLoader = new ClasspathResourceLoader(this.getClass().getClassLoader(),resourceRoot);
        beetlGroupUtilConfiguration.setResourceLoader(classPathLoader);
        // 读取配置文件信息
        ResourcePatternResolver patternResolver = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
        beetlGroupUtilConfiguration.setConfigFileResource(patternResolver.getResource("classpath:beetl.properties"));
        return beetlGroupUtilConfiguration;
	}
//	
	@Bean(name = "beetlViewResolver")
	public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
	    BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
	    beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
	    beetlSpringViewResolver.setSuffix(".html");
	    beetlSpringViewResolver.setOrder(0);
	    beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
	    return beetlSpringViewResolver;
	}
	
}
