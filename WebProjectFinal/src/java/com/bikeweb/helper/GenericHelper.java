package com.bikeweb.helper;

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
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		session.saveOrUpdate(entity);
		trans.commit();
	}

	public void update(E entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(E entity) {
		// TODO Auto-generated method stub
		
	}

	public E find(K key) {
		return (E) getSession().get(this.clazz, key);
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
