package by.mnk.htp.glotovs.msr.dao.impl;

import by.mnk.htp.glotovs.msr.dao.interfaces.IMessageDao;
import by.mnk.htp.glotovs.msr.entities.ChatEntity;
import by.mnk.htp.glotovs.msr.entities.MessageEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sefire on 25.10.2016.*/

@Repository
public class MessageDao extends BaseDao<MessageEntity, Integer> implements IMessageDao<MessageEntity, Integer> {

    public List<MessageEntity> getAllMessagesByChatId(Integer idChat) {
        return null;
    }
 }
