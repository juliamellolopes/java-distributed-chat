<%-- 
    Document   : mensagens
    Created on : 4 de set. de 2025, 11:26:19
    Author     : julia
--%>

<%@page import="java.net.Socket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>

<%
    if (request.getParameter("check") != null) {
        try {
            Socket s = new Socket("127.0.0.1", 3323);
            DataOutputStream o = new DataOutputStream(s.getOutputStream());
            DataInputStream i = new DataInputStream(s.getInputStream());
            o.writeUTF("update?");
            out.print(i.readLong());
            i.close();
            o.close();
            s.close();
        } catch (Exception e) {
            out.print("0");
        }
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
                padding: 8px;
                background: #ffffff;
                font-family: "Segoe UI", Arial, sans-serif;
                font-size: 13px;
            }

            .msg {
                display: flex;
                align-items: flex-start;
                margin-bottom: 6px;
            }

            .avatar {
                width: 40px;
                height: 40px;
                border-radius: 50%;
                object-fit: cover;
                margin-right: 6px;
                border: 1px solid #ddd;
            }

            .bubble {
                background: #f3f6fb;
                border-radius: 8px;
                padding: 4px 10px;
                max-width: 70%;
                word-wrap: break-word;
                line-height: 1.3;
                font-size: 14px;
            }
            
            .bubble b, 
            .bubble font {
                font-size: 14px !important;
                font-weight: 600;
            }

            .msg-text {
                background: #f3f6fb;
                border-radius: 6px;
                padding: 4px 8px;
                max-width: 100%;
                word-wrap: break-word;
                line-height: 1.3;
            }
        </style>
    </head>
    <body>
        <%
            Socket client = new Socket("127.0.0.1", 3323);
            DataOutputStream outS = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());

            outS.writeUTF("get");

            String conteudo = in.readUTF();
            conteudo = conteudo.replace(":)", " &#128512; ");
            conteudo = conteudo.replace("s2", "&#128151;");
            conteudo = conteudo.replace(":-)", "&#128514;");
            
            StringBuilder saida = new StringBuilder();
            String[] linhas = conteudo.split("(?i)<br\\s*/?>");

            for (String linha : linhas) {
                if (linha == null) {
                    continue;
                }
                String linhaTrim = linha.trim();
                if (linhaTrim.isEmpty()) {
                    continue;
                }

                String avatar = "Imagens/ghost.jpg";
                String msgHtml = linhaTrim;

                if (linhaTrim.startsWith("<img")) {
                    int idxSrc = linhaTrim.indexOf("src=");
                    if (idxSrc >= 0) {
                        char asp = linhaTrim.charAt(idxSrc + 4); 
                        int ini = idxSrc + 5;
                        int fim = linhaTrim.indexOf(asp, ini);
                        if (fim > ini) {
                            avatar = linhaTrim.substring(ini, fim).trim();
                        }
                    }

                    int fimImg = linhaTrim.indexOf(">");
                    if (fimImg >= 0 && fimImg + 1 < linhaTrim.length()) {
                        msgHtml = linhaTrim.substring(fimImg + 1).trim();
                    }
                }
                msgHtml = msgHtml.replace("Diz:", " Diz:");
                msgHtml = msgHtml.replaceAll("(?i)size='?\\d+'?", "size='3'");
                saida.append("<div class='msg'>");
                saida.append("<img class='avatar' src='").append(avatar).append("' alt='avatar'>");
                saida.append("<div class='bubble'>");
                saida.append(msgHtml);
                saida.append("</div>");
                saida.append("</div>");
            }
            out.print(saida.toString());

            in.close();
            outS.close();
            client.close();
        %>
        <script>
            (async () => {
                try {
                    const r = await fetch('mensagens.jsp?check=1', {cache: 'no-store'});
                    window.__ts = parseInt(await r.text(), 10) || 0;
                } catch (_) {
                    window.__ts = 0;
                }
            })();

            setInterval(async () => {
                const r = await fetch('mensagens.jsp?check=1', {cache: 'no-store'});
                const novo = parseInt(await r.text(), 10) || 0;
                if (novo > (window.__ts || 0))
                    location.reload();
            }, 2000);
        </script>
    </body>
</html>
