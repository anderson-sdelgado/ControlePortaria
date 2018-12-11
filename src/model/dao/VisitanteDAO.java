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

    private Connection conn;
    private List<Visitante> visitantesTabela;

    public VisitanteDAO() {
        conn = Conn.getInstance().getConnection();
        visitantesTabela = visitantesTabela();
    }

    public List<Visitante> visitantesTabela() {

        List<Visitante> r = new ArrayList();

        try {

            Statement stmt = conn.createStatement();
            ResultSet rSet = stmt.executeQuery("SELECT"
                    + " FOTO_VISITANTE "
                    + " , LPAD (CPF_VISITANTE, 11, 0) "
                    + " , RG_VISITANTE "
                    + " , NOME_VISITANTE "
                    + " FROM "
                    + " PORT_VISITANTE "
                    + " ORDER BY "
                    + " FOTO_VISITANTE "
                    + " DESC ");

            while (rSet.next()) {
                Visitante visitante = new Visitante();
                visitante.setId(Integer.parseInt(rSet.getString(1)));
                visitante.setCpf(rSet.getString(2));
                visitante.setRg(rSet.getString(3));
                visitante.setNome(rSet.getString(4));
                r.add(visitante);
            }

        } catch (Exception e) {
            System.out.println("Falha = " + e);
        }

        return r;
    }

    public Visitante pesqVisitante(Integer valor) {
        Visitante v = visitantesTabela.stream()
                .filter(visitante -> visitante.getId() == valor)
                .findAny()
                .orElse(null);
        return v;
    }

    public List<Visitante> getVisitantesTabela() {
        return visitantesTabela;
    }

    public Visitante ultimoReg() {
        Comparator<Visitante> comparator = Comparator.comparing(Visitante::getId);
        return visitantesTabela.stream().max(comparator).get();
    }

    public int inserirReg(Visitante v) {

        int r = 0;

        try {

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO "
                    + " PORT_VISITANTE "
                    + " ( "
                    + " FOTO_VISITANTE "
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

            System.out.println(sql);
            r = stmt.executeUpdate(sql);

            if (stmt != null) {
                stmt.close();
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return r;

    }

}
