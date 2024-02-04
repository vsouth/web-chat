<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Пользователи</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
        <style>
            form {
                display:none;
            }

            .mute {
                color: lightgray;
            }

            .mute:hover {
                color: orange;
            }

            .mute.checked {
                color: red;
            }

            .mute.checked:hover {
                color: limegreen;
            }

            .dot {
                height: 20px;
                width: 20px;
                border-radius: 50%;
                display: inline-block;
            }

            .online {
                background-color: limegreen;
            }

            .offline {
                background-color: lightgray;
            }

        </style>
    </head>

    <body>
        <div align="center">
            <div class="nav">
                <a href="chat?command=logout">Выход</a>
                <a href="chat?command=show_chat_page">Чат</a>
            </div>
            <table>
                <tr>
                    <th>Mute</th>
                    <th>Статус</th>
                    <th>Логин</th>
                    <th>Имя</th>
                    <th>Тип</th>

                </tr>
                <c:forEach var="user" items="${users}" varStatus="id">
                    <tr>
                        <td>
                        <c:choose>
                            <c:when test="${user.muted}">
                                <form method="POST" action="chat?command=mute_user">
                                    <input type="hidden" name="login" value="${user.login}">
                                    <input type="hidden" name="mute" value="false">
                                    <button type="submit" id="mute-button-${id.index}"></button>
                                </form>
                                <label style="text-decoration: underline" for="mute-button-${id.index}">
                                <span class="material-symbols-outlined mute checked">speaker_notes_off</span>
                                </label>
                            </c:when>
                            <c:otherwise>
                                <form method="POST" action="chat?command=mute_user">
                                    <input type="hidden" name="login" value="${user.login}">
                                    <input type="hidden" name="mute" value="true">
                                    <button type="submit" id="mute-button-${id.index}"></button>
                                </form>
                                <label style="text-decoration: underline" for="mute-button-${id.index}">
                                <span class="material-symbols-outlined mute">speaker_notes_off</span>
                                </label>
                            </c:otherwise>
                        </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${user.online}">
                                    <span class="dot online"></span>
                                </c:when>
                                <c:otherwise>
                                    <span class="dot offline"></span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${user.login}</td>
                        <td>${user.name}</td>
                        <td>${user.userType}</td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </body>
</html>