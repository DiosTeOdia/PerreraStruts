

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Perro</title>
    </head>
    <body>
        <h1>Atualizar Perro</h1>
        <s:form action="AtualizarPerro" method="POST">
            <s:hidden name="id" value="%{perro.getId()}"></s:hidden>
            <s:textfield name="nome" value="%{perro.getNombre()}" label="Nombre"></s:textfield>
            <s:textfield name="email" value="%{perro.getDuenio()}" label="Duenio"></s:textfield>
            <s:submit value="Actualizar"></s:submit>
        </s:form>
        <a href="index.jsp">Volver</a><br>
    </body>
</html>
