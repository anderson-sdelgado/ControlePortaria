/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.domain.Visitado;

/**
 *
 * @author anderson
 */
public class VisitadoDAO {

    private final List<Visitado> visitadoList;

    public VisitadoDAO() {
        visitadoList = visitadoList();
    }

    private List<Visitado> visitadoList() {

        List<Visitado> list = new ArrayList();

        try {

            Statement stmt = Conn.getInstance().getConnection().createStatement();
            ResultSet rSet = stmt.executeQuery("SELECT"
                    + " CODIGO_VISITADO "
                    + " , NOME_VISITADO "
                    + " , LOCAL_VISITADO "
                    + " FROM "
                    + " CPD.PORTARIA_VISITADO "
                    + " ORDER BY "
                    + " CODIGO_VISITADO "
                    + " DESC ");

            while (rSet.next()) {
                Visitado visitado = new Visitado();
                visitado.setIdVisitado(Integer.parseInt(rSet.getString(1)));
                visitado.setNomeVisitado(rSet.getString(2));
                visitado.setLocalVisitado(rSet.getString(3));
                list.add(visitado);
            }

        } catch (Exception e) {
            System.out.println("Falha = " + e);
        }

        return list;
    }

    public Visitado pesqVisitado(Integer valor) {
        Visitado v = visitadoList.stream()
                .filter(visitado -> visitado.getIdVisitado() == valor)
                .findAny()
                .orElse(null);
        return v;
    }

    public List<Visitado> getVisitadoList() {
        return visitadoList;
    }

    public Visitado ultimoReg() {
        Comparator<Visitado> comparator = Comparator.comparing(Visitado::getIdVisitado);
        return visitadoList.stream().max(comparator).get();
    }

    public int inserirRegBD(Visitado v) {

        String sql = "INSERT INTO "
                + " CPD.PORTARIA_VISITADO "
                + " ( "
                + " CODIGO_VISITADO "
                + " , NOME_VISITADO "
                + " , LOCAL_VISITADO "
                + " , DATA_VISITADO "
                + " ) "
                + " VALUES "
                + " ( " + v.getIdVisitado() + " "
                + " , '" + v.getNomeVisitado() + "' "
                + " , '" + v.getLocalVisitado() + "' "
                + " , SYSDATE)";

        return Conn.getInstance().manipBDDefault(sql);

    }

    public void inserirRegList(Visitado v) {
        visitadoList.add(0, v);
    }

    public int atualizarRegBD(Visitado v) {

        String sql = " UPDATE "
                + " CPD.PORTARIA_VISITADO "
                + " SET "
                + " NOME_VISITADO = '" + v.getNomeVisitado() + "'"
                + " , LOCAL_VISITADO = '" + v.getLocalVisitado() + "'"
                + " WHERE "
                + " CODIGO_VISITADO = " + v.getIdVisitado();

        return Conn.getInstance().manipBDDefault(sql);

    }

    public void atualizarRegList(Visitado v) {
        Visitado vis = visitadoList.stream()
                .filter(visitado -> visitado.getIdVisitado() == v.getIdVisitado())
                .findAny()
                .orElse(null);

        vis.setNomeVisitado(v.getNomeVisitado());
        vis.setLocalVisitado(v.getLocalVisitado());
    }

    public int excluirRegBD(Visitado v) {

        String sql = " DELETE "
                + " CPD.PORTARIA_VISITADO "
                + " WHERE "
                + " CODIGO_VISITADO = " + v.getIdVisitado();

        return Conn.getInstance().manipBDDefault(sql);

    }

    public void excluirRegList(Visitado v) {
        visitadoList.removeIf(visitado -> visitado.getIdVisitado() == v.getIdVisitado());
    }

    public Visitado getVisitado(int pos) {
        return visitadoList.get(pos);
    }

}
