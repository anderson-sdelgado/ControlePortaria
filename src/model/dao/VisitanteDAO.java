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
                visitante.setId(Integer.parseInt(rSet.getString(1)));
                visitante.setCpf(rSet.getString(2));
                visitante.setRg(rSet.getString(3));
                visitante.setNome(rSet.getString(4));
                list.add(visitante);
            }

        } catch (Exception e) {
            System.out.println("Falha = " + e);
        }

        return list;
    }

    public Visitante pesqVisitante(Integer valor) {
        Visitante v = visitanteList.stream()
                .filter(visitante -> visitante.getId() == valor)
                .findAny()
                .orElse(null);
        return v;
    }

    public List<Visitante> getVisitanteList() {
        return visitanteList;
    }

    public Visitante ultimoReg() {
        Comparator<Visitante> comparator = Comparator.comparing(Visitante::getId);
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
                + " ( " + v.getId() + " "
                + " , " + v.getCpf() + " "
                + " , '" + v.getRg() + "' "
                + " , '" + v.getNome() + "' "
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
                + " CPF_VISITANTE = " + v.getCpf()
                + " , RG_VISITANTE = '" + v.getRg() + "'"
                + " , NOME_VISITANTE = '" + v.getNome() + "'"
                + " WHERE "
                + " CODIGO_VISITANTE = " + v.getId();

        return Conn.getInstance().manipBDDefault(sql);

    }

    public void atualizarRegList(Visitante v) {
        Visitante vis = visitanteList.stream()
                .filter(visitante -> visitante.getId() == v.getId())
                .findAny()
                .orElse(null);

        vis.setCpf(v.getCpf());
        vis.setRg(v.getRg());
        vis.setNome(v.getNome());
    }

    public int excluirRegBD(Visitante v) {

        String sql = " DELETE "
                + " PORT_VISITANTE "
                + " WHERE "
                + " CODIGO_VISITANTE = " + v.getId();

        return Conn.getInstance().manipBDDefault(sql);

    }

    public void excluirRegList(Visitante v) {
        visitanteList.removeIf(visitante -> visitante.getId() == v.getId());
    }

}
