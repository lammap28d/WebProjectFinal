package com.bikeweb.helper;

import com.bikeweb.entity.Bike;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class GenericHelper<E, K extends Serializable> extends HibernateUtil {
	
	protected Class<? extends E> clazz;
	
	public GenericHelper() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType)t;
		this.clazz = (Class)pt.getActualTypeArguments()[0];
	}
	
	public void save(E entity) {
            try {
                Session session = getSession();
		Transaction trans = session.beginTransaction();
		session.saveOrUpdate(entity);
		trans.commit();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
		
	}

	public void update(E entity) {
		 try {
                Session session = getSession();
		Transaction trans = session.beginTransaction();
		session.update(entity);
		trans.commit();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
		
	}

	public void delete(E entity) {
		 try {
                Session session = getSession();
		Transaction trans = session.beginTransaction();
                
		session.delete(entity);
		trans.commit();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
		
	}

	public E find(K key) {
                Session session = getSession();
		Transaction trans = session.beginTransaction();
		E result = (E) getSession().get(this.clazz, key);
                trans.commit();
                return result;
	}

	@SuppressWarnings("unchecked")
	public List<E> getAll() {
                Session session = getSession();
		Transaction trans = session.beginTransaction();
                List<E> result = session.createCriteria(clazz).list();
                trans.commit();
		// TODO Auto-generated method stub
		return result;
	}
	
	protected Criteria creatteEntittyCriteia() {
		return getSession().createCriteria(this.clazz);
	}


}
