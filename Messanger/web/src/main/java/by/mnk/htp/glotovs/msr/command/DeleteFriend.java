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

/**
 * Created by Sergey Glotov on 04.12.2016.
 */

public class DeleteFriend implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;

        Integer userFriendId = Integer.valueOf(request.getParameter("userFriendId"));


        UserEntity userEntity = null;

        HttpSession session = request.getSession();

        FriendService friendService = (FriendService) ServiceFactory.getInstance().getService(ServiceName.FRIEND);
        try {
            friendService.DeleteFriendEntity(Integer.valueOf(session.getAttribute("idCurrentUser").toString()), userFriendId);

        } catch (ServiceException e) {
            e.printStackTrace();
        }

        UserService userService = (UserService) ServiceFactory.getInstance().getService(ServiceName.USER);

        try {
            HibernateSessionFactory.getSession().beginTransaction();
            userEntity = userService.get(userFriendId);
            HibernateSessionFactory.getSession().getTransaction().commit();
            HibernateSessionFactory.closeSession();
        } catch (ServiceException e) {
            HibernateSessionFactory.getSession().getTransaction().rollback();
            HibernateSessionFactory.closeSession();
            e.printStackTrace();
        }
        request.setAttribute("anyUser", userEntity);
        request.setAttribute("isItFriend", false);
        request.setAttribute("fromPage", request.getAttribute("fromPage"));

        if (request.getParameter("fromPage").equals(ConfigurationManager.getProperty("path.page.smbspage")))
            page = ConfigurationManager.getProperty("path.page.smbspage");

        else if (request.getParameter("fromPage").equals(ConfigurationManager.getProperty("path.page.userFriends")))
            page = (new GetMyFriends()).execute(request);
        return page;
    }
}