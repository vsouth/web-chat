package org.example.command;

import org.example.command.action.LoginCommand;
import org.example.command.action.LogoutCommand;
import org.example.command.action.MuteCommand;
import org.example.command.action.SendMessageCommand;
import org.example.command.show.ShowChatPageCommand;
import org.example.command.show.ShowLoginPageCommand;
import org.example.command.show.ShowUsersPageCommand;

public enum CommandType {
    EMPTY(new EmptyCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),

    SHOW_CHAT_PAGE(new ShowChatPageCommand()),
    SHOW_LOGIN_PAGE(new ShowLoginPageCommand()),
    SHOW_USERS_PAGE(new ShowUsersPageCommand()),
    SEND_MESSAGE(new SendMessageCommand()),
    MUTE_USER(new MuteCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
