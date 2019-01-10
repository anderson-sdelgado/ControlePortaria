/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.domain.Visitante;

/**
 *
 * @author anderson
 */
public class VisitanteDAO {

    private final List<Visitante> visitanteList;

    public VisitanteDAO() {
        visitanteList = visitanteList();
    }

    public List<Visitante> visitanteList() {

        List<Visitante> list = new ArrayList();

        try {

            Statement stmt = Conn.getInstance().getConnection().createStatement();
            ResultSet rSet = stmt.executeQuery("SELECT"
                    + " CODIGO_VISITANTE "
                    + " , LPAD (CPF_VISITANTE, 11, 0) "
                    + " , RG_VISITANTE "
                    + " , NOME_VISITANTE "
                    + " FROM "
                    + " PORT_VISITANTE "
                    + " ORDER BY "
                    + " CODIGO_VISITANTE "
                    + " DESC ");

            while (rSet.next()) {
                Visitante visitante = new Visitante();
                visitante.setIdVisitante(Integer.parseInt(rSet.getString(1)));
                visitante.setCpfVisitante(rSet.getString(2));
                visitante.setRgVisitante(rSet.getString(3));
                visitante.setNomeVisitante(rSet.getString(4));
                list.add(visitante);
            }

        } catch (Exception e) {
            System.out.println("Falha = " + e);
        }

        return list;
    }

    public Visitante pesqVisitante(Integer valor) {
        Visitante v = visitanteList.stream()
                .filter(visitante -> visitante.getIdVisitante() == valor)
                .findAny()
                .orElse(null);
        return v;
    }

    public List<Visitante> getVisitanteList() {
        return visitanteList;
    }

    public Visitante ultimoReg() {
        Comparator<Visitante> comparator = Comparator.comparing(Visitante::getIdVisitante);
        return visitanteList.stream().max(comparator).get();
    }

    public int inserirRegBD(Visitante v) {

        String sql = "INSERT INTO "
                + " PORT_VISITANTE "
                + " ( "
                + " CODIGO_VISITANTE "
                + " , CPF_VISITANTE "
                + " , RG_VISITANTE "
                + " , NOME_VISITANTE "
                + " , DATA_VISITANTE "
                + " ) "
                + " VALUES "
                + " ( " + v.getIdVisitante() + " "
                + " , " + v.getCpfVisitante() + " "
                + " , '" + v.getRgVisitante() + "' "
                + " , '" + v.getNomeVisitante() + "' "
                + " , SYSDATE)";

        return Conn.getInstance().manipBDDefault(sql);

    }

    public void inserirRegList(Visitante v) {
        visitanteList.add(0, v);
    }

    public int atualizarRegBD(Visitante v) {

        String sql = " UPDATE "
                + " PORT_VISITANTE "
                + " SET "
                + " CPF_VISITANTE = " + v.getCpfVisitante()
                + " , RG_VISITANTE = '" + v.getRgVisitante() + "'"
                + " , NOME_VISITANTE = '" + v.getNomeVisitante() + "'"
                + " WHERE "
                + " CODIGO_VISITANTE = " + v.getIdVisitante();

        return Conn.getInstance().manipBDDefault(sql);

    }

    public void atualizarRegList(Visitante v) {
        Visitante vis = visitanteList.stream()
                .filter(visitante -> visitante.getIdVisitante() == v.getIdVisitante())
                .findAny()
                .orElse(null);

        vis.setCpfVisitante(v.getCpfVisitante());
        vis.setRgVisitante(v.getRgVisitante());
        vis.setNomeVisitante(v.getNomeVisitante());
    }

    public int excluirRegBD(Visitante v) {

        String sql = " DELETE "
                + " PORT_VISITANTE "
                + " WHERE "
                + " CODIGO_VISITANTE = " + v.getIdVisitante();

        return Conn.getInstance().manipBDDefault(sql);

    }

    public void excluirRegList(Visitante v) {
        visitanteList.removeIf(visitante -> visitante.getIdVisitante() == v.getIdVisitante());
    }

}
