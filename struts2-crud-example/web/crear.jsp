

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Perro</title>
    </head>
    <body>
        <h1>Crear Perro</h1>
        <s:form action="CrearPerro" method="POST">
            <s:textfield name="nombre" label="Nombre"></s:textfield>
            <s:textfield name="duenio" label="Duenio"></s:textfield>
            <s:submit value="Guardar"></s:submit>
        </s:form>
        <a href="index.jsp">Volver</a><br>
    </body>
</html>
