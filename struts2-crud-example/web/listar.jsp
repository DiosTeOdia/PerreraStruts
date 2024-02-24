<%-- 
    Document   : listar
    Author     : 1
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD de Perros</title>
    </head>
    <body>
        <h1>Lista de Perros</h1>
        <table cellspacing="10">
            <tr>
                <th>
                    ID
                </th>
                <th>
                    Nombre
                </th>
                <th>
                    Dueño
                </th>
            </tr>
        <s:iterator value="getPerros()" var="c">
            <tr>
                <td>
                    <s:property value="#c.getId()"></s:property>
                </td>
                <td>
                    <s:property value="#c.getNombre()"></s:property>
                </td>
                <td>
                    <s:property value="#c.getDuenio()"></s:property>
                </td>
                <td>
                    <s:url action="ObterPerro" var="linkAtualizar">
                        <s:param name="perroId"><s:property value="#c.getId()"></s:property></s:param>
                    </s:url>
                    <s:a href="%{linkAtualizar}">Actualizar</s:a><br>
                </td>
                <td>
                    <s:url action="BorrarPerro" var="linkBorrar">
                        <s:param name="perroId"><s:property value="#c.getId()"></s:property></s:param>
                    </s:url>
                    <s:a href="%{linkBorrar}">Borrar</s:a><br>
                </td>
            </tr>
        </s:iterator>
        </table>
        <a href="index.jsp">Volver</a><br>
    </body>
</html>
