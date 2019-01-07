/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import model.domain.Visita;
import model.domain.Visitado;
import model.domain.Visitante;

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

    public int verVisVisitante(Visitante v) {

        int qtde = 0;

        try {

            Statement stmt = Conn.getInstance().getConnection().createStatement();
            ResultSet rSet = stmt.executeQuery("SELECT"
                    + " COUNT(COD_MOVIMENTO) "
                    + " FROM "
                    + " CPD.PORT_MOVIMENTO "
                    + " WHERE "
                    + " COD_VISITANTE = " + v.getId());

            while (rSet.next()) {
                qtde = Integer.parseInt(rSet.getString(1));
            }

        } catch (Exception e) {
            System.out.println("Falha = " + e);
        }

        return qtde;

    }

    public int verVisVisitado(Visitado v) {

        int qtde = 0;

        try {

            Statement stmt = Conn.getInstance().getConnection().createStatement();
            ResultSet rSet = stmt.executeQuery("SELECT"
                    + " COUNT(COD_MOVIMENTO) "
                    + " FROM "
                    + " CPD.PORT_MOVIMENTO "
                    + " WHERE "
                    + " COD_VISITADO = " + v.getId());

            while (rSet.next()) {
                qtde = Integer.parseInt(rSet.getString(1));
            }

        } catch (Exception e) {
            System.out.println("Falha = " + e);
        }

        return qtde;

    }

}
