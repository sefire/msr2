package by.mnk.htp.glotovs.msr.services.impl;

import by.mnk.htp.glotovs.msr.dao.exception.DaoException;
import by.mnk.htp.glotovs.msr.dao.impl.BaseDao;
import by.mnk.htp.glotovs.msr.dao.impl.FriendDao;
import by.mnk.htp.glotovs.msr.entities.FriendEntity;
import by.mnk.htp.glotovs.msr.entities.UserEntity;
import by.mnk.htp.glotovs.msr.services.exception.ServiceException;
import by.mnk.htp.glotovs.msr.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Sefire on 22.11.2016.
 */
public class FriendService extends BaseService<FriendEntity, Integer> {

    public List<UserEntity> getAllFriendsByUserId(Integer id) throws ServiceException {
        FriendDao friendDao = new FriendDao();
        List<UserEntity> userFriendsList = null;
        BaseDao<FriendEntity, Integer> baseDao = new BaseDao<FriendEntity, Integer>();
        try {
            userFriendsList = friendDao.getAllFriendsByUserId(id);
        } catch (DaoException e) {
            HibernateSessionFactory.closeSession();
            throw new ServiceException(e);
        }
        return userFriendsList;
    }

    public boolean DeleteFriendEntity(Integer idUser, Integer userFriendId) throws ServiceException {
        boolean isDeleted = false;
        FriendDao friendDao = new FriendDao();

        Transaction transaction = null;
        try {
            Session session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();
            isDeleted = friendDao.deleteFriendEntity(idUser, userFriendId);
            transaction.commit();
            HibernateSessionFactory.closeSession();
        } catch (DaoException e) {
            transaction.rollback();
            HibernateSessionFactory.closeSession();
            throw new ServiceException(e);
        }
        return isDeleted;
    }

    public FriendEntity get(Integer id) throws ServiceException {
        FriendEntity friendEntity = new FriendEntity();
        BaseDao<FriendEntity, Integer> baseDao = new BaseDao<FriendEntity, Integer>();
        try {
            friendEntity = baseDao.get(id);
        } catch (DaoException e) {
            HibernateSessionFactory.closeSession();
            throw new ServiceException(e);
        }
        return friendEntity;
    }

    public FriendEntity load(Integer id) throws ServiceException {
        FriendEntity friendEntity = new FriendEntity();
        BaseDao<FriendEntity, Integer> baseDao = new BaseDao<FriendEntity, Integer>();
        try {
            friendEntity = baseDao.load(id);
        } catch (DaoException e) {
            HibernateSessionFactory.closeSession();
            throw new ServiceException(e);
        }
        return friendEntity;
    }
}