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
import java.util.ArrayList;

/**
 * Created by Sefire on 27.10.2016.
 */
public class GetAllUsersCommand implements ActionCommand {

    public String execute(HttpServletRequest request) {
        String page = null;

        ArrayList<UserEntity> allUsersList = null;
        UserService userService = (UserService) ServiceFactory.getInstance().getService(ServiceName.USER);

        try {
            allUsersList = (ArrayList<UserEntity>) userService.getAll();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.setAttribute("alluserslist", allUsersList);

        page = ConfigurationManager.getProperty("path.page.allUsers");
        return page;
    }
}
