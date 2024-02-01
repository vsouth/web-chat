package org.example.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.example.Resources.COMMAND_SHOW_LOGIN_PAGE;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        String command = httpRequest.getParameter("command");
        boolean isCommandLogin = "show_login_page".equals(command) || "login".equals(command);


        if (!isCommandLogin && (session == null || session.getAttribute("user") == null)) {
            System.out.println("redirect");
            httpResponse.sendRedirect(COMMAND_SHOW_LOGIN_PAGE);
            return;
        }
        System.out.println("filtered");
        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {
    }
}
