package com.ammodata.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRepository<T, PK extends Serializable> {

	@Autowired
	private SessionFactory factory;

	private Class<T> type;
	
	@SuppressWarnings("unchecked")
	public AbstractRepository() {
		this.type = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	protected Session getSession()
	{
		return factory.getCurrentSession();
	}

	public T create(T o)
	{
		getSession().save(o);
		return o;
	}

	public T createOrUpdate(T o)
	{
		getSession().saveOrUpdate(o);
		return o;
	}

	@SuppressWarnings("unchecked")
	public T read(PK id)
	{
		return (T) getSession().get(type, id);
	}

	@SuppressWarnings("unchecked")
	public T read(PK pk, String[] leftFetch) throws Exception
	{
		String idProperty = getSession().getSessionFactory().getClassMetadata(type).getIdentifierPropertyName();
		Session session = getSession();

		Criteria criteria = session.createCriteria(type).add(Restrictions.eq(idProperty, pk));
		for (String prop : leftFetch) {
			criteria.createAlias(prop, prop.replace(".", ""), JoinType.LEFT_OUTER_JOIN);
		}

		criteria.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
		T record = (T) criteria.uniqueResult();

		return record;
	}
	
	@SuppressWarnings("unchecked")
	public T read(PK pk, String[] leftFetch, String[] orderAsc) throws Exception
	{
		String idProperty = getSession().getSessionFactory().getClassMetadata(type).getIdentifierPropertyName();
		Session session = getSession();

		Criteria criteria = session.createCriteria(type).add(Restrictions.eq(idProperty, pk));
		for (String prop : leftFetch) {
			criteria.createAlias(prop, prop.replace(".", ""), JoinType.LEFT_OUTER_JOIN);
		}
		
		for (String prop : leftFetch) {
			criteria.addOrder(Order.asc(prop));
		}

		criteria.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
		T record = (T) criteria.uniqueResult();

		return record;
	}	
	
	@SuppressWarnings("unchecked")
	public List<T> readAll(PK[] pk) throws Exception
	{
		String idProperty = getSession().getSessionFactory().getClassMetadata(type).getIdentifierPropertyName();
		List<T> records = getSession().createCriteria(type).add(Restrictions.in(idProperty, pk)).list();
		return records;
	}

	@SuppressWarnings("unchecked")
	public List<T> readAll() throws Exception
	{
		List<T> records = getSession().createCriteria(type).list();
		return records;
	}

	public T refresh(T record) throws Exception
	{
		getSession().refresh(record);
		return record;
	}

	public void update(T t) throws Exception
	{
		getSession().update(t);
	}

	public void delete(T t) throws Exception
	{
		getSession().delete(t);
	}

	public void delete(PK pk) throws Exception
	{
		T t = read(pk);
		if (t != null)
			getSession().delete(t);
	}
}
