/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.beans.Avistamientos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author paco
 */
public class MySQLAvistamientosDAO implements IAvistamientosDAO {

    @Override
    public ArrayList<Avistamientos> getAvistamientos() {
        ArrayList<Avistamientos> lista = new ArrayList();
        HttpServletRequest request = null;
        
        String consulta = "select * from avistamientos where anilla = ?";
        
        try {
            PreparedStatement sentencia = (PreparedStatement) ConnectionFactory.getMySQLConnection().createStatement();
            sentencia.setString(1, request.getParameter("anilla"));
            ResultSet resultado = sentencia.executeQuery(consulta);
            
            

            while (resultado.next()) {
                Avistamientos avistamientos = new Avistamientos();
                avistamientos.setAnilla(resultado.getString("anilla"));
                avistamientos.setEspecie(resultado.getString("especie"));
                avistamientos.setLugar(resultado.getString("lugar"));
                avistamientos.setFecha(resultado.getString("fecha"));
                lista.add(avistamientos);
            }

            resultado.close();

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecnia");
            ex.printStackTrace();
        }
        
        return lista;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConexion();
    }

}
