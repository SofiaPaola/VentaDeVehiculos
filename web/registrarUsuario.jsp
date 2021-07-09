<%-- 
    Document   : registrarUsuario
    Created on : 07-may-2021, 09:13:10
    Author     : Sofia Paola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar usuario</title>
    </head>
    <body>
        <center>
            <h1>Registrar usuario</h1>
            <form method="post" action="Usuario">
                <table>
                    <tr>
                        Usuario:<br>
                    <input type="text" name="textUsuario"><br>
                    Contraseña:<br>
                    <input type="password" name="textClave">
                    </tr>
                </table>
                <br>
                <button>Registrar</button>
                <input type="hidden" value="1" name="opcion">            
            </form>
            <br>
            <a href="index.jsp">
                <button>Volver</button>
            </a>
            <div>
                <% if (request.getAttribute("mensajeError") != null) {%>
                <div Style="color: red; ">${mensajeError} </div>
                <%} else { %>
                <div style="color: darkgreen">${mensajEXito} </div>
                <% }%>            
            </div>
        </center>
    </body>
</html>
