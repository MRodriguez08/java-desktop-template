package jsetemplate.application.persistence.daos;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import jsetemplate.application.persistence.HibernateUtil;
import org.hibernate.Session;


public abstract class DaoImpl<K, E> implements Dao<K, E>{

    protected Class<E> entityClass;

    protected Session session;

    @SuppressWarnings("unchecked")
    public DaoImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>)genericSuperclass.getActualTypeArguments()[1];
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @Override
    public void flush() {
        //em.flush();
    }

    @Override
    public void persist(E entity) {
        session.getTransaction().begin();
        session.merge(entity);
        session.getTransaction().commit();
    }

    @Override
    public void merge(E entity) {
        session.getTransaction().begin();
        session.save(entity);
        session.getTransaction().commit();
    }

    public void remove(E entity) {
        session.getTransaction().begin();
        session.merge(entity);
        session.getTransaction().commit();
    }

    @Override
    public E findById(K id) {
        session.beginTransaction();
        E e =  (E) session.get(entityClass, (Serializable)id);
        session.getTransaction().commit();
        return e;
    }

    @Override
    public void rollBack(){
        session.getTransaction().rollback();
    }
    
    @Override
    public List<E> findAll(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<E> list =  (List<E>)session.createCriteria(entityClass).list();
        session.getTransaction().commit();
        return list;
    }
	
	
}