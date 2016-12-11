package by.mnk.htp.glotovs.msr.controller;

import by.mnk.htp.glotovs.msr.entities.ChatEntity;
import by.mnk.htp.glotovs.msr.entities.UserEntity;
import by.mnk.htp.glotovs.msr.services.exception.ServiceException;
import by.mnk.htp.glotovs.msr.services.impl.ChatService;
import by.mnk.htp.glotovs.msr.services.impl.FriendService;
import by.mnk.htp.glotovs.msr.services.interfaces.IChatService;
import by.mnk.htp.glotovs.msr.services.interfaces.IFriendService;
import by.mnk.htp.glotovs.msr.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by Sergey Glotov on 11.12.2016.
 */

@Controller
public class MainPageController {

    @Autowired
    private IFriendService friendService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IChatService chatService;

    private UserEntity userEntity;

    @RequestMapping(value = {"/main"})
    public String passRegistration(HttpSession httpSession) {
        //ModelAndView modelAndView = new ModelAndView("sessionCurrentUserPhoneNumber");
        httpSession.setAttribute("currentUserPhoneNumber", getPrincipal());

        try {
            userEntity = userService.getUserEntityByPhone(getPrincipal());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return "main";

    }

    @RequestMapping(value = {"/GETMYFRIENDS"})
    public ModelAndView getMyFriends() {
        ArrayList<UserEntity> userFriendsList = null;

        try {
            userFriendsList = (ArrayList<UserEntity>) friendService.getAllFriendsByUserId(userEntity.getId());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return new ModelAndView("userFriends", "userFriendsList", userFriendsList);
    }

    @RequestMapping(value = {"/GETMYCHATS"})
    public ModelAndView getMyChats() {

        ArrayList<ChatEntity> userChatsList = null;
        try {
            userChatsList = (ArrayList<ChatEntity>) chatService.getUserChatsByUserId(userEntity.getId());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userChats");
        modelAndView.addObject("userChatsList", userChatsList);
        modelAndView.addObject("idCurrentUser", userEntity.getId());
        return modelAndView;
    }

    @RequestMapping(value = {"/GETUSERSINFO"})
    public ModelAndView getUsersIngo() {

        UserEntity currentUserEntity = null;

        try {
            currentUserEntity = userService.getUserEntityByPhone(getPrincipal());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return new ModelAndView("userInfo", "userEntity", currentUserEntity);
    }
    @RequestMapping(value = {"/GETALLUSERS"})
    public ModelAndView getAllUsers() {

        ArrayList<UserEntity> allUsersList = null;
        try {
            allUsersList = (ArrayList<UserEntity>) userService.getAll();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
         return new ModelAndView("allUsers", "alluserslist", allUsersList);
    }

    @RequestMapping(value = {"/FINDUSER"})
    public ModelAndView findUserByPhone() {

        ArrayList<UserEntity> allUsersList = null;
        try {
            allUsersList = (ArrayList<UserEntity>) userService.getAll();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return new ModelAndView("allUsers", "alluserslist", allUsersList);
    }

/*    String page = null;
    String phoneToFind = request.getParameter("phoneNumberToFind");

    UserEntity userEntityFound = null;

    UserService userService = (UserService) ServiceFactory.getInstance().getService(ServiceName.USER);

    UserEntity currentUserEntity = null;

        try {
        HibernateSessionFactory.getSession().beginTransaction();
        userEntityFound = userService.getUserEntityByPhone(phoneToFind);
        currentUserEntity = userService.get(Integer.valueOf(request.getSession().getAttribute("idCurrentUser").toString()));
        if ( currentUserEntity!= null ) {
            request.setAttribute("anyUser", userEntityFound);
            boolean isItFriend = false;
            if (currentUserEntity.getFriendEntities().contains(userEntityFound))
                isItFriend = true;
            request.setAttribute("isItFriend", isItFriend);
        }

        HibernateSessionFactory.getSession().getTransaction().commit();
        HibernateSessionFactory.closeSession();
    } catch (ServiceException e) {
        HibernateSessionFactory.getSession().getTransaction().rollback();
        HibernateSessionFactory.closeSession();
        e.printStackTrace();
    }

        if (userEntityFound != null) {
        request.setAttribute("anyUser", userEntityFound);
        page = ConfigurationManager.getProperty("path.page.smbspage");
    } else {
        request.setAttribute("userNotFoundMessage", MessageManager.getProperty("message.usernotfound"));
        page = ConfigurationManager.getProperty("path.page.findUser");
    }*/

    private String getPrincipal() {
        String phoneNumber;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            phoneNumber = ((UserDetails) principal).getUsername();
        } else {
            phoneNumber = principal.toString();
        }
        return phoneNumber;
    }
}


