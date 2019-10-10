package com.ceiba.homeenglish.jdbc.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

@Component
public abstract class Dao extends NamedParameterJdbcDaoSupport {

	@Autowired
	private DataSource dataSource;

	public Dao() {

	}

	@Override
	protected void checkDaoConfig() {

		super.setDataSource(this.dataSource);
	}


}
