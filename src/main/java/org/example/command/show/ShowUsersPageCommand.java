package org.example.command.show;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

import static org.example.Resources.USERS_PAGE;

public class ShowUsersPageCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        HashMap<String, User> users = DataBase.getUsers();
        session.setAttribute("users", users.values());
        return new ForwardResult(USERS_PAGE);
    }
}
