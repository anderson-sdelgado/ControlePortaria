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
import model.domain.EmpresaVisitante;
import model.domain.Visita;

/**
 *
 * @author anderson
 */
public class ComplVisitanteDAO {

    ComplVisitante complVisitante;
    EmpresaVisitante empresaVisitante;

    public ComplVisitanteDAO() {
    }

    public ComplVisitante getComplVisitante(int idVisitante) {

        complVisitante = new ComplVisitante();

        try {

            Statement stmt = Conn.getInstance().getConnection().createStatement();
            ResultSet rSet = stmt.executeQuery("SELECT"
                    + " CV.CODIGO_COMPL_VISIT "
                    + " , NVL(EV.CODIGO_EMPRESA, 0) "
                    + " , CV.TELEFONE_VISITANTE "
                    + " , CV.CELULAR_VISITANTE "
                    + " , CV.MODELO_VISITANTE "
                    + " , CV.PLACA_VISITANTE "
                    + " FROM "
                    + " CPD.PORTARIA_COMPL_VISITANTE CV "
                    + " , CPD.PORTARIA_EMPRESA_VISIT EV "
                    + " WHERE "
                    + " CV.CODIGO_VISITANTE = " + idVisitante
                    + " AND "
                    + " CV.COD_EMPRESA_VISITANTE = EV.CODIGO_EMPRESA(+) "
                    + " ORDER BY "
                    + " CV.CODIGO_COMPL_VISIT "
                    + " DESC ");

            if (rSet.isBeforeFirst()) {
                rSet.next();
                complVisitante.setIdVisitante(Integer.parseInt(rSet.getString(1)));
                empresaVisitante = new EmpresaVisitante();
                empresaVisitante.setIdEmpresa(Integer.parseInt(rSet.getString(2)));
                complVisitante.setEmpresaVisitante(empresaVisitante);
                complVisitante.setTelFixoVisitante(rSet.getString(3));
                complVisitante.setCelularVisitante(rSet.getString(4));
                complVisitante.setModeloVeicVisitante(rSet.getString(5));
                complVisitante.setPlacaVeicVisitante(rSet.getString(6));

                complVisitante.setTelFixoVisitante(this.complVisitante.getTelFixoVisitante() == null ? "" : this.complVisitante.getTelFixoVisitante());
                complVisitante.setCelularVisitante(this.complVisitante.getCelularVisitante() == null ? "" : this.complVisitante.getCelularVisitante());
                complVisitante.setModeloVeicVisitante(this.complVisitante.getModeloVeicVisitante() == null ? "" : this.complVisitante.getModeloVeicVisitante());
                complVisitante.setPlacaVeicVisitante(this.complVisitante.getPlacaVeicVisitante() == null ? "" : this.complVisitante.getPlacaVeicVisitante());

            } else {
                complVisitante.setIdVisitante(0);
                empresaVisitante = new EmpresaVisitante();
                empresaVisitante.setIdEmpresa(0);
                complVisitante.setEmpresaVisitante(empresaVisitante);
                complVisitante.setTelFixoVisitante("");
                complVisitante.setCelularVisitante("");
                complVisitante.setModeloVeicVisitante("");
                complVisitante.setPlacaVeicVisitante("");
            }

        } catch (Exception e) {
            System.out.println("Falha complemento = " + e);
        }

        return complVisitante;

    }

    public ComplVisitante tratarComplVisitante(Visita visita) {

        if (!((this.empresaVisitante.getIdEmpresa() == visita.getVisitante().getComplVisitante().getEmpresaVisitante().getIdEmpresa())
                && this.complVisitante.getTelFixoVisitante().equals(visita.getVisitante().getComplVisitante().getTelFixoVisitante())
                && this.complVisitante.getCelularVisitante().equals(visita.getVisitante().getComplVisitante().getCelularVisitante())
                && this.complVisitante.getModeloVeicVisitante().equals(visita.getVisitante().getComplVisitante().getModeloVeicVisitante())
                && this.complVisitante.getPlacaVeicVisitante().equals(visita.getVisitante().getComplVisitante().getPlacaVeicVisitante()))) {

            if (inserirComplVisitanteBD(visita) > 0) {
                this.complVisitante = visita.getVisitante().getComplVisitante();
                getUltComplVisitanteBD(visita.getVisitante().getIdVisitante());
                return this.complVisitante;
            }
        }

        return this.complVisitante;

    }

    public int inserirComplVisitanteBD(Visita visita) {

        String sql = "INSERT INTO "
                + " CPD.PORTARIA_COMPL_VISITANTE "
                + " ( "
                + " CODIGO_VISITANTE "
                + " , COD_EMPRESA_VISITANTE "
                + " , TELEFONE_VISITANTE "
                + " , CELULAR_VISITANTE "
                + " , MODELO_VISITANTE "
                + " , PLACA_VISITANTE "
                + " , DATA_COMPL_VISIT "
                + " ) "
                + " VALUES "
                + " ( " + visita.getVisitante().getIdVisitante() + " "
                + " , " + ((visita.getVisitante().getComplVisitante().getEmpresaVisitante().getIdEmpresa() == 0) ? "NULL" : visita.getVisitante().getComplVisitante().getEmpresaVisitante().getIdEmpresa()) + " "
                + " , '" + visita.getVisitante().getComplVisitante().getTelFixoVisitante() + "' "
                + " , '" + visita.getVisitante().getComplVisitante().getCelularVisitante() + "' "
                + " , '" + visita.getVisitante().getComplVisitante().getModeloVeicVisitante() + "' "
                + " , '" + visita.getVisitante().getComplVisitante().getPlacaVeicVisitante() + "' "
                + " , SYSDATE)";

        return Conn.getInstance().manipBDDefault(sql);

    }

    private void getUltComplVisitanteBD(int idVisitante) {

        try {

            Statement stmt = Conn.getInstance().getConnection().createStatement();
            ResultSet rSet = stmt.executeQuery("SELECT"
                    + " MAX(CODIGO_COMPL_VISIT) "
                    + " FROM "
                    + " CPD.PORTARIA_COMPL_VISITANTE "
                    + " WHERE "
                    + " CODIGO_VISITANTE = " + idVisitante);

            rSet.next();
            complVisitante.setIdVisitante(Integer.parseInt(rSet.getString(1)));

        } catch (Exception e) {
            System.out.println("Falha = " + e);
        }

    }

}
