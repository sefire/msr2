package by.mnk.htp.glotovs.msr.command;

import by.mnk.htp.glotovs.msr.entities.UserEntity;
import by.mnk.htp.glotovs.msr.resource.ConfigurationManager;
import by.mnk.htp.glotovs.msr.services.exception.ServiceException;
import by.mnk.htp.glotovs.msr.services.factory.ServiceFactory;
import by.mnk.htp.glotovs.msr.services.factory.ServiceName;
import by.mnk.htp.glotovs.msr.services.impl.UserService;
import by.mnk.htp.glotovs.msr.services.interfaces.IService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Sefire on 26.10.2016.
 */
public class PassRegistrationCommand implements ActionCommand  {

    public String execute(HttpServletRequest request) {
        String page = null;

        UserEntity userEntity = new UserEntity();
        userEntity.setPhone((String)request.getParameter("phoneNumber"));
        userEntity.setFirstName((String)request.getParameter("firstname"));
        userEntity.setLastName((String)request.getParameter("lastname"));
        userEntity.setCountry((String)request.getParameter("country"));
        userEntity.setCity((String)request.getParameter("city"));
        userEntity.setAge((Integer.valueOf(request.getParameter("age"))));
        userEntity.setPassword((String)request.getParameter("password"));

        UserService userService = (UserService) ServiceFactory.getInstance().getService(ServiceName.USER);
        try {
            userService.saveOrUpdate(userEntity);
            HttpSession session = request.getSession();
            request.setAttribute("user", (String)request.getParameter("firstname")+ " " + (String)request.getParameter("lastname"));
            session.setAttribute("phoneNumberSession",(String)request.getParameter("phoneNumber"));

            page = ConfigurationManager.getProperty("path.page.main");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}