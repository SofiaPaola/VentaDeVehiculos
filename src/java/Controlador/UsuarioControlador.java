/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.DatosPersonalesDAO;
import ModeloDAO.UsuarioDAO;
import ModeloVO.DatosPersonalesVO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sofia Paola
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"})
public class UsuarioControlador extends HttpServlet {

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

        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String usuID = request.getParameter("textId");
        String usuLogin = request.getParameter("textUsuario");
        String usuPassword = request.getParameter("textClave");

        UsuarioVO usuVO = new UsuarioVO(usuID, usuLogin, usuPassword);
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);

        switch (opcion) {
            case 1://agregar regstro
                if (usuDAO.agregarRegistro()) {
                    request.setAttribute("mensajEXito", "El usuario se registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "El usuario NO se registro correctamente");
                }
                request.getRequestDispatcher("registrarUsuario.jsp").forward(request, response);
                break;
            case 2:// actualizar registros
                if (usuDAO.actualizarRegistro()) {
                    request.setAttribute("mensajEXito", "El usuario se registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "El usuario NO se actualizo correctamente");
                }
                request.getRequestDispatcher("actualizarUsuario.jsp").forward(request, response);
                break;
            case 3://inicio de sesion
                String idUsuario="";
                if (usuDAO.iniciarSesion(usuLogin, usuPassword)) {

                    HttpSession miSesion = request.getSession(true);                    
                    usuVO = new UsuarioVO(usuID, usuLogin, usuPassword);
                    miSesion.setAttribute("datos", usuVO);
                    ArrayList<UsuarioVO> listaRol = usuDAO.rol(usuLogin);

                    for (int i = 0; i < listaRol.size(); i++) {
                        usuVO = listaRol.get(i);
                        idUsuario = usuVO.getUsuId();
                    }
                    
                    DatosPersonalesVO datpVO = new DatosPersonalesVO();
                    DatosPersonalesDAO datpDAO = new DatosPersonalesDAO();

                    datpVO=datpDAO.consultarDatos(idUsuario);
                    miSesion.setAttribute("datosPersonales", datpVO);
                    
                    miSesion.setAttribute("rol", listaRol);                    
                    if (listaRol.size() > 1) {
                        request.getRequestDispatcher("menu.jsp").forward(request, response);
                    } else if (usuVO.getRol().equals("Vendedor")) {
                        request.getRequestDispatcher("vendedor.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("comprador.jsp").forward(request, response);
                    }                                        
                } else {
                    request.setAttribute("mensajeError", "Datos de inicio de sesion incorrectos");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
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
