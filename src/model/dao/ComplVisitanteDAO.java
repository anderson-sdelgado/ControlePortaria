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
import model.domain.Visita;

/**
 *
 * @author anderson
 */
public class ComplVisitanteDAO {

    ComplVisitante complVisitante;

    public ComplVisitanteDAO() {
    }

    public ComplVisitante getComplVisitante(int idVisitante) {

        complVisitante = new ComplVisitante();

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

                complVisitante.setEmpresa(this.complVisitante.getEmpresa() == null ? "" : this.complVisitante.getEmpresa());
                complVisitante.setTelFixo(this.complVisitante.getTelFixo() == null ? "" : this.complVisitante.getTelFixo());
                complVisitante.setCelular(this.complVisitante.getCelular() == null ? "" : this.complVisitante.getCelular());
                complVisitante.setModeloVeic(this.complVisitante.getModeloVeic() == null ? "" : this.complVisitante.getModeloVeic());
                complVisitante.setPlacaVeic(this.complVisitante.getPlacaVeic() == null ? "" : this.complVisitante.getPlacaVeic());

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

    public ComplVisitante tratarComplVisitante(Visita visita) {

        if (!(this.complVisitante.getEmpresa().equals(visita.getVisitante().getComplVisitante().getEmpresa())
                && this.complVisitante.getTelFixo().equals(visita.getVisitante().getComplVisitante().getTelFixo())
                && this.complVisitante.getCelular().equals(visita.getVisitante().getComplVisitante().getCelular())
                && this.complVisitante.getModeloVeic().equals(visita.getVisitante().getComplVisitante().getModeloVeic())
                && this.complVisitante.getPlacaVeic().equals(visita.getVisitante().getComplVisitante().getPlacaVeic()))) {

            if (inserirComplVisitanteBD(visita) > 0) {
                getUltComplVisitanteBD(visita.getVisitante().getId());
                this.complVisitante = visita.getVisitante().getComplVisitante();
                return this.complVisitante;
            }
        }

        return this.complVisitante;

    }

    public int inserirComplVisitanteBD(Visita visita) {

        String sql = "INSERT INTO "
                + " PORT_COMPL_VISITANTE "
                + " ( "
                + " CODIGO_VISITANTE "
                + " , EMPRESA_VISITANTE "
                + " , TELEFONE_VISITANTE "
                + " , CELULAR_VISITANTE "
                + " , MODELO_VISITANTE "
                + " , PLACA_VISITANTE "
                + " , DATA_COMPL_VISIT "
                + " ) "
                + " VALUES "
                + " ( " + visita.getVisitante().getId() + " "
                + " , '" + visita.getVisitante().getComplVisitante().getEmpresa() + "' "
                + " , '" + visita.getVisitante().getComplVisitante().getTelFixo() + "' "
                + " , '" + visita.getVisitante().getComplVisitante().getCelular() + "' "
                + " , '" + visita.getVisitante().getComplVisitante().getModeloVeic() + "' "
                + " , '" + visita.getVisitante().getComplVisitante().getPlacaVeic() + "' "
                + " , SYSDATE)";

        return Conn.getInstance().manipBDDefault(sql);

    }

    private void getUltComplVisitanteBD(int idVisitante) {

        try {

            Statement stmt = Conn.getInstance().getConnection().createStatement();
            ResultSet rSet = stmt.executeQuery("SELECT"
                    + " MAX(CODIGO_COMPL_VISIT) "
                    + " FROM "
                    + " PORT_COMPL_VISITANTE "
                    + " WHERE "
                    + " CODIGO_VISITANTE = " + idVisitante);

            rSet.next();
            complVisitante.setId(Integer.parseInt(rSet.getString(1)));

        } catch (Exception e) {
            System.out.println("Falha = " + e);
        }

    }

}
