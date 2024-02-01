package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Enumeration;
import java.util.HashMap;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.Resources.COMMAND_SHOW_LOGIN_PAGE;

public class LoginCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {

        String login = request.getParameter("loginInput");
        String password = request.getParameter("passwordInput");
        HashMap<String, User> users = DataBase.getUsers();
        if (!users.containsKey(login)) {
            return new RedirectResult(COMMAND_SHOW_LOGIN_PAGE);
        }

        User user = users.get(login);
        if (!password.equals(user.getPassword())) {
            return new RedirectResult(COMMAND_SHOW_LOGIN_PAGE);
        }

        if (!user.isOnline()) {
            user.setOnline(true);

        }
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);

        session.setAttribute("login", user.getLogin());
        session.setAttribute("name", user.getName());
        session.setAttribute("muted", user.isMuted());
        session.setAttribute("user_type", user.getUserType());

        Enumeration<String> attributes = request.getSession().getAttributeNames();
        while (attributes.hasMoreElements()) {
            String attribute = (String) attributes.nextElement();
            System.out.println(attribute+" : "+request.getSession().getAttribute(attribute));
        }

        return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
