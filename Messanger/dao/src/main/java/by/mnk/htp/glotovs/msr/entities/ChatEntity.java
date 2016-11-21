package by.mnk.htp.glotovs.msr.entities;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sefire on 25.10.2016.*/

@Entity
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "chat")
public class ChatEntity implements IEntity<Integer> {
    @Id
    @GenericGenerator(name="increment" , strategy="increment")
    @GeneratedValue(generator="increment")
    @Column(name = "idChat")
    private int idChat;

    @Column(name = "lastTimeMessage")
    private GregorianCalendar lastTimeMessage;

    @ManyToMany(mappedBy = "chatEntities")
    private Set<UserEntity> userEntities = new HashSet<UserEntity>();

    @OneToMany(mappedBy = "chatEntity")
    private Set<MessageEntity> messageEntities;

    public Set<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(Set<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public Set<MessageEntity> getMessageEntities() {
        return messageEntities;
    }

    public void setMessageEntities(Set<MessageEntity> messageEntities) {
        this.messageEntities = messageEntities;
    }

    public ChatEntity(){

    }

    public Integer getId() {
        return idChat;
    }

    public void setId(Integer id) {
        this.idChat = id;

    }

    public GregorianCalendar getLastTimeMessage() {
        return lastTimeMessage;
    }

    public void setLastTimeMessage(GregorianCalendar lastTimeMessage) {
        this.lastTimeMessage = lastTimeMessage;
    }

    @Override
    public String toString() {
        return "ChatEntity{" +
                "idChat=" + idChat +
                ", lastTimeMessage=" + lastTimeMessage +
                '}';
    }
}
