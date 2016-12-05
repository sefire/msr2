package by.mnk.htp.glotovs.msr.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sergey Glotov on 04.12.2016.
 */

public class ChangeUserField implements ActionCommand {
    public String execute(HttpServletRequest request) {

        String fieldToChange  = request.getParameter("fieldToChange");
        return null;
    }
}
