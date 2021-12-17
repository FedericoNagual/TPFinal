<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleado</title>
    </head>
    <body>
        <--<!-- Codigo del formulario empleado -->
        <from action="SVEmpleado" method="POST">
        <div class="crear">
            <input type="text" placeholder="usuario" name="usuario"><br>
            <input type="password" placeholder="password" name="password"><br>
            <input type="text" placeholder="cargo" name="cargo"><br>
            <input type="number" placeholder="sueldo" name="sueldo"><br>
            <input type="tel" placeholder="celular" name="celular"><br>
            <input type="email" placeholder="email" name="email"><br>
            <input type="submit" value="Registrarse">
        </div>
    </from>
    </body>
</html>
