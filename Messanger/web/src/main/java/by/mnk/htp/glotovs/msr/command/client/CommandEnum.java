package by.mnk.htp.glotovs.msr.command.client;

import by.mnk.htp.glotovs.msr.command.*;

/**
 * Created by Sefire on 24.10.2016.
 */
public enum CommandEnum {
    LOGIN(new LoginCommand()),
    REGISTRATIONFORM(new RegistrationFormCommand()),
    PASSREGISTRATION(new PassRegistrationCommand()),
    GETUSERINFO(new GetUserInfoCommand()),
    GETALLUSERS(new GetAllUsersCommand()),
    GETALLUSERSPAGINATION(new GetAllUsersPaginationCommand()),
    MAIN(new MainCommand()),
    GETMYCHATS(new GetMyChats()),
    GETMYFRIENDS(new GetMyFriends()),
    SEARCHUSER(new SearchUserPage()),
    FINDUSERBYPHONE(new FindUserByPhone()),
    ADDTOFRIENDS(new AddFriend()),
    DELETEFROMFRIENDS(new DeleteFriend()),
    CHANGEUSERFIELD(new ChangeUserField()),
    LOGOUT(new LogoutCommand());

    ActionCommand command;

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
