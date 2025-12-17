<%-- 
    Document   : sala
    Created on : 4 de set. de 2025, 11:26:01
    Author     : julia
--%>

<%@page import="java.net.SocketAddress"%>
<%@page import="java.net.InetSocketAddress"%>
<%@page import="java.net.NetworkInterface"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.net.DatagramPacket"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.net.MulticastSocket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    if ("publicidade".equals(request.getParameter("acao"))) {

        String anuncio = "";
        MulticastSocket socket = null;

        try {
            int porta = 5000;                                
            InetAddress grupo = InetAddress.getByName("230.0.0.1"); 

            NetworkInterface ni = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            SocketAddress mcastAddr = new InetSocketAddress(grupo, porta);

            socket = new MulticastSocket(porta);
            socket.joinGroup(mcastAddr, ni);
            socket.setSoTimeout(800);

            byte[] buffer = new byte[256];
            DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);

            socket.receive(pacote);

            anuncio = new String(
                pacote.getData(),
                0,
                pacote.getLength(),
                StandardCharsets.UTF_8
            ).trim();

            socket.leaveGroup(mcastAddr, ni);
            socket.close();
        } catch (Exception e) {
            if (socket != null) try { socket.close(); } catch (Exception ex) {}
        }

        out.print(anuncio);  
        return;
    }
%>

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

            .chat-wrapper {
                display: flex;
                padding: 8px;
                box-sizing: border-box;
            }

            .chat-main {
                flex: 1;
                display: flex;
                flex-direction: column;
                background: #ffffff; 
                border-radius: 8px;
                box-shadow: 0 0 6px rgba(0,0,0,0.25);
                overflow: hidden;
                margin-right: 8px;
            }

            .chat-main iframe {
                border: none;
            }

            .sidebar-ad {
                width: 190px;
                background: #f7f7f7;
                border-radius: 8px;
                box-shadow: 0 0 6px rgba(0,0,0,0.25);
                padding: 8px;
                box-sizing: border-box;
                display: flex;
                flex-direction: column;
                align-items: center;
            }

            .sidebar-ad img {
                width: 100%;
                border-radius: 8px;
                border: 1px solid #ccc;
                object-fit: cover;
            }
        </style>
    </head>
    <body>
        <%
            session.setAttribute("nick", request.getParameter("txtnick"));
            session.setAttribute("cor", request.getParameter("radcor"));
            session.setAttribute("avatar", request.getParameter("radavatar"));
        %>
        
        <div class="chat-wrapper">
            <div class="chat-main">
                <iframe src="topo.jsp"      width="100%" height="100"></iframe>       
                <iframe src="mensagens.jsp" width="100%" height="550"></iframe>
                <iframe src="conversa.jsp"  width="100%" height="50"></iframe>
            </div>

            <div class="sidebar-ad">
                <img id="bannerPub"
                     src="Imagens/coca.jpg"  
            </div>
        </div>
            
        <script>
            async function trocarPublicidade() {
                const img = document.getElementById('bannerPub');
                if (!img) return;

                try {
                    const resp = await fetch('sala.jsp?acao=publicidade', { cache: 'no-store' });
                    let nome = (await resp.text()).trim();   

                    if (nome) {
                        img.src = 'Imagens/' + nome;
                    }
                } catch (e) {
                    console.error('Erro ao buscar publicidade', e);
                }
            }

            setInterval(trocarPublicidade, 700);
            trocarPublicidade();
        </script>
    </body>
</html>
