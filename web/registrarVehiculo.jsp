<%-- 
    Document   : registrarVehiculo
    Created on : 14-may-2021, 08:26:19
    Author     : Sofia Paola
--%>

<%@page import="ModeloVO.CategoriaVO"%>
<%@page import="ModeloDAO.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar vehiculo</title>
    </head>
    <body>
    <center>
        <h1>Registrar vehiculo</h1>
        <form method="post" action="Vehiculo">
            <table>
                <tr>
                    <th>
                        PLACA<br>
                        <input type="text" name="textPlaca"><br>
                        DATOS<br>
                        <input type="text" name="textDatos"><br>
                        CATEGORIA<br>
                        <select name="textCategoria" >
                            <option value="0">selecione .... </option>
                            <%
                                CategoriaDAO catDAO = new CategoriaDAO();
                                for (CategoriaVO catVO : catDAO.Listar()) {
                            %>
                            <option value="<%=catVO.getCatId()%>"><%= catVO.getCatTipo()%> </option>
                            <% }%>
                        </select><br>
                        MODELO<br>
                        <input type="text" name="textModelo"><br>
                        MARCA<br>
                        <input type="text" name="textMarca"><br>
                        ESTADO<br>
                        <input type="text" name="textEstado"><br>
                        PRECIO<br>
                        <input type="text" name="textPrecio"><br>
                    </th>
                </tr>
            </table>
            <br>
            <button>Registrar</button>
            <input type="hidden" value="1" name="opcion">            
        </form>
        <div>
            <% if (request.getAttribute("mensajeError") != null) {%>
            <div Style="color: red; ">${mensajeError} </div>
            <%} else { %>
            <div style="color: darkgreen">${mensajExito} </div>
            <% }%>            
        </div>
    </center>
</body>
</html>
