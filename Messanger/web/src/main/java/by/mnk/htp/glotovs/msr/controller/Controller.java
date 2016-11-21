package by.mnk.htp.glotovs.msr.controller;

import by.mnk.htp.glotovs.msr.command.ActionCommand;
import by.mnk.htp.glotovs.msr.command.GetAllUsersPaginationCommand;
import by.mnk.htp.glotovs.msr.command.factory.ActionFactory;
import by.mnk.htp.glotovs.msr.resource.ConfigurationManager;
import by.mnk.htp.glotovs.msr.resource.MessageManager;
import by.mnk.htp.glotovs.msr.util.HibernateSessionFactory;
import org.hibernate.SessionFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by Sefire on 25.10.2016.
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {

    public SessionFactory sessionFactory = null;

    public void init() throws ServletException {
        sessionFactory = HibernateSessionFactory.getSessionFactory();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
   }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        page = command.execute(request);
        pageLogic(page, request, response);
    }

    private void pageLogic(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
