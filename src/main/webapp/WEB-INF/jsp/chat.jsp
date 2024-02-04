<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="icon" href="data:,">
    <head>
        <title>Чат</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
    </head>
    <body>
        <div align="center">
            <div class="nav">
                <a href="chat?command=logout">Выход</a>
                <c:if test="${\"ADMIN\" == user.userType}">
                    <a href="chat?command=show_users_page">Пользователи</a>
                </c:if>
            </div>

            <div class="chat">
                <c:forEach var="message" items="${messages}">
                    <div class="message">
                        <div class="sender-name">
                        <c:out value="${message.senderName}" />
                        </div>
                        <div class="message-text">
                        <c:out value="${message.text}" />
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div class="input">
            <c:choose>
                <c:when test="${!user.muted}">
                    <form method="POST" action="chat?command=send_message">
                        <input id="text" type="text" name="text" style="width: 50%">
                        <button type="submit" id="send-button" style="display:none"></button>
                    </form>
                    <label for="send-button" style="cursor: pointer">
                        <span class="material-symbols-outlined">send</span>
                    </label>
                </c:when>
                <c:otherwise>
                    <p style="color: darkred">Отправка сообщений была заблокирована для вас</p>
                </c:otherwise>
            </c:choose>
            <a href="chat?command=show_chat_page">
                <span class="material-symbols-outlined">update</span>
            </a>

            </div>
        </div>
    </body>
</html>