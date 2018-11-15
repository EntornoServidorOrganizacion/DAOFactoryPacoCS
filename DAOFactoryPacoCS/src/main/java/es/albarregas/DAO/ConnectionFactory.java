/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 *
 * @author paco
 */
public class ConnectionFactory {

    static Connection conexion = null;
    static DataSource datasource = null;
    static final String DATA_SOURCE_MYSQL = "java:comp/env/jdbc/FactMy";
    static final String DATA_SOURCE_DERBY = "java:comp/env/jdbc/FactDe";

    public static Connection getMySQLConnection() {

        try {
            Context contextoInicial = new InitialContext();
            datasource = (DataSource) contextoInicial.lookup(DATA_SOURCE_MYSQL);
            conexion = datasource.getConnection();
        } catch (NamingException ex) {
            ex.printStackTrace();
        }

        return conexion;

    }

    public static Connection getDerbyConnection() {
        
        try {
            Context contextoInicial = new InitialContext();
            datasource = (DataSource) contextoInicial.lookup(DATA_SOURCE_DERBY);
            conexion = datasource.getConnection();
        } catch (NamingException ex) {
            ex.printStackTrace();
        }

        return conexion;
    }

    public static void closeConexion() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
