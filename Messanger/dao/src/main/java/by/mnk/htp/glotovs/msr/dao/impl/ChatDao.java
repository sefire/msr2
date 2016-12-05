package by.mnk.htp.glotovs.msr.dao.impl;

import by.mnk.htp.glotovs.msr.dao.exception.DaoException;
import by.mnk.htp.glotovs.msr.entities.ChatEntity;
import by.mnk.htp.glotovs.msr.entities.UserEntity;
import by.mnk.htp.glotovs.msr.util.HibernateSessionFactory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/*
 * Created by Sefire on 25.10.2016.*/

public class ChatDao extends BaseDao<ChatEntity, Integer> {
    private static Logger log = Logger.getLogger(FriendDao.class);

    public List<ChatEntity> getUserChatsByUserId(Integer idUser) throws DaoException {
        List<ChatEntity> chatEntityList = null;

        log.info("Get chats by id:" + idUser);
        try {
            Session session = HibernateSessionFactory.getSession();

            Query query = session.createQuery("SELECT C FROM ChatEntity as C join C.userEntities U" +
                    " where U.idUser =:idUser order by C.lastTimeMessage desc ");
            query.setParameter("idUser", idUser);
            query.setCacheable(true);
            chatEntityList = ( List<ChatEntity> ) query.list();
            log.info("Get chats by id:" + idUser);
        } catch (HibernateException e) {
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return chatEntityList;
    }

    public List<Integer> getAllChatIdsByUserId(Integer idUser) {
        return null;
    }

    public List getAll() {
        return null;
    }

    private Class getPersistentClass() {
        return (Class<UserDao>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
