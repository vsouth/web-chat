package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.Resources.COMMAND_SHOW_LOGIN_PAGE;

public class LoginCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {

        String login = request.getParameter("loginInput");
        String password = request.getParameter("passwordInput");
        HashMap<String, User> users = DataBase.getUsers();
        if (!users.containsKey(login) || !password.equals(users.get(login).getPassword())) {
            return new RedirectResult(COMMAND_SHOW_LOGIN_PAGE);
        }

        User user = users.get(login);
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        user.setOnline(true);


        return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
