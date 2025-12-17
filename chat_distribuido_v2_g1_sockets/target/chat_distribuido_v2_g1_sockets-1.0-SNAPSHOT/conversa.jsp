<%-- 
    Document   : conversa
    Created on : 4 de set. de 2025, 11:26:29
    Author     : julia
--%>

<%@page import="java.net.Socket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
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
            }

            .bar {
                display: flex;
                align-items: center;
                padding: 6px 8px;
                box-sizing: border-box;
                color: #ffffff;
            }

            .label {
                margin-right: 6px;
                font-weight: 600;
                font-size: 13px;
            }

            .txtmsg {
                flex: 1;
                padding: 4px 6px;
                border-radius: 4px;
                border: 1px solid #ccc;
                font-size: 13px;
                margin-right: 6px;
            }

            .select-emoji {
                margin-left: 4px;
                margin-right: 6px;
                padding: 3px 4px;
                border-radius: 4px;
                border: 1px solid #ccc;
                font-size: 12px;
            }

            .btn-enviar {
                background: #1976d2;
                border: none;
                border-radius: 4px;
                color: #ffffff;
                font-weight: 600;
                font-size: 13px;
                padding: 5px 14px;
                cursor: pointer;
            }

            .btn-enviar:hover {
                background: #145ca3;
            }
        </style>
    </head>
    <body>
        <form name="frmmsg" method="get" class="bar">
            <span class="label">Mensagem:</span>
            <input type="text" name="txtmsg" maxlength="200" class="txtmsg">

            <span class="label">Emoji:</span>
            <select name="slemoji" class="select-emoji">
                <option value="">Selecione</option>
                <option value="Imagens/coracao.jpeg">Coração</option>
                <option value="Imagens/beleza.jpeg">Beleza</option>
                <option value="Imagens/nhe.jpeg">Nhe</option>
                <option value="Imagens/aff.jpeg">Aff</option>
                <option value="Imagens/rindo.jpg">Rindo</option>
            </select>

            <input type="submit" name="cmdenviar" value="Enviar" class="btn-enviar">
        </form>
        
        <%
           if((request.getParameter("cmdenviar")!= null) && (request.getParameter("txtmsg")!= null)){
               String msg = "";
               msg += "<img src='"+ session.getAttribute("avatar")+"'width='50' heigth='50'";
               msg += "<b><font size='4' color='"+ session.getAttribute("cor")+"'>"+ session.getAttribute("nick")+"</font></b> Diz: " + request.getParameter("txtmsg");
               if(!request.getParameter("slemoji").toString().equals("")){
                   msg += "<img src='"+request.getParameter("slemoji")+"'width='50' heigth='50'>";
               }
            msg +="<br>";
            
            Socket client  = new Socket("127.0.0.1", 3322);
            DataOutputStream writer = new DataOutputStream(client.getOutputStream());
            writer.writeUTF(msg);
            writer.flush();
            writer.close();
            client.close();
           }
        %>
    </body>
</html>
