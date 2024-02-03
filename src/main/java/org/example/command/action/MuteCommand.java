package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;

public class MuteCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {

        String login = request.getParameter("login");
        boolean mute = Boolean.parseBoolean(request.getParameter("mute"));
        HashMap<String, User> users = DataBase.getUsers();
        if(users.containsKey(login)) {
            User user = users.get(login);
            user.setMuted(mute);
        }
        return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
