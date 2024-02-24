<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD de Perros</title>
    </head>
    <body>
        <h1>CRUD de Perros</h1>
        <a href="crear.jsp">Crear</a><br>
        <s:url action="ListarPerros" var="linkListar">
        </s:url>
        <s:a href="%{linkListar}">Listar</s:a><br>
    </body>
</html>
