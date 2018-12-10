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
import java.util.List;
import model.domain.Visitante;

/**
 *
 * @author anderson
 */
public class VisitanteDAO {

    private Connection conn;

    public VisitanteDAO() {
        conn = Conn.getInstance().getConnection();
    }

    public List<Visitante> visitantesTabela() {

        List<Visitante> r = new ArrayList();

        try {

            Statement stmt = conn.createStatement();
            ResultSet rSet = stmt.executeQuery("SELECT"
                    + " FOTO_VISITANTE "
                    + " , CPF_VISITANTE "
                    + " , RG_VISITANTE "
                    + " , NOME_VISITANTE "
                    + " FROM "
                    + " PORT_VISITANTE "
                    + " ORDER BY "
                    + " NOME_VISITANTE "
                    + " ASC ");

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

}
