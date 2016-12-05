package by.mnk.htp.glotovs.msr.command;

import by.mnk.htp.glotovs.msr.dao.exception.DaoException;
import by.mnk.htp.glotovs.msr.entities.UserEntity;
import by.mnk.htp.glotovs.msr.resource.ConfigurationManager;
import by.mnk.htp.glotovs.msr.resource.MessageManager;
import by.mnk.htp.glotovs.msr.services.exception.ServiceException;
import by.mnk.htp.glotovs.msr.services.factory.ServiceFactory;
import by.mnk.htp.glotovs.msr.services.factory.ServiceName;
import by.mnk.htp.glotovs.msr.services.impl.UserService;
import by.mnk.htp.glotovs.msr.util.HibernateSessionFactory;
import org.hibernate.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Sergey Glotov on 04.12.2016.
 */

public class FindUserByPhone implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
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
        }
        return page;
    }
}
