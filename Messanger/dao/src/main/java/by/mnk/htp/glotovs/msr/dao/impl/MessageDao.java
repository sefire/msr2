package by.mnk.htp.glotovs.msr.dao.impl;

import by.mnk.htp.glotovs.msr.entities.ChatEntity;
import by.mnk.htp.glotovs.msr.entities.MessageEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sefire on 25.10.2016.*/


public class MessageDao extends BaseDao<ChatEntity, Integer> {

    public List<MessageEntity> getAllMessagesByChatId(Integer idChat) {
        return null;
    }
 }
