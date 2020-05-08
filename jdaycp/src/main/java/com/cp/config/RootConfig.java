package com.cp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"com.cp.sample"})
public class RootConfig {
	
//	@Bean
//	public HikariConfig hikariConfig() {
//		return new HikariConfig();
//	}
	
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hikariConfig.setJdbcUrl("jdbc:mysql://cpserver.cdeamujkn2lg.ap-northeast-2.rds.amazonaws.com/cpspringex?serverTimezone=Asia/Seoul");
		hikariConfig.setUsername("cpspringuser");
		hikariConfig.setPassword("cpspringuser");
		HikariDataSource k =  new HikariDataSource(hikariConfig);
		System.out.println(k);
		return k;
	}
}
