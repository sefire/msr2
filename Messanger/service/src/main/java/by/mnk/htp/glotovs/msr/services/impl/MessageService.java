package by.mnk.htp.glotovs.msr.services.impl;

import by.mnk.htp.glotovs.msr.dao.exception.DaoException;
import by.mnk.htp.glotovs.msr.dao.impl.BaseDao;
import by.mnk.htp.glotovs.msr.entities.MessageEntity;
import by.mnk.htp.glotovs.msr.entities.UserEntity;
import by.mnk.htp.glotovs.msr.services.exception.ServiceException;
import by.mnk.htp.glotovs.msr.util.HibernateSessionFactory;

import java.io.Serializable;


/**
 * Created by Sefire on 22.11.2016.
 */
public class MessageService extends BaseService<MessageEntity, Integer>  {

    public MessageEntity get(Integer id) throws ServiceException {
        MessageEntity messageEntity = new MessageEntity();
        BaseDao<MessageEntity, Integer> baseDao = new BaseDao<MessageEntity, Integer>();
        try {
            messageEntity = baseDao.get(id);
        } catch (DaoException e) {
            HibernateSessionFactory.closeSession();
            throw new ServiceException(e);
        }
        return messageEntity;
    }

    public MessageEntity load(Integer id) throws ServiceException {
        MessageEntity messageEntity = new MessageEntity();
        BaseDao<MessageEntity, Integer> baseDao = new BaseDao<MessageEntity, Integer>();
        try {
            messageEntity = baseDao.load(id);
        } catch (DaoException e) {
            HibernateSessionFactory.closeSession();
            throw new ServiceException(e);
        }
        return messageEntity;
    }
}
