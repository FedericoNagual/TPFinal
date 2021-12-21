<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agencia de Turismo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/estilosIndex.css">
    </head>
    <body>
        <div class="body"></div>
        <div class="grad"></div>
        <div class="header">
            <div>Empe<span>ados</span></div>
        </div>
        <br>
        <form action="SvUsuario" method="POST">
        
        <div class="login">
            <input type="text" placeholder="username" name="user"/><br>
            <input type="password" placeholder="password" name="password"/><br>
            <input type="submit" value="Inicio Sesion"/>
            <a href="empleado.jsp"><input type="button" value="Registrarse"/></a>
        </div>
        
    </form>


</body>
</html>

