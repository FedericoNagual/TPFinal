<%-- 
    Document   : clienteM
    Created on : 20-dic-2021, 21:16:14
    Author     : Federico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Apartado Cliente Modifica</h1>
        
        
        <form action="SvClienteModifica" method="POST">
        
        
        <p><label>Id :</label><input type="text" name="id"></p><br>
        <p><label>Nombre :</label><input type="text" name="nombre"></p><br>
        <p><label>Apellido :</label><input type="text" name="apellido"></p><br>
        <p><label>Dni :</label><input type="text" name="dni"></p><br>
        <p><label>Direccion :</label><input type="text" name="direccion"></p><br>
        <p><label>Nacionalidad :</label><input type="text" name="nacionalidad"></p><br>
        <p><label>Celular :</label><input type="text" name="celular"></p><br>
        <p><label>Email :</label><input type="text" name="email"></p><br>
        <p><label>FechaNacimiento :</label><input type="date" name="fechaNacimiento"></p><br>
        
        <input type="button" value="Editar"/><br>
        
        <a href="home.jsp"><input type="button" value="Volver Home"></a>

    </form>
    </body>
</html>
