package org.example.command.show;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.Message;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static org.example.Resources.PAGE_CHAT;

public class ShowChatPageCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        List<Message> messages = DataBase.getMessages();
        HttpSession session = request.getSession();
        session.setAttribute("messages", messages);
        return new ForwardResult(PAGE_CHAT);
    }
}
