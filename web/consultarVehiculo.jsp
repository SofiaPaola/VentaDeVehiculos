<%-- 
    Document   : consultarVehiculo
    Created on : 14-may-2021, 08:45:44
    Author     : Sofia Paola
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.VehiculoDAO"%>
<%@page import="ModeloVO.VehiculoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar vehiculos</title>
    </head>
    <body>
    <center>
        <h1>Consultar vehiculos</h1>
        <form method="POST" action="Vehiculo">
            <table>              
                <tr>
                    <th>
                        PLACA 
                        <input type="text" name="textPlaca"> 
                    </th>
                </tr>             
            </table>
            <button>Consultar</button>
            <input type="hidden" value="3" name="opcion">
        </form>
        <br>
        <div Style="color: red;">
            <% if (request.getAttribute("mensajeError") != null) {%>
            <div>${mensajeError}</div>
            <%} else { %>
            <div style="color: darkgreen">${mensajExito} </div>
            <% }%>
        </div>
        <br>
        <form>
            <table border="1">
                <tr>
                    <th>PLACA</th>
                    <th>DATOS</th>
                    <th>CATEGORIA</th>
                    <th>MODELO</th>
                    <th>MARCA</th>
                    <th>ESTADO</th>
                    <th>PRECIO</th>
                </tr>
                <%
                    VehiculoVO vehVO = new VehiculoVO();
                    VehiculoDAO vehDao = new VehiculoDAO();
                    ArrayList<VehiculoVO>listaVehiculos = vehDao.Listar();                    
                    for (int i = 0; i < listaVehiculos.size(); i++) {                            
                        vehVO = listaVehiculos.get(i);
                %>
                <tr>
                    <td><%=vehVO.getVehPlaca()%></td>
                    <td><%=vehVO.getDatId()%></td>
                    <td><%=vehVO.getCatId()%></td>
                    <td><%=vehVO.getVehModelo()%></td>
                    <td><%=vehVO.getVehMarca()%></td>
                    <td><%=vehVO.getVehEstado()%></td>
                    <td><%=vehVO.getVehPrecio()%></td>
                </tr>
                <%}%>
            </table>
        </form>
    </center>
</body>
</html>
