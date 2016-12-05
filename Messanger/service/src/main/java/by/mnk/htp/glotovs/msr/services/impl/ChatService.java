package by.mnk.htp.glotovs.msr.services.impl;

import by.mnk.htp.glotovs.msr.dao.exception.DaoException;
import by.mnk.htp.glotovs.msr.dao.impl.BaseDao;
import by.mnk.htp.glotovs.msr.dao.impl.ChatDao;
import by.mnk.htp.glotovs.msr.dao.impl.FriendDao;
import by.mnk.htp.glotovs.msr.entities.ChatEntity;
import by.mnk.htp.glotovs.msr.entities.FriendEntity;
import by.mnk.htp.glotovs.msr.entities.UserEntity;
import by.mnk.htp.glotovs.msr.services.exception.ServiceException;
import by.mnk.htp.glotovs.msr.util.HibernateSessionFactory;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * Created by Sefire on 22.11.2016.
 */
public class ChatService extends BaseService<ChatEntity, Integer> {


    public List<ChatEntity> getUserChatsByUserId(Integer id) throws ServiceException
    {
        ChatDao chatDao = new ChatDao();
        List<ChatEntity> chatEntityList = null;
        BaseDao<FriendEntity, Integer> baseDao = new BaseDao<FriendEntity, Integer>();
        try {
            chatEntityList = chatDao.getUserChatsByUserId(id);

/*            for (ChatEntity  chatEntity:chatEntityList)
            {
                String lastTimeMessageString = null;

                    SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
                    fmt.setCalendar(chatEntity.getLastTimeMessage());
                    lastTimeMessageString = fmt.format(chatEntity.getLastTimeMessage().getTime());


//                java.util.GregorianCalendar[time=1480278481000,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Europe/Minsk",offset=10800000,dstSavings=0,useDaylight=false,transitions=69,lastRule=null],firstDayOfWeek=2,minimalDaysInFirstWeek=1,ERA=1,YEAR=2016,MONTH=10,WEEK_OF_YEAR=48,WEEK_OF_MONTH=4,DAY_OF_MONTH=27,DAY_OF_YEAR=332,DAY_OF_WEEK=1,DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=11,HOUR_OF_DAY=23,MINUTE=28,SECOND=1,MILLISECOND=0,ZONE_OFFSET=10800000,DST_OFFSET=0]

                chatEntity.setLastTimeMessageString(lastTimeMessageString);
            }*/


        } catch (DaoException e) {
            HibernateSessionFactory.closeSession();
            throw new ServiceException(e);
        }
        return chatEntityList;
    }



    public ChatEntity get(Integer id) throws ServiceException {
        ChatEntity chatEntity = new ChatEntity();
        BaseDao<ChatEntity, Integer> baseDao = new BaseDao<ChatEntity, Integer>();
        try {
            chatEntity = baseDao.get(id);
        } catch (DaoException e) {
            HibernateSessionFactory.closeSession();
            throw new ServiceException(e);
        }
        return chatEntity;
    }

    public ChatEntity load(Integer id) throws ServiceException {
        ChatEntity chatEntity = new ChatEntity();
        BaseDao<ChatEntity, Integer> baseDao = new BaseDao<ChatEntity, Integer>();
        try {
            chatEntity = baseDao.load(id);
        } catch (DaoException e) {
            HibernateSessionFactory.closeSession();
            throw new ServiceException(e);
        }
        return chatEntity;
    }
}