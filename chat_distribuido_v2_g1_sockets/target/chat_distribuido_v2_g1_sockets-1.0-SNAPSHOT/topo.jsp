<%-- 
    Document   : topo
    Created on : 4 de set. de 2025, 11:26:10
    Author     : julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            body {
                margin: 0;
                padding: 0;
                background: #0a192f;
                font-family: "Segoe UI", Arial, sans-serif;
                color: #ffffff;
            }

            .topbar {
                display: flex;
                align-items: center;
                padding: 8px 16px;
                box-sizing: border-box;
            }

            .avatar {
                width: 52px;
                height: 52px;
                border-radius: 50%;
                object-fit: cover;
                border: 2px solid #2196f3;
                margin-right: 12px;
            }

            .info {
                display: flex;
                flex-direction: column;
                justify-content: center;
            }

            .nick {
                font-size: 20px;
                font-weight: 600;
                line-height: 1.2;
            }

            .status {
                font-size: 12px;
                color: #90caf9;
                margin-top: 2px;
            }
        </style>
    </head>
    <body>
        <%
            String nick = (String) session.getAttribute("nick");
            String cor = (String) session.getAttribute("cor");
            String avatar = (String) session.getAttribute("avatar");

            if (nick == null || nick.trim().isEmpty()) {
                nick = "Convidado";
            }
            if (cor == null || cor.trim().isEmpty()) {
                cor = "#ffffff";
            }
            boolean temAvatar = (avatar != null && !avatar.trim().isEmpty());
        %>
        <div class="topbar">
            <% if (temAvatar) {%>
            <img class="avatar" src="<%= avatar%>" alt="Avatar">
            <% }%>

            <div class="info">
                <div class="nick" style="color:<%= cor%>;">
                    <%= nick%>
                </div>
                <div class="status">
                    Online
                </div>
            </div>
        </div>
    </body>
</html>
