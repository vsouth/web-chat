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
import static org.example.Resources.COMMAND_SHOW_USERS_PAGE;
import static org.example.data.UserType.ADMIN;

public class MuteCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        boolean mute = Boolean.parseBoolean(request.getParameter("mute"));
        User admin = (User) request.getSession().getAttribute("user");
        System.out.println(admin + " " + login + " " + mute);
        if (admin.getUserType() != ADMIN) {
            return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
        }
        HashMap<String, User> users = DataBase.getUsers();
        if(users.containsKey(login)) {
            User user = users.get(login);
            user.setMuted(mute);
        }
        return new RedirectResult(COMMAND_SHOW_USERS_PAGE);
    }
}
