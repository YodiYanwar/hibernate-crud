package com.yodiyanwar.dao;

import java.sql.SQLException;
import java.io.IOException;
import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Session;

import com.yodiyanwar.model.Person;
import com.yodiyanwar.util.HibernateUtil;

public class PersonDAOImpl implements PersonDAO{

	@Override
	public List listPersons() throws HibernateException{

			Transaction tx = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	     
	            tx = session.beginTransaction();
	            
	            List persons = session.createQuery("from Person").list();
	            
	            show("\n|===================================|");
        		show("|========== LIST PERSONS ===========|");
        		show("| -------- HIBERNATE CRUD --------- |");
        		show("|===================================|");
       			show("             Yodi Yanwar             \n");

	            for(Iterator itr = persons.iterator(); itr.hasNext();){
	                Person person = (Person) itr.next();
	                System.out.println("NIK    : "+person.getNik());
	                System.out.println("Nama   : "+person.getNama());
	                System.out.println("Alamat : "+person.getAlamat()+"\n");
	            }
	            tx.commit();
	   
            return persons;
	}

	@Override
	public void save(Person person) throws HibernateException{
		
		Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
		try{
	     
	        tx = session.beginTransaction();

	            session.save(person);
	            tx.commit();

	            System.out.println("\nSave operation Successfully\n"+person.getNama()+" Has Been Added !\n");

		} catch(HibernateException he){
			tx.rollback();
			System.out.println("Transaksi Telah di RollBack !");
		} finally{
			session.close();
		}
	}

	@Override
	public void update(Person person, Integer nik) throws HibernateException{
		Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
		try{
	     
	        tx = session.beginTransaction();
                    person = (Person) session.load(Person.class, new Integer(nik));
	            session.update(person);
	            tx.commit();

	            System.out.println("\nUpdate operation Successfully\n Has Been Edited !\n");

		} catch(HibernateException he){
			tx.rollback();
			System.out.println("Transaksi Telah di RollBack !");
		} finally{
			session.close();
		}
	}

	@Override
	public void delete(Integer nik) throws HibernateException{
		Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
		try{
	     
	        tx = session.beginTransaction();
                Person person = (Person) session.load(Person.class, nik);
	            session.delete(person);
	            tx.commit();

	            System.out.println("\nDelete operation Successfully\n"+person.getNama()+" Has Been Deleted !\n");

		} catch(HibernateException he){
			tx.rollback();
			System.out.println("Transaksi Telah di RollBack !");
		} finally{
			session.close();
		}
	}

	@Override
	public List getPerson(Integer nik) throws HibernateException{

			Transaction tx = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	     
	            tx = session.beginTransaction();
	            
	            List persons = session.createQuery("from Person where nik='"+nik+"'").list();
	            
	            show("\n|===================================|");
        		show("|============= PERSON =============|=");
        		show("| -------- HIBERNATE CRUD --------- |");
        		show("|===================================|");
       			show("             Yodi Yanwar             \n");

	            for(Iterator itr = persons.iterator(); itr.hasNext();){
	                Person person = (Person) itr.next();
	                System.out.println("NIK    : "+person.getNik());
	                System.out.println("Nama   : "+person.getNama());
	                System.out.println("Alamat : "+person.getAlamat()+"\n");
	            }
	            tx.commit();
	   
            return persons;
	}

	private void show(String pesan){
    	System.out.println(pesan);
    }
    private void showw(String pesan){
    	System.out.print(pesan);
    }
}