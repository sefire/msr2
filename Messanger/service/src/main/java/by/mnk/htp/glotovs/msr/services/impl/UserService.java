package by.mnk.htp.glotovs.msr.services.impl;

import by.mnk.htp.glotovs.msr.dao.exception.DaoException;
import by.mnk.htp.glotovs.msr.dao.factory.DaoImplFactory;
import by.mnk.htp.glotovs.msr.dao.factory.DaoImplName;
import by.mnk.htp.glotovs.msr.dao.impl.BaseDao;
import by.mnk.htp.glotovs.msr.dao.impl.UserDaoImpl;
import by.mnk.htp.glotovs.msr.entities.UserEntity;
import by.mnk.htp.glotovs.msr.services.exception.ServiceException;
import by.mnk.htp.glotovs.msr.services.factory.ServiceFactory;
import by.mnk.htp.glotovs.msr.services.factory.ServiceName;
import by.mnk.htp.glotovs.msr.util.HibernateSessionFactory;
import by.mnk.htp.glotovs.msr.vo.UserPaginationVO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Sefire on 25.10.2016.
 */

public class UserService extends BaseService<UserEntity> {
    public UserEntity getUserEntityByPhone(String phone) throws ServiceException {
        UserEntity userEntity = null;
        Transaction transaction = null;
        UserDaoImpl userDao = (UserDaoImpl) DaoImplFactory.getInstance().getDaoImpl(DaoImplName.USER);
        try {
            Session session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();
            userEntity = userDao.getUserEntityByPhone(phone);
            transaction.commit();
            HibernateSessionFactory.closeSession();
        } catch (DaoException e) {
            transaction.rollback();
            HibernateSessionFactory.closeSession();
            e.printStackTrace();
        }
        return userEntity;
    }

    public String checkLoginGetFullName(String phoneFromUser, String passFromUser) throws ServiceException {
        String phoneFromDB = "";
        String passwordFromDB = "";
        UserEntity userEntity = getUserEntityByPhone(phoneFromUser);
        if (userEntity != null) {
            phoneFromDB = userEntity.getPhone();
            passwordFromDB = userEntity.getPassword();
            if (phoneFromDB.equals(phoneFromUser) && passwordFromDB.equals(passFromUser)) {
                return userEntity.getFirstName() + " " + userEntity.getLastName();
            } else
                return null;
        } else {
            return null;
        }
    }

    public UserPaginationVO paginationUsers(String page, Integer countPerPage) throws ServiceException {

        UserPaginationVO userPaginationVO = new UserPaginationVO();

        Integer newPage = page != null ? Integer.valueOf(page) : 1;
        List<UserEntity> userEntityList = null;
        Integer totalUsersCount =0;

        Transaction transaction = null;
        UserDaoImpl userDao = (UserDaoImpl) DaoImplFactory.getInstance().getDaoImpl(DaoImplName.USER);

        try {
            Session session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();
            totalUsersCount = userDao.totalUsersCount();
            Integer first = countPerPage*(newPage-1);
            userEntityList = userDao.getPartUsersPagination(countPerPage,first);
            transaction.commit();
            HibernateSessionFactory.closeSession();
        } catch (DaoException e) {
            transaction.rollback();
            HibernateSessionFactory.closeSession();
            e.printStackTrace();
        }

        userPaginationVO.setPage(String.valueOf(newPage));
        userPaginationVO.setTotalUsersCount(totalUsersCount);
        userPaginationVO.setUserEntityList(userEntityList);

        return userPaginationVO;
    }

    public List getAll() throws ServiceException {
        Transaction transaction = null;
        UserDaoImpl userDaoImpl = (UserDaoImpl) DaoImplFactory.getInstance().getDaoImpl(DaoImplName.USER);
        List userEntities = null;
        try {
            Session session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();
            userEntities = userDaoImpl.getAll();
            transaction.commit();
            HibernateSessionFactory.closeSession();
        } catch (DaoException e) {
            transaction.rollback();
            HibernateSessionFactory.closeSession();
            e.printStackTrace();
        }
        return userEntities;
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

    public String changeUserEntityCountryById(int idUser) {
        return null;
    }

    public String changeUserEntityCityById(int idUser) {
        return null;
    }

    public int changeUserEntityAgeById(int idUser) {
        return 0;
    }

    public String changeUserEntityPasswordById(int idUser) {
        return null;
    }
}
