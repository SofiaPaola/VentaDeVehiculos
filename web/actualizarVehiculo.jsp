<%-- 
    Document   : actualizarVehiculo
    Created on : 14-may-2021, 08:57:37
    Author     : Sofia Paola
--%>

<%@page import="ModeloVO.CategoriaVO"%>
<%@page import="ModeloDAO.CategoriaDAO"%>
<%@page import="ModeloVO.VehiculoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar vehiculos</title>
    </head>
    <body>
    <center>
        <h1>Actualizar vehiculos</h1>
        <%
            VehiculoVO vehVO = (VehiculoVO) request.getAttribute("vehiculoConsultado");
            if (vehVO != null) {
                
        %>
        <form method="POST" action="Vehiculo">
            <table>
                <tr>
                    <th>
                        PLACA 
                        <input type="text" name="textPlaca" value="<%= vehVO.getVehPlaca()%>"> <br> <br>
                        DATOS 
                        <input type="text" name="textDatos" value="<%= vehVO.getDatId()%>"> <br> <br>
                        CATEGORIA
                        <select name="textCategoria" >
                            <option value="0">selecione .... </option>
                            <%
                                CategoriaDAO catDAO = new CategoriaDAO();
                                for (CategoriaVO catVO : catDAO.Listar()) {
                            %>
                            <option value="<%=catVO.getCatId()%>"><%= catVO.getCatTipo()%> </option>
                            <% }%>
                        </select><br><br>
                        MODELO 
                        <input type="text" name="textModelo" value="<%= vehVO.getVehModelo()%>"> <br> <br>
                        MARCA
                        <input type="text" name="textMarca" value="<%= vehVO.getVehMarca()%>"> <br> <br>
                        ESTADO 
                        <input type="text" name="textEstado" value="<%= vehVO.getVehEstado()%>"> <br> <br>
                        PRECIO
                        <input type="text" name="textPrecio" value="<%= vehVO.getVehPrecio()%>"> <br> <br>
                    </th>
                </tr>
            </table>
            <button>Actualizar</button>
            <input type="hidden" value="2" name="opcion" />
        </form>
        <%} %>
        <br>
        <a href="consultarVehiculo.jsp">
            <button>Volver</button>
        </a>
        <div Style="color: red; ">
            <% if (request.getAttribute("mensajeError") != null) {%>
            ${mensajeError}
            <%} else { %>
            <div style="color: darkgreen">${mensajEXito} </div>
            <% }%>            
        </div>
    </center>        
</body>
</html>
