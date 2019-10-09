package com.ceiba.homeenglish.jdbc.dao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

@Component
public abstract class Dao extends NamedParameterJdbcDaoSupport {

	private static final Logger LOGGER = LoggerFactory.getLogger(Dao.class);

	@Autowired
	private DataSource dataSource;

	public Dao() {

	}

	@Override
	protected void checkDaoConfig() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("--- CheckConfigDao ---");
		}

		super.setDataSource(this.dataSource);
	}


}
