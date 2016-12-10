/*
 * Copyright (C) 2014 GHX, Inc.
 *  Louisville, Colorado, USA.
 *  All rights reserved.
 *
 *  Warning: Unauthorized reproduction or distribution of this program, or
 *  any portion of it, may result in severe civil and criminal penalties,
 *  and will be prosecuted to the maximum extent possible under the law.
 *
 *  Created on 023 23.05.2014
 */
package by.mnk.htp.glotovs.msr.controller;

import by.mnk.htp.glotovs.msr.entities.UserEntity;
import by.mnk.htp.glotovs.msr.services.exception.ServiceException;
import by.mnk.htp.glotovs.msr.services.impl.UserService;
import by.mnk.htp.glotovs.msr.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller

public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET )
    public String zeroPage() {
        return "login";
    }

    @RequestMapping(value = {"/login"}, method = { RequestMethod.GET} )
    public ModelAndView loginPage(@RequestParam(value = "param.error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView();
        if(error!=null)
            error = "Incorrect phoneNumber or password!";
        modelAndView.setViewName("login");
        return modelAndView;
    }

    //--------------------------------------------------------------

    @RequestMapping(value = { "/home" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Hello and welcome");
        return "welcome";
    }
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model, Authentication principal) {
        System.out.println(principal.getPrincipal());
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "access-denied";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
    private String getPrincipal(){
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    //@ModelAttribute("station") Station station,
/*    @RequestMapping(value = "/", method = RequestMethod.GET )
    public String loginPage(@ModelAttribute("phoneNumber") String phoneFromForm, @ModelAttribute("password") String passwordFromForm, ModelAndView modelAndView) {

        String page = null;
        String phone = phoneFromForm;
        String pass =  passwordFromForm;
        Integer idCurrentUser = 0;

        UserService userService = (UserService) ServiceFactory.getInstance().getService(ServiceName.USER);

        String userFullName = null;

        try {
            userFullName = userService.checkLoginGetFullName(phone, pass);
            idCurrentUser = userService.getUserEntityByPhone(phone).getId();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        if (userFullName != null) {
*//*            modelAndView.put("user", userFullName);
            modelAndView.put("phoneNumberSession", phone);
            modelAndView.put("user", userFullName);
            modelAndView.put("idCurrentUser", idCurrentUser );*//*
            page = "main";
        } else {
*//*            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");*//*
        }
        return page;
    }*/
/*
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    @RequestWrapper
    public String registration(ModelAndView model, @RequestParam(value = "login-fail") String error ) {
        if ("error".equals(error)) {
            model.addObject("error", "Authentication error");
        }
        return "welcome";
    }

    @RequestMapping(value = "/login-fail", method = RequestMethod.GET)
    @RequestWrapper
    public String loginFail(ModelAndView model, @RequestParam(value = "login-fail") String error ) {
        if ("error".equals(error)) {
            model.addObject("error", "Authentication error");
        }

        return "welcome";
    }*/
}



