/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.domain.Visita;

/**
 *
 * @author anderson
 */
public class VisitaDAO {

    public VisitaDAO() {
    }
    
    public int inserirRegBD(Visita v) {

        String sql = "INSERT INTO "
                + " PORT_MOVIMENTO "
                + " ( "
                + " COD_VISITANTE "
                + " , COD_VISITADO "
                + " , COD_COMPL_VISIT "
                + " , CRACHA_RECEP "
                + " , DTHR_ENTRADA "
                + " ) "
                + " VALUES "
                + " ( " + v.getIdVisitante() + " "
                + " , " + v.getIdVisitado() + " "
                + " , " + v.getIdCompVisitante() + " "
                + " , 0 "
                + " , SYSDATE)";

        return Conn.getInstance().manipBDDefault(sql);

    }
    
}
