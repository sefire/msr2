package by.mnk.htp.glotovs.msr.services.interfaces;

import by.mnk.htp.glotovs.msr.entities.IEntity;
import by.mnk.htp.glotovs.msr.services.exception.ServiceException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sefire on 25.10.2016.
 */
public interface IService<T> {

    void saveOrUpdate(T t) throws ServiceException;

    T get(Serializable id) throws ServiceException;

    T load(Serializable id) throws ServiceException;

    void delete(T t) throws ServiceException;
}
