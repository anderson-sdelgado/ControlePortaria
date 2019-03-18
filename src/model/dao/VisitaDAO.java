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
                + " CPD.PORTARIA_VISITA "
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
                + " , " + ((v.getVisitante().getComplVisitante().getIdVisitante() == 0) ? "NULL" : v.getVisitante().getComplVisitante().getIdVisitante()) + " "
                + " , " + v.getMatricRecep() + " "
                + " , SYSDATE)";

        return Conn.getInstance().manipBDDefault(sql);

    }

    public int updateRegBD(int id) {

        String sql = " UPDATE "
                + " CPD.PORTARIA_VISITA "
                + " SET "
                + " DTHR_SAIDA = SYSDATE "
                + " WHERE "
                + " COD_VISITA  = " + id;

        return Conn.getInstance().manipBDDefault(sql);

    }

    public int verVisVisitante(Visitante v) {

        int qtde = 0;

        try {

            Statement stmt = Conn.getInstance().getConnection().createStatement();
            ResultSet rSet = stmt.executeQuery("SELECT"
                    + " COUNT(COD_VISITA) "
                    + " FROM "
                    + " CPD.PORTARIA_VISITA "
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
                    + " COUNT(COD_VISITA) "
                    + " FROM "
                    + " CPD.PORTARIA_VISITA "
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
                    + " M.COD_VISITA "
                    + " , VISITANTE.CODIGO_VISITANTE "
                    + " , VISITANTE.NOME_VISITANTE "
                    + " , LPAD (VISITANTE.CPF_VISITANTE, 11, 0) "
                    + " , VISITANTE.RG_VISITANTE "
                    + " , EV.NOME_EMPRESA "
                    + " , VISITADO.NOME_VISITADO "
                    + " , VISITADO.LOCAL_VISITADO "
                    + " , TO_CHAR(M.DTHR_ENTRADA, 'HH24:MI:SS') "
                    + " FROM "
                    + " CPD.PORTARIA_VISITA M "
                    + " , PORTARIA_VISITANTE VISITANTE "
                    + " , PORTARIA_VISITADO VISITADO "
                    + " , PORTARIA_COMPL_VISITANTE CV "
                    + " , PORTARIA_EMPRESA_VISIT EV "
                    + " WHERE "
                    + " M.DTHR_SAIDA IS NULL "
                    + " AND "
                    + " VISITANTE.CODIGO_VISITANTE = M.COD_VISITANTE "
                    + " AND "
                    + " VISITADO.CODIGO_VISITADO = M.COD_VISITADO "
                    + " AND "
                    + " M.COD_COMPL_VISIT = CV.CODIGO_COMPL_VISIT(+) "
                    + " AND "
                    + " CV.COD_EMPRESA_VISITANTE = EV.CODIGO_EMPRESA(+) "
                    + " ORDER BY "
                    + " M.COD_VISITA "
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
                EmpresaVisitante empresaVisitante = new EmpresaVisitante();
                empresaVisitante.setNomeEmpresa(rSet.getString(6));
                complVisitante.setEmpresaVisitante(empresaVisitante);
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

    public List<Visita> getRelVisita(Visitante vnte,
            EmpresaVisitante empresaVisitante,
            Visitado vdo,
            String dataInicial,
            String dataFinal) {

        String visitante = (vnte.getIdVisitante() == 0) ? "NULL" : String.valueOf(vnte.getIdVisitante());
        String empresa = (empresaVisitante.getIdEmpresa() == 0) ? "NULL" : String.valueOf(empresaVisitante.getIdEmpresa());
        String visitado = (vdo.getIdVisitado() == 0) ? "NULL" : String.valueOf(vdo.getIdVisitado());

        List<Visita> relVisitaList = new ArrayList();

        try {

            Statement stmt = Conn.getInstance().getConnection().createStatement();
            ResultSet rSet = stmt.executeQuery("SELECT "
                    + " M.COD_VISITA "
                    + " , VISITANTE.CODIGO_VISITANTE "
                    + " , VISITANTE.NOME_VISITANTE "
                    + " , LPAD (VISITANTE.CPF_VISITANTE, 11, 0) "
                    + " , VISITANTE.RG_VISITANTE "
                    + " , EV.NOME_EMPRESA "
                    + " , VISITADO.NOME_VISITADO "
                    + " , VISITADO.LOCAL_VISITADO "
                    + " , TO_CHAR(M.DTHR_ENTRADA, 'DD/MM/YYYY HH24:MI:SS') "
                    + " , TO_CHAR(M.DTHR_SAIDA, 'DD/MM/YYYY HH24:MI:SS') "
                    + " FROM "
                    + " CPD.PORTARIA_VISITA M "
                    + " , PORTARIA_VISITANTE VISITANTE "
                    + " , PORTARIA_VISITADO VISITADO "
                    + " , PORTARIA_COMPL_VISITANTE CV "
                    + " , PORTARIA_EMPRESA_VISIT EV "
                    + " WHERE "
                    + "  ( M.DTHR_ENTRADA BETWEEN TO_DATE( '" + dataInicial + "', 'DD/MM/YYYY') AND (TO_DATE('" + dataFinal + "', 'DD/MM/YYYY') + 1))"
                    + " AND "
                    + " (" + visitante + " is null OR VISITANTE.CODIGO_VISITANTE = " + visitante + ")"
                    + " AND "
                    + " (" + empresa + " is null OR EV.CODIGO_EMPRESA = " + empresa + ")"
                    + " AND "
                    + " (" + visitado + " is null OR VISITADO.CODIGO_VISITADO = " + visitado + ")"
                    + " AND "
                    + " VISITANTE.CODIGO_VISITANTE = M.COD_VISITANTE "
                    + " AND "
                    + " VISITADO.CODIGO_VISITADO = M.COD_VISITADO "
                    + " AND "
                    + " M.COD_COMPL_VISIT = CV.CODIGO_COMPL_VISIT(+) "
                    + " AND "
                    + " CV.COD_EMPRESA_VISITANTE = EV.CODIGO_EMPRESA(+) "
                    + " ORDER BY "
                    + " M.COD_VISITA "
                    + " DESC ");

            while (rSet.next()) {
                Visita visita = new Visita();
                visita.setIdVisita(Integer.parseInt(rSet.getString(1)));
                Visitante ve = new Visitante();
                ve.setIdVisitante(Integer.parseInt(rSet.getString(2)));
                ve.setNomeVisitante(rSet.getString(3));
                ve.setCpfVisitante(rSet.getString(4));
                ve.setRgVisitante(rSet.getString(5));
                ComplVisitante complVisitante = new ComplVisitante();
                EmpresaVisitante ev = new EmpresaVisitante();
                ev.setNomeEmpresa(rSet.getString(6));
                complVisitante.setEmpresaVisitante(empresaVisitante);
                ve.setComplVisitante(complVisitante);
                visita.setVisitante(ve);
                Visitado vo = new Visitado();
                vo.setNomeVisitado(rSet.getString(7));
                vo.setLocalVisitado(rSet.getString(8));
                visita.setVisitado(vo);
                visita.setDataHoraEntradaVisita(rSet.getString(9));
                visita.setDataHoraSaidaVisita(rSet.getString(10));
                relVisitaList.add(visita);
            }

        } catch (Exception e) {
            System.out.println("Falha = " + e);
        }

        return relVisitaList;

    }

    public void excluirRegList(int id) {
        visitaList.removeIf(visita -> visita.getIdVisita() == id);
    }

    public Visita pesqVisita(Integer valor) {
        Visita v = visitaList.stream()
                .filter(visitado -> visitado.getIdVisita() == valor)
                .findAny()
                .orElse(null);
        return v;
    }

}
