<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleado</title>
    </head>
    <body>
        <!-- Codigo del formulario empleado -->
        <h3>Crear un Empleado/Usuario</h3>
    <form action="SvEmpleado" method="POST">
        <p><label>Nombre :</label><input type="text" name="nombre"></p><br>
        <p><label>Apellido :</label><input type="text" name="apellido"></p><br>
        <p><label>Dni :</label><input type="text" name="dni"></p><br>
        <p><label>Direccion :</label><input type="text" name="direccion"></p><br>
        <p><label>Nacionalidad :</label><input type="text" name="nacionalidad"></p><br>
        <p><label>Celular :</label><input type="text" name="celular"></p><br>
        <p><label>Email :</label><input type="text" name="email"></p><br>
        <p><label>FechaNacimiento :</label><input type="date" name="fechaNacimiento"></p><br>
        <p><label>Cargo :</label><input type="text" name="cargo"></p><br>
        <p><label>Sueldo :</label><input type="text" name="sueldo"></p><br>
        <h4>Datos Usuario</h4>
        <p><label>Nombre :</label><input type="text" name="nombreUsu"></p><br>
        <p><label>Contraseña :</label><input type="password" name="contrasenia"></p><br>
        
        <input type="submit" value="Enviar">
        
        <a href="index.jsp"><input type="button" value="Cancelar"></a>

    </form>
</body>
</html>
