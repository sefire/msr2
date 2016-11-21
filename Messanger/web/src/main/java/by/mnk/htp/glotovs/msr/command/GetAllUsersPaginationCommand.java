package by.mnk.htp.glotovs.msr.command;
/**
 * Created by Sefire on 20.11.2016.
 */

import by.mnk.htp.glotovs.msr.resource.ConfigurationManager;
import by.mnk.htp.glotovs.msr.services.exception.ServiceException;
import by.mnk.htp.glotovs.msr.services.factory.ServiceFactory;
import by.mnk.htp.glotovs.msr.services.factory.ServiceName;
import by.mnk.htp.glotovs.msr.services.impl.UserService;
import by.mnk.htp.glotovs.msr.vo.UserPaginationVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by Sefire on 27.10.2016.
 */
public class GetAllUsersPaginationCommand implements ActionCommand {

    public String execute(HttpServletRequest request) {

        UserPaginationVO userPaginationVO = null;
        UserService userService = (UserService) ServiceFactory.getInstance().getService(ServiceName.USER);

        String page = null;
        String countPerPage = null;

        page = request.getParameter("page");

        HttpSession session = request.getSession();

        //page = String.valueOf(request.getAttribute("page"));
        //countPerPage =  (String) session.getAttribute("countPerPage"); STILL NOT EXIST ON JSP!!!

        if (countPerPage == null)
            countPerPage = "5";
/*        if (page == "null")
            page = "1";*/
        if (page == null)
            page = "1";



        try {
            userPaginationVO = userService.paginationUsers(page, Integer.valueOf(countPerPage));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.setAttribute("totaluserscount", userPaginationVO.getTotalUsersCount());
        request.setAttribute("countofpages", (int) Math.ceil(userPaginationVO.getTotalUsersCount() * 1.0 / Integer.valueOf(countPerPage)));
        request.setAttribute("page", userPaginationVO.getPage());
        request.setAttribute("alluserslist", userPaginationVO.getUserEntityList());

        session.setAttribute("page", userPaginationVO.getPage());

        page = ConfigurationManager.getProperty("path.page.allUsersPagination");
        return page;
    }
}

