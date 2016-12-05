package by.mnk.htp.glotovs.msr.command;

import by.mnk.htp.glotovs.msr.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sergey Glotov on 04.12.2016.
 */

public class SearchUserPage implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.findUser");
        return page;
    }
}
