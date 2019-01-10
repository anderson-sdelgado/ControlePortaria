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
import model.domain.Visitado;
import model.domain.Visitante;

/**
 *
 * @author anderson
 */
public class VisitaDAO {

    private List<Visita> visitaList;
    private List<Visita> visitaCrachaList;

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
                + " ( " + v.getVisitante().getIdVisitante() + " "
                + " , " + v.getVisitado().getIdVisitado() + " "
                + " , " + v.getVisitante().getComplVisitante().getIdVisitante() + " "
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
                    + " COD_VISITANTE = " + v.getIdVisitante());

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
                    + " COD_VISITADO = " + v.getIdVisitado());

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
                    + " , VISITANTE.CODIGO_VISITANTE "
                    + " , VISITANTE.NOME_VISITANTE "
                    + " , LPAD (VISITANTE.CPF_VISITANTE, 11, 0) "
                    + " , VISITANTE.RG_VISITANTE "
                    + " , CV.EMPRESA_VISITANTE "
                    + " , VISITADO.NOME_VISITADO "
                    + " , VISITADO.LOCAL_VISITADO "
                    + " , TO_CHAR(M.DTHR_ENTRADA, 'HH24:MI:SS') "
                    + " FROM "
                    + " PORT_MOVIMENTO M "
                    + " , PORT_VISITANTE VISITANTE "
                    + " , PORT_VISITADO VISITADO "
                    + " , PORT_COMPL_VISITANTE CV "
                    + " WHERE "
                    + " M.DTHR_SAIDA IS NULL "
                    + " AND "
                    + " VISITANTE.CODIGO_VISITANTE = M.COD_VISITANTE "
                    + " AND "
                    + " VISITADO.CODIGO_VISITADO = M.COD_VISITADO "
                    + " AND "
                    + " CV.CODIGO_COMPL_VISIT = M.COD_COMPL_VISIT "
                    + " ORDER BY "
                    + " M.COD_MOVIMENTO "
                    + " DESC ");

            while (rSet.next()) {
                Visita visita = new Visita();
                visita.setIdVisita(Integer.parseInt(rSet.getString(1)));
                Visitante visitante = new Visitante();
                visitante.setIdVisitante(Integer.parseInt(rSet.getString(2)));
                visitante.setNomeVisitante(rSet.getString(3));
                visitante.setCpfVisitante(rSet.getString(4));
                visitante.setRgVisitante(rSet.getString(5));
                ComplVisitante complVisitante = new ComplVisitante();
                complVisitante.setEmpresaVisitante(rSet.getString(6));
                visitante.setComplVisitante(complVisitante);
                visita.setVisitante(visitante);
                Visitado visitado = new Visitado();
                visitado.setNomeVisitado(rSet.getString(7));
                visitado.setLocalVisitado(rSet.getString(8));
                visita.setVisitado(visitado);
                visita.setDataHoraEntradaVisita(rSet.getString(9));
                visitaList.add(visita);
            }

        } catch (Exception e) {
            System.out.println("Falha = " + e);
        }

    }

    public List<Visita> getVisitaList() {
        return visitaList;
    }

    public List<Visita> getVisitaList(int pos) {
        Visita visit = visitaList.stream()
                .filter(visita -> visita.getIdVisita() == pos)
                .findAny()
                .orElse(null);
        visitaCrachaList = new ArrayList();
        visitaCrachaList.add(visit);
        return visitaCrachaList;
    }
    
    
}
