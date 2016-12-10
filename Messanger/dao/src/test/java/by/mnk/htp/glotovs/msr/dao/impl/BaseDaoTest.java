/*
package by.mnk.htp.glotovs.msr.dao.impl;

import by.mnk.htp.glotovs.msr.dao.exception.DaoException;
import by.mnk.htp.glotovs.msr.entities.UserEntity;
import junit.framework.TestCase;

*/
/**
 * Created by Sergey Glotov on 22.11.2016.
 *//*


public class BaseDaoTest extends TestCase {

    BaseDao<UserEntity, Integer> userBaseDao;
    UserEntity userEntity1;
    UserEntity userEntity2;

    public void setUp() throws Exception {
        userBaseDao = new UserDao();
        userEntity1 = new UserEntity();
        userEntity1.setId(1);
        userEntity1.setPhone("+37544585256");
        userEntity1.setFirstName("Alena");
        userEntity1.setLastName("Apina");
        userEntity1.setAge(11);
        userEntity1.setCountry("Russia");
        userEntity1.setCity("Moscow");
        userEntity1.setDeletionStatus("false");
        userEntity1.setAccess("true");
        userEntity1.setType("user");

        userEntity2 = new UserEntity();
        userEntity2.setPhone("+375445852001");
        userEntity2.setFirstName("Sergey1");
        userEntity2.setLastName("Glotov1");
        userEntity2.setAge(26);
        userEntity2.setCountry("Belarus");
        userEntity2.setCity("Minsk");

        try {
            userBaseDao.saveOrUpdate(userEntity1);
            userBaseDao.saveOrUpdate(userEntity2);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public void testSaveOrUpdate() throws Exception {
    }

    public void testGet() throws Exception {
        UserEntity userEntity = null;

        try {
            userEntity = userBaseDao.get(1);//Apina

        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertNotNull(userEntity);
        assertEquals(userEntity1, userEntity);
        assertNull(userBaseDao.get(10000000));
    }

    public void testLoad() throws Exception {

    }

    public void testDelete() throws Exception {

    }

    public void tearDown() throws Exception {

    }

}*/
