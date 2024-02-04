package org.example.filter;

import org.example.data.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.Resources.COMMAND_SHOW_LOGIN_PAGE;
import static org.example.data.UserType.ADMIN;

public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        String command = httpRequest.getParameter("command");
        boolean isCommandUsers = "show_users_page".equals(command) || "users".equals(command);
        boolean isCommandLogin = "show_login_page".equals(command) || "login".equals(command);

        if (!isCommandLogin && (session == null || session.getAttribute("user") == null)) {
            httpResponse.sendRedirect(COMMAND_SHOW_LOGIN_PAGE);
            return;
        }
        User user = (User) session.getAttribute("user");
        if (isCommandUsers && user.getUserType() != ADMIN) {
            httpResponse.sendRedirect(COMMAND_SHOW_CHAT_PAGE);
            return;
        }

        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {
    }
}
