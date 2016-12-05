package by.mnk.htp.glotovs.msr.dao.impl;

import by.mnk.htp.glotovs.msr.dao.exception.DaoException;
import by.mnk.htp.glotovs.msr.entities.UserEntity;
import by.mnk.htp.glotovs.msr.util.HibernateSessionFactory;
import org.apache.log4j.Logger;
import org.hibernate.*;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Sefire on 24.10.2016.
 */

public class UserDao extends BaseDao<UserEntity, Integer> {
    private static Logger log = Logger.getLogger(UserDao.class);

    public UserEntity getUserEntityByPhone(String phone) throws DaoException {
        UserEntity userEntity = null;

        log.info("Get class by phone:" + phone);
        try {

            Session session = HibernateSessionFactory.getSession();
            Query query = session.createQuery("SELECT U FROM UserEntity as U where U.phone = :phone");
            query.setParameter("phone",phone);
            query.setCacheable(true);
            userEntity = (UserEntity) query.uniqueResult();
            log.info("get clazz:" + userEntity);
        } catch (HibernateException e) {
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return userEntity;
    }

    public List getAll() throws DaoException {
        List<UserEntity> userEntityList = null;

        log.info("Get all users");

        try {
            Session session = HibernateSessionFactory.getSession();
            Query query = session.createQuery("FROM UserEntity ");
            query.setCacheable(true);
            userEntityList = query.list();
            log.info("got all users!");
        } catch (HibernateException e) {
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return userEntityList;
    }

    public Integer totalUsersCount() throws DaoException {
        Integer totalUsersCount = 0;

        log.info("Get totalUsersCount");

        try {
            Session session = HibernateSessionFactory.getSession();

            Query query = session.createQuery("select count(user) from UserEntity user");
            query.setCacheable(true);
            Long totalUsers = (Long) query.uniqueResult();
             totalUsersCount = totalUsers != null ? totalUsers.intValue() : null;
            log.info("got totalUsersCount!");
        } catch (HibernateException e) {
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return totalUsersCount;
    }

    public List<UserEntity> getPartUsersPagination (Integer count, Integer startPosition) throws DaoException{
        List<UserEntity>  userEntityList = null;
        try {
            Session session = HibernateSessionFactory.getSession();
            String hql = "from UserEntity ";
            Query query = session.createQuery(hql);
            query.setFirstResult(startPosition);
            query.setMaxResults(count);
            query.setCacheable(true);
            userEntityList = query.list();
        } catch (HibernateException e) {
            log.error("Error get " + " in Dao" + e);
            throw new DaoException(e);
        }
        return userEntityList;
    }

    public List<UserEntity> getUserEntitiesByFNandLN(String firstName, String lastName) {
        return null;
    }

    public String getUserEntityPasswordByPhone(String phone) {
        return null;
    }

    public int getUserIdByPhone(String phone) {
        return 0;
    }

    public String changeUserEntityCountryById(Integer idUser) {
        return null;
    }

    public String changeUserEntityCityById(Integer idUser) {
        return null;
    }

    public int changeUserEntityAgeById(Integer idUser) {
        return 0;
    }

    public String changeUserEntityPasswordById(Integer idUser) {
        return null;
    }

    private Class getPersistentClass() {
        return (Class<UserDao>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
