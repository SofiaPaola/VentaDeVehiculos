/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.VehiculoDAO;
import ModeloVO.VehiculoVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sofia Paola
 */
@WebServlet(name = "VehiculoControlador", urlPatterns = {"/Vehiculo"})
public class VehiculoControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //1. recivir los datos de las vistas
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String vehPlaca = request.getParameter("textPlaca");
        String datId = request.getParameter("textDatos");
        String catIdt = request.getParameter("textCategoria");
        String vehModelo = request.getParameter("textModelo");
        String vehMarca = request.getParameter("textMarca");
        String vehEstado = request.getParameter("textEstado");
        String vehPrecio = request.getParameter("textPrecio");

        VehiculoVO VehVO = new VehiculoVO(vehPlaca, datId, catIdt, vehModelo, vehMarca, vehEstado, vehPrecio);
        VehiculoDAO VehDAO = new VehiculoDAO(VehVO);

        switch (opcion) {
            case 1://agregar registro
                if (VehDAO.agregarRegistro()) {
                    request.setAttribute("mensajExito", "El usuario del vehiculo se registro correctamente ");
                } else {
                    request.setAttribute("mensajeError", "El usuario del vehiculo NO se registro correctamente ");
                }
                request.getRequestDispatcher("registrarVehiculo.jsp").forward(request, response);
                break;
            case 2:// actualizar registros
                if (VehDAO.actualizarRegistro()) {
                    request.setAttribute("mensajExito", "El vehiculo se registro correctamente ");
                } else {
                    request.setAttribute("mensajeError", "El vehiculo NO se actualizo correctamente ");
                }
                request.getRequestDispatcher("actualizarVehiculo.jsp").forward(request, response);
                break;
            case 3://consultar vehiculo
                VehVO = VehDAO.consultarPlaca(vehPlaca);
                if (VehVO != null) {
                    request.setAttribute("vehiculoConsultado", VehVO);
                    request.getRequestDispatcher("actualizarVehiculo.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El vehiculo NO existe");
                    request.getRequestDispatcher("consultarVehiculo.jsp").forward(request, response);
                }
                break;
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}