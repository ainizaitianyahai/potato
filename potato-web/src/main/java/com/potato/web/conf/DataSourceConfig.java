package com.potato.web.conf;

import javax.sql.DataSource;

import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.beetl.sql.ext.spring4.BeetlSqlScannerConfigurer;
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {    
	
	@Bean(name="datasource")
	public DataSource datasource(Environment env) {
	    HikariDataSource ds = new HikariDataSource();
	    ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
	    ds.setUsername(env.getProperty("spring.datasource.username"));
	    ds.setPassword(env.getProperty("spring.datasource.password"));
	    ds.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
	    return ds;
	}
	@Bean(name="beetlSqlScannerConfigurer")
	public BeetlSqlScannerConfigurer getBeetlSqlScannerConfigurer() {
		BeetlSqlScannerConfigurer bc = new BeetlSqlScannerConfigurer();
		//哪些类可以自动注入
		bc.setBasePackage("com");
		//<!-- 通过类后缀 来自动注入Dao -->
		bc.setDaoSuffix("Dao");
		bc.setSqlManagerFactoryBeanName("sqlManagerFactoryBean");;
	    return bc;
	}
	@Bean
    public BeetlSqlDataSource beetlSqlDataSource(@Qualifier("datasource") DataSource dataSource) {
        BeetlSqlDataSource source = new BeetlSqlDataSource();
        source.setMasterSource(dataSource);
        return source;
    }
    @Bean(name = "sqlManagerFactoryBean")
    @Primary
    public SqlManagerFactoryBean getSqlManagerFactoryBean(@Qualifier("datasource") DataSource datasource) {
        SqlManagerFactoryBean factory = new SqlManagerFactoryBean();
        BeetlSqlDataSource source = new BeetlSqlDataSource();
        source.setMasterSource(datasource);
        factory.setCs(source);
        factory.setDbStyle(new MySqlStyle());
        factory.setInterceptors(new Interceptor[]{new DebugInterceptor()});
        factory.setNc(new UnderlinedNameConversion());//开启驼峰
        factory.setSqlLoader(new ClasspathLoader("/sql"));//sql文件路径
        return factory;
    }
    @Bean(name="sqlManager")
    public SQLManager getSqlManager(@Qualifier("sqlManagerFactoryBean") SqlManagerFactoryBean sqlManagerFactoryBean){
        SQLManager sqlManager = null;
        try {
            sqlManager = sqlManagerFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return sqlManager;
    }
}