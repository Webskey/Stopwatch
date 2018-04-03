package org.webskey.stopwatch.sql;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Connector {

	private static JdbcTemplate jdbcTemplate = setJdbcTemplate();
	private static ApplicationContext applicationContext;

	private static JdbcTemplate setJdbcTemplate(){
		applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
		return jdbcTemplate;
	}

	public static JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}
}