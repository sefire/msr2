package by.mnk.htp.glotovs.msr.command;

import by.mnk.htp.glotovs.msr.resource.ConfigurationManager;
import by.mnk.htp.glotovs.msr.resource.MessageManager;
import by.mnk.htp.glotovs.msr.services.exception.ServiceException;
import by.mnk.htp.glotovs.msr.services.factory.ServiceFactory;
import by.mnk.htp.glotovs.msr.services.factory.ServiceName;
import by.mnk.htp.glotovs.msr.services.impl.UserService;
import by.mnk.htp.glotovs.msr.util.HibernateSessionFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Sefire on 25.10.2016.
 */

public class LoginCommand implements ActionCommand {
    private static final String PARAM_PHONE_NUMBER = "phoneNumber";
    private static final String PARAM_PASSWORD = "password";

    public String execute(HttpServletRequest request) {
        String page = null;
        String phone = request.getParameter(PARAM_PHONE_NUMBER);
        String pass = request.getParameter(PARAM_PASSWORD);
        Integer idCurrentUser = 0;

        UserService userService = (UserService) ServiceFactory.getInstance().getService(ServiceName.USER);

        String userFullName = null;

        try {
            HibernateSessionFactory.getSession().beginTransaction();
            userFullName = userService.checkLoginGetFullName(phone, pass);
            idCurrentUser = userService.getUserEntityByPhone(phone).getId();
            HibernateSessionFactory.getSession().getTransaction().commit();
            HibernateSessionFactory.closeSession();
        } catch (ServiceException e) {
            HibernateSessionFactory.getSession().getTransaction().rollback();
            HibernateSessionFactory.closeSession();
            e.printStackTrace();
        }

        if (userFullName != null) {
            request.setAttribute("user", userFullName);
            HttpSession session = request.getSession();
            session.setAttribute("phoneNumberSession", phone);
            session.setAttribute("user", userFullName);
            session.setAttribute("idCurrentUser", idCurrentUser );
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
