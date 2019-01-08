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

    ComplVisitante complVisitante;

    public ComplVisitanteDAO() {
    }

    private ComplVisitante getComplVisitanteBD(int idVisitante) {

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
                complVisitante.setIdVisitante(idVisitante);
            } else {
                complVisitante.setId(0);
                complVisitante.setIdVisitante(idVisitante);
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

    public ComplVisitante getComplVisitante(int idVisitante) {
        complVisitante = getComplVisitanteBD(idVisitante);
        return complVisitante;
    }

    public int tratarComplVisitante(ComplVisitante complVisitante) {

        this.complVisitante.setEmpresa(this.complVisitante.getEmpresa() == null ? "" : this.complVisitante.getEmpresa());
        this.complVisitante.setTelFixo(this.complVisitante.getTelFixo() == null ? "" : this.complVisitante.getTelFixo());
        this.complVisitante.setCelular(this.complVisitante.getCelular() == null ? "" : this.complVisitante.getCelular());
        this.complVisitante.setModeloVeic(this.complVisitante.getModeloVeic() == null ? "" : this.complVisitante.getModeloVeic());
        this.complVisitante.setPlacaVeic(this.complVisitante.getPlacaVeic() == null ? "" : this.complVisitante.getPlacaVeic());

        if (this.complVisitante.getEmpresa().equals(complVisitante.getEmpresa())
                && this.complVisitante.getTelFixo().equals(complVisitante.getTelFixo())
                && this.complVisitante.getCelular().equals(complVisitante.getCelular())
                && this.complVisitante.getModeloVeic().equals(complVisitante.getModeloVeic())
                && this.complVisitante.getPlacaVeic().equals(complVisitante.getPlacaVeic())) {
            
            return this.complVisitante.getId();
            
        } else {
            complVisitante.setIdVisitante(this.complVisitante.getIdVisitante());
            if (inserirComplVisitanteBD(complVisitante) > 0) {
                return getUltComplVisitanteBD(this.complVisitante.getIdVisitante()).getId();
            }
            else{
                return 0;
            }
        }

    }

    public int inserirComplVisitanteBD(ComplVisitante cv) {

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
                + " ( " + cv.getIdVisitante() + " "
                + " , '" + cv.getEmpresa() + "' "
                + " , '" + cv.getTelFixo() + "' "
                + " , '" + cv.getCelular() + "' "
                + " , '" + cv.getModeloVeic() + "' "
                + " , '" + cv.getPlacaVeic() + "' "
                + " , SYSDATE)";

        System.out.println("INSERT INTO "
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
                + " ( " + cv.getIdVisitante() + " "
                + " , '" + cv.getEmpresa() + "' "
                + " , '" + cv.getTelFixo() + "' "
                + " , '" + cv.getCelular() + "' "
                + " , '" + cv.getModeloVeic() + "' "
                + " , '" + cv.getPlacaVeic() + "' "
                + " , SYSDATE)");
        
        return Conn.getInstance().manipBDDefault(sql);

    }

    private ComplVisitante getUltComplVisitanteBD(int idVisitante) {

        ComplVisitante complVisitante = new ComplVisitante();

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

        return complVisitante;
    }

}
