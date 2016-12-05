package by.mnk.htp.glotovs.msr.command;

import by.mnk.htp.glotovs.msr.entities.FriendEntity;
import by.mnk.htp.glotovs.msr.entities.UserEntity;
import by.mnk.htp.glotovs.msr.resource.ConfigurationManager;
import by.mnk.htp.glotovs.msr.services.exception.ServiceException;
import by.mnk.htp.glotovs.msr.services.factory.ServiceFactory;
import by.mnk.htp.glotovs.msr.services.factory.ServiceName;
import by.mnk.htp.glotovs.msr.services.impl.FriendService;
import by.mnk.htp.glotovs.msr.services.impl.UserService;
import by.mnk.htp.glotovs.msr.util.HibernateSessionFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by Sergey Glotov on 04.12.2016.
 */

public class AddFriend implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;

        Integer userFriendId = Integer.valueOf(request.getParameter("userFriendId"));


        FriendEntity friendEntity = new FriendEntity();
        UserEntity userEntity = null;

        HttpSession session = request.getSession();
        friendEntity.setUserFriendId(userFriendId);

        UserService userService = (UserService) ServiceFactory.getInstance().getService(ServiceName.USER);
        FriendService friendService = (FriendService) ServiceFactory.getInstance().getService(ServiceName.FRIEND);


        try {
            HibernateSessionFactory.getSession().beginTransaction();
            friendEntity.setUserEntity(userService.get(Integer.valueOf(session.getAttribute("idCurrentUser").toString())));
            userEntity = userService.get(userFriendId);
            friendService.saveOrUpdate(friendEntity);

            HibernateSessionFactory.getSession().getTransaction().commit();
            HibernateSessionFactory.closeSession();
        } catch (ServiceException e) {
            HibernateSessionFactory.getSession().getTransaction().rollback();
            HibernateSessionFactory.closeSession();
            e.printStackTrace();
        }

        request.setAttribute("anyUser", userEntity);
        request.setAttribute("isItFriend", true);
        request.setAttribute("fromPage", request.getAttribute("fromPage"));

        page = ConfigurationManager.getProperty("path.page.smbspage");
        return page;
    }
}
