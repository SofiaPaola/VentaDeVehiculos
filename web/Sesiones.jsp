<%-- 
    Document   : Sesiones
    Created on : 02-jun-2021, 14:24:33
    Author     : Sofia Paola
--%>

<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-control", "no-cache,no-store,must-revalidate");
    response.setDateHeader("Expires", 0);
%>

<%
    HttpSession buscarSesion = (HttpSession) request.getSession();
    String usuario = "";
    if (buscarSesion.getAttribute("datos") == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } else {
        UsuarioVO usuVO = (UsuarioVO) buscarSesion.getAttribute("datos");
        usuario = usuVO.getUsuLogin();
    }

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sesiones</title>
    </head>
    <body>
        <div>
            <h1>Bienvenido: <%=usuario%></h1>
            <form method="post" action=""></form>
            <a href="index.jsp">
                <button>Cerrar Sesion</button>
            </a>
        </div>


    </body>
</html>