package by.mnk.htp.glotovs.msr.entities;


import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * Created by Sefire on 24.10.2016.
 */
@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "user")
public class UserEntity implements IEntity<Integer> {

    @Id
    @GenericGenerator(name="increment" , strategy="increment")
    @GeneratedValue(generator="increment")
    @Column(name = "idUser")
    private Integer idUser;

    @Column(name = "phone")
    private String phone;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "password")
    private String password;

    @Column(name = "type")
    private String type;

    @Column(name = "access")
    private String access;

    @Column(name = "deletionStatus")
    private String deletionStatus;

    @OneToMany(mappedBy = "userEntity")
    private Set<FriendEntity> friendEntities;

    @OneToMany(mappedBy = "userEntity")
    private Set<MessageEntity> messageEntities;

    @ManyToMany//(cascade = {CascadeType.ALL})
   // @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "user_chat",
            joinColumns = {@JoinColumn(name = "idUser")},
            inverseJoinColumns = {@JoinColumn(name = "idChat")})
    private Set<ChatEntity> chatEntities;


    public UserEntity() {
    }

    public Set<FriendEntity> getFriendEntities() {
        return friendEntities;
    }

    public void setFriendEntities(Set<FriendEntity> friendEntities) {
        this.friendEntities = friendEntities;
    }

    public Set<MessageEntity> getMessageEntities() {
        return messageEntities;
    }

    public void setMessageEntities(Set<MessageEntity> messageEntities) {
        this.messageEntities = messageEntities;
    }

    public Set<ChatEntity> getChatEntities() {
        return chatEntities;
    }

    public void setChatEntities(Set<ChatEntity> chatEntities) {
        this.chatEntities = chatEntities;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getDeletionStatus() {
        return deletionStatus;
    }

    public void setDeletionStatus(String deletionStatus) {
        this.deletionStatus = deletionStatus;
    }

    public Integer getId() {
        return this.idUser;
    }

    public void setId(Integer idUser) {
        this.idUser = idUser;
    }

    public String getPhone() {
        return phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public Integer getAge() {
        return age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return //"UserEntity{" +
                "idUser = " + idUser +
                ", phone = " + phone + '\'' +
                ", firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", country = '" + country + '\'' +
                ", city = '" + city + '\'' +
                ", age = " + age //+
                //", password='" + password + '\'' +
                //'}'
                ;
    }
}
