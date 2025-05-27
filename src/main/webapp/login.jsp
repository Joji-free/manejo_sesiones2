<%--
  Created by IntelliJ IDEA.
  User: ander
  Date: 19/5/2025
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
        }

        h1 {
            color: #333;
            margin-bottom: 2rem;
        }

        .form {
            --bg-light: #efefef;
            --bg-dark: #707070;
            --clr: #58bc82;
            --clr-alpha: #9c9c9c60;
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 1rem;
            width: 100%;
            max-width: 300px;
            background-color: white;
            padding: 2rem;
            border-radius: 1rem;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        .form .input-span {
            width: 100%;
            display: flex;
            flex-direction: column;
            gap: 0.5rem;
        }

        .form input[type="text"],
        .form input[type="password"] {
            border-radius: 0.5rem;
            padding: 1rem 0.75rem;
            width: 100%;
            border: none;
            display: flex;
            align-items: center;
            gap: 0.5rem;
            background-color: var(--clr-alpha);
            outline: 2px solid var(--bg-dark);
            box-sizing: border-box;
        }

        .form input[type="text"]:focus,
        .form input[type="password"]:focus {
            outline: 2px solid var(--clr);
        }

        .label {
            align-self: flex-start;
            color: var(--clr);
            font-weight: 600;
            margin-bottom: 0.5rem;
        }

        .form .submit {
            padding: 1rem 0.75rem;
            width: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 0.5rem;
            border-radius: 3rem;
            background-color: var(--bg-dark);
            color: var(--bg-light);
            border: none;
            cursor: pointer;
            transition: all 300ms;
            font-weight: 600;
            font-size: 0.9rem;
            margin-top: 1rem;
        }

        .form .submit:hover {
            background-color: var(--clr);
            color: var(--bg-dark);
        }
    </style>
</head>
<body>
<h1>Login de usuario</h1>

<form class="form" action="/manejo_sesiones/login" method="post">
    <div class="input-span">
        <label class="label" for="username">Nombre de usuario:</label>
        <div>
            <input type="text" name="username" id="username" required>
        </div>
    </div>

    <div class="input-span">
        <label class="label" for="pass">Password:</label>
        <div>
            <input type="password" name="password" id="pass" required>
        </div>
    </div>

    <div>
        <input class="submit" type="submit" value="Enviar">
    </div>

</form>
</body>
</html>