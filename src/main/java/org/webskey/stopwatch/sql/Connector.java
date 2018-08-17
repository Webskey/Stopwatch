package org.webskey.stopwatch.sql;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public enum Connector {
	INSTANCE;

	private  JdbcTemplate jdbcTemplate;
	private ApplicationContext applicationContext;


	private Connector() {
		applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
	}	

	public JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}
}