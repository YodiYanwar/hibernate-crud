package com.yodiyanwar.dao;

import com.yodiyanwar.model.Person;
import java.io.IOException;
import java.util.List;
import org.hibernate.HibernateException;

public interface PersonDAO{

	public List listPersons() throws HibernateException;
	public void save(Person person) throws HibernateException;
	public void update(Person person, Integer nik) throws HibernateException, IOException;
	public void delete(Integer nik) throws HibernateException;
	public List getPerson(Integer nik) throws HibernateException;
}