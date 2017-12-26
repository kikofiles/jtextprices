package com.quimera.corptextiljt.model.dao.impl;

import java.io.Serializable;

public interface GenericDAO<T, PK extends Serializable>  {

	/** Persist the newInstance object into database */
	T create(T newInstance);

	/**
	 * Retrieve an object that was previously persisted to the database using
	 * the indicated id as primary key
	 */
	T read(PK id);

	/** Save changes made to a persistent object. */
	void update(T transientObject);

	/** Remove an object from persistent storage in the database */
	void delete(T persistentObject);
}
