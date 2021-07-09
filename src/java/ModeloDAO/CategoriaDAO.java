/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.CategoriaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Util.Conexion;

/**
 *
 * @author Sofia Paola
 */
public class CategoriaDAO extends Conexion {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private String sql;
    
    public ArrayList<CategoriaVO> Listar() {
        ArrayList<CategoriaVO> ListaCategoria = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from categoria";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                CategoriaVO catVO = new CategoriaVO(mensajero.getString(1),
                        mensajero.getString(2));
                ListaCategoria.add(catVO);
            }
        } catch (SQLException e) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return ListaCategoria;
    }
}