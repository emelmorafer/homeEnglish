package com.ceiba.homeenglish.jdbc.dao.ex;

import org.springframework.dao.DataAccessException;

public class SQLException extends DataAccessException {

	private static final long serialVersionUID = -1235758393527189872L;

	public SQLException(String message, Throwable cause) {
		super(message, cause);
	}

	public SQLException(String message) {
		super(message);
	}

}
