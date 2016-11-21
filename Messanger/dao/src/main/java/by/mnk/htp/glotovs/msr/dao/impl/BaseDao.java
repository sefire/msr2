package by.mnk.htp.glotovs.msr.dao.impl;

import by.mnk.htp.glotovs.msr.dao.exception.DaoException;
import by.mnk.htp.glotovs.msr.dao.interfaces.IDao;
import by.mnk.htp.glotovs.msr.util.HibernateSessionFactory;

import org.apache.log4j.Logger;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public class BaseDao<T> implements IDao<T> {
    private static Logger log = Logger.getLogger(BaseDao.class);

    public BaseDao() {
    }

    public void saveOrUpdate(T t) throws DaoException {
        log.info("Start saveOrUpdate:" + t);
        try {
            Session session = HibernateSessionFactory.getSession();
            session.saveOrUpdate(t);
            log.info("End saveOrUpdate:" + t);
        } catch (HibernateException e) {
            log.error("Error save or update in Dao" + e);
            throw new DaoException(e);
        }
    }

    public T get(Serializable id) throws DaoException {
        log.info("Start get class by id:" + id);
        T t = null;
        try {
            Session session = HibernateSessionFactory.getSession();
            t = (T) session.get(getPersistentClass(), id);
            log.info("End get class by id: " + t);
        } catch (HibernateException e) {
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return t;
    }

    public T load(Serializable id) throws DaoException {
        log.info("Start loading class by id:" + id);
        T t = null;
        try {
            Session session = HibernateSessionFactory.getSession();
            t = (T) session.load(getPersistentClass(), id);
            log.info("End loading class");
            try {
                log.info("load() was successful:" + t);
            } catch (ObjectNotFoundException e) {
                log.error("!!!Congratulations!\nYou managed to get ObjectNotFoundException on load()!!!");
            }
        } catch (HibernateException e) {
            log.error("Error load() " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return t;
    }

    public void delete(T t) throws DaoException {
        try {
            Session session = HibernateSessionFactory.getSession();
            session.delete(t);
            log.info("Delete:" + t);
        } catch (HibernateException e) {
            log.error("Error delete in Dao" + e);
            throw new DaoException(e);
        }
    }

    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
