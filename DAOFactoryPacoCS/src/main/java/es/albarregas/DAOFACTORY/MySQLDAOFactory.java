/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAOFACTORY;

import es.albarregas.DAO.MySQLAvistamientosDAO;
import es.albarregas.DAO.IAvistamientosDAO;

/**
 *
 * @author paco
 */
public class MySQLDAOFactory extends DAOFactory {

    @Override
    public IAvistamientosDAO getAvistamientosDAO() {
        return new MySQLAvistamientosDAO();
    }

    
}
