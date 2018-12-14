/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.domain.ComplVisitante;

/**
 *
 * @author anderson
 */
public class ComplVisitanteDAO {

    public ComplVisitanteDAO() {
    }

    public ComplVisitante getComplVisitanteBD(int idVisitante) {

        ComplVisitante complVisitante = new ComplVisitante();

        try {

            Statement stmt = Conn.getInstance().getConnection().createStatement();
            ResultSet rSet = stmt.executeQuery("SELECT"
                    + " CODIGO_COMPL_VISIT "
                    + " , EMPRESA_VISITANTE "
                    + " , TELEFONE_VISITANTE "
                    + " , CELULAR_VISITANTE "
                    + " , MODELO_VISITANTE "
                    + " , PLACA_VISITANTE "
                    + " FROM "
                    + " PORT_COMPL_VISITANTE "
                    + " WHERE "
                    + " CODIGO_VISITANTE = " + idVisitante
                    + " ORDER BY "
                    + " CODIGO_COMPL_VISIT "
                    + " DESC ");

            if (rSet.isBeforeFirst()) {
                rSet.next();
                complVisitante.setId(Integer.parseInt(rSet.getString(1)));
                complVisitante.setEmpresa(rSet.getString(2));
                complVisitante.setTelFixo(rSet.getString(3));
                complVisitante.setCelular(rSet.getString(4));
                complVisitante.setModeloVeic(rSet.getString(5));
                complVisitante.setPlacaVeic(rSet.getString(6));
            } else {
                complVisitante.setId(0);
                complVisitante.setEmpresa("");
                complVisitante.setTelFixo("");
                complVisitante.setCelular("");
                complVisitante.setModeloVeic("");
                complVisitante.setPlacaVeic("");
            }

        } catch (Exception e) {
            System.out.println("Falha = " + e);
        }

        return complVisitante;
    }

}
