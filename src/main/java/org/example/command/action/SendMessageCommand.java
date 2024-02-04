package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.Message;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;

public class SendMessageCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        String text = request.getParameter("text");
        User user = (User) request.getSession().getAttribute("user");
        String login = user.getLogin();
        String name = user.getName();
        System.out.println(login + "   " + text);
        if (!user.isMuted()) {
            DataBase.addMessage(new Message(login, name, text));
        }
        return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
