package by.mnk.htp.glotovs.msr.dao.interfaces;

import by.mnk.htp.glotovs.msr.dao.exception.DaoException;
import java.io.Serializable;

/**
 * Created by Sefire on 24.10.2016.
 */
public interface IDao<T> {
    void saveOrUpdate(T t) throws DaoException;

    T get(Serializable id) throws DaoException;

    T load(Serializable id) throws DaoException;

    void delete(T t) throws DaoException;
}
