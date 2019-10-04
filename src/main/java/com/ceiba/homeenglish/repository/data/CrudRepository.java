package com.ceiba.homeenglish.repository.data;

import java.util.List;

public interface CrudRepository<T> {

	public T save(T domain);

	public T findById(Long id);
	
	public List<T> findAll();

}
