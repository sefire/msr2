package by.mnk.htp.glotovs.msr.controller;

import by.mnk.htp.glotovs.msr.entities.UserEntity;
import by.mnk.htp.glotovs.msr.services.exception.ServiceException;
import by.mnk.htp.glotovs.msr.services.interfaces.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Sergey Glotov on 10.12.2016.
 */
@Controller
public class RegistrationController {


    private static Logger log = Logger.getLogger(RegistrationController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/registrationform"}, method = RequestMethod.GET)
    public ModelAndView main() {
        return new ModelAndView("registrationform", "user", new UserEntity());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(value = {"/passRegistration"} , method = { RequestMethod.POST} )
    public ModelAndView passRegistration(@ModelAttribute("user") UserEntity user) {

       try {
            userService.saveOrUpdate(user);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return new ModelAndView("login", "currentUser", user);
    }
}
