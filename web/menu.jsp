<%-- 
    Document   : menu
    Created on : 07-may-2021, 09:40:29
    Author     : Sofia Paola
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
    <center>
        <form>
            Roles:
            <select name="textCatId">
                <option>Seleccione...</option>
                <% UsuarioDAO usuDAO = new UsuarioDAO();
                    UsuarioVO usuVO = new UsuarioVO();
                    ArrayList<UsuarioVO> listaRol = (ArrayList<UsuarioVO>) buscarSesion.getAttribute("rol");
                    for (int i = 0; i < listaRol.size(); i++) {
                        usuVO = listaRol.get(i);
                %>
                <option value="<%=usuVO.getRol()%>"><%=usuVO.getRol()%></option>
                <%}%>
            </select>
        </form>
        <h1>Menu</h1>
    </center>        
</body>
</html>
