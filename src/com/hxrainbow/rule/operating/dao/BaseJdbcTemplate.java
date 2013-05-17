package com.hxrainbow.rule.operating.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class BaseJdbcTemplate extends JdbcTemplate {
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource){
		super.setDataSource(dataSource);
	}
}
