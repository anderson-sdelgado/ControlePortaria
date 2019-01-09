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
import model.domain.Visita;
import model.domain.Visitado;
import model.domain.Visitante;

/**
 *
 * @author anderson
 */
public class VisitaDAO {

    private List<Visita> visitaList;

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
                + " ( " + v.getVisitante().getId() + " "
                + " , " + v.getVisitado().getId() + " "
                + " , " + v.getVisitante().getComplVisitante().getId() + " "
                + " , " + v.getMatricRecep() + " "
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

    public void carregVisitaNaEmpresa() {

        visitaList = new ArrayList();

        try {

            Statement stmt = Conn.getInstance().getConnection().createStatement();
            ResultSet rSet = stmt.executeQuery("SELECT "
                    + " M.COD_MOVIMENTO "
                    + " , V.CODIGO_VISITANTE "
                    + " , V.NOME_VISITANTE "
                    + " , LPAD (V.CPF_VISITANTE, 11, 0) "
                    + " , V.RG_VISITANTE "
                    + " , TO_CHAR(M.DTHR_ENTRADA, 'HH24:MI:SS') "
                    + " FROM "
                    + " PORT_MOVIMENTO M "
                    + " , PORT_VISITANTE V "
                    + " WHERE "
                    + " M.DTHR_SAIDA IS NULL "
                    + " AND "
                    + " V.CODIGO_VISITANTE = M.COD_VISITANTE "
                    + " ORDER BY "
                    + " M.COD_MOVIMENTO "
                    + " DESC ");

            while (rSet.next()) {
                Visita visita = new Visita();
                visita.setId(Integer.parseInt(rSet.getString(1)));
                Visitante visitante = new Visitante();
                visitante.setId(Integer.parseInt(rSet.getString(2)));
                visitante.setNome(rSet.getString(3));
                visitante.setCpf(rSet.getString(4));
                visitante.setRg(rSet.getString(5));
                visita.setVisitante(visitante);
                visita.setDataHoraEntrada(rSet.getString(6));
                visitaList.add(visita);
            }

        } catch (Exception e) {
            System.out.println("Falha = " + e);
        }

    }

    public List<Visita> getVisitaList() {
        return visitaList;
    }

}
