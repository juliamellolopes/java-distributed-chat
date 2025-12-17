<%-- 
    Document   : index
    Created on : 28 de ago. de 2025, 12:00:47
    Author     : julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bate Papo 1.0</title>
        
        <style>
            body {
                margin: 0;
                padding: 0;
                height: 100vh;
                display: flex;
                align-items: center;
                justify-content: center;
                background: #0a192f; 
                font-family: "Segoe UI", Arial, sans-serif;
            }

            .card {
                background: #ffffff;
                border-radius: 10px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.25);
                width: 480px;
                padding: 24px 28px;
                box-sizing: border-box;
            }

            .title {
                background: linear-gradient(90deg, #1976d2, #00b0ff);
                border-radius: 8px;
                color: #ffffff;
                text-align: center;
                padding: 10px 0;
                font-size: 22px;
                font-weight: 700;
                margin-bottom: 20px;
            }

            .group {
                margin-bottom: 16px;
            }

            .label {
                display: block;
                font-weight: 600;
                font-size: 14px;
                margin-bottom: 4px;
                color: #0a192f;
            }

            .input-text {
                width: 100%;
                padding: 6px 8px;
                border-radius: 5px;
                border: 1px solid #ccd3e0;
                font-size: 14px;
                box-sizing: border-box;
            }

            .colors, .avatars {
                display: flex;
                align-items: center;
                flex-wrap: wrap;
                gap: 10px;
                font-size: 13px;
            }

            .colors label {
                display: flex;
                align-items: center;
                gap: 4px;
                cursor: pointer;
            }

            .avatars label {
                display: flex;
                align-items: center;
                cursor: pointer;
            }

            .avatars img {
                width: 40px;
                height: 40px;
                border-radius: 50%;
                object-fit: cover;
                border: 2px solid transparent;
                margin-left: 4px;
            }

            .btn {
                width: 100%;
                background: #1976d2;
                border: none;
                border-radius: 6px;
                color: #ffffff;
                font-weight: 600;
                font-size: 15px;
                padding: 8px 0;
                cursor: pointer;
                margin-top: 8px;
            }

            .btn:hover {
                background: #145ca3;
            }
        </style>
    </head>
    <body>
        <form name="frmchat" action="sala.jsp" method="post">
            <div class="card">
                <div class="title">Bate Papo</div>

                <!-- Nick -->
                <div class="group">
                    <span class="label">Nick Name:</span>
                    <input type="text" name="txtnick" maxlength="20" class="input-text" required>
                </div>

                <!-- Cor -->
                <div class="group">
                    <span class="label">Cor:</span>
                    <div class="colors">
                        <label>
                            <input type="radio" name="radcor" value="black" checked>
                            <span>Preto</span>
                        </label>

                        <label>
                            <input type="radio" name="radcor" value="blue">
                            <span style="color: blue;">Azul</span>
                        </label>

                        <label>
                            <input type="radio" name="radcor" value="purple">
                            <span style="color: purple;">Roxo</span>
                        </label>
                    </div>
                </div>

                <!-- Avatar -->
                <div class="group">
                    <span class="label">Avatar:</span>
                    <div class="avatars">
                        <label>
                            <input type="radio" name="radavatar" value="Imagens/av01.jpg" checked>
                            <img src="Imagens/av01.jpg" alt="Avatar 1">
                        </label>
                        <label>
                            <input type="radio" name="radavatar" value="Imagens/av02.jpg">
                            <img src="Imagens/av02.jpg" alt="Avatar 2">
                        </label>
                        <label>
                            <input type="radio" name="radavatar" value="Imagens/av03.jpg">
                            <img src="Imagens/av03.jpg" alt="Avatar 3">
                        </label>
                        <label>
                            <input type="radio" name="radavatar" value="Imagens/av04.jpg">
                            <img src="Imagens/av04.jpg" alt="Avatar 4">
                        </label>
                        <label>
                            <input type="radio" name="radavatar" value="Imagens/av05.jpg">
                            <img src="Imagens/av05.jpg" alt="Avatar 5">
                        </label>
                    </div>
                </div>

                <button type="submit" name="entrar" class="btn">Entrar</button>
            </div>
        </form>
    </body>
</html>
