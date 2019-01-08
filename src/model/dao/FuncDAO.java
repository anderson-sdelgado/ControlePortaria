/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import model.domain.Func;

/**
 *
 * @author anderson
 */
public class FuncDAO {

    public FuncDAO() {
    }
    
    public Func verFuncRecep(Func func){

        try {

            Statement stmt = Conn.getInstance().getConnection().createStatement();
            ResultSet rSet = stmt.executeQuery("SELECT COLAB.CD, CORR.NOME "
                    + " FROM COLAB, CORR "
                    + " , REG_DEMIS DEM  "
                    + " WHERE "
                    + " COLAB.CD = " + func.getMatricFunc()
                    + " AND COLAB.CORR_ID = CORR.CORR_ID "
                    + " AND DEM.COLAB_ID IS NULL  "
                    + " AND COLAB.COLAB_ID = DEM.COLAB_ID(+)  "
                    + " AND COLAB.CD > 10000 "
                    + " ORDER BY COLAB.CD ASC ");

            if (rSet.isBeforeFirst()) {
                rSet.next();
                func.setNomeFunc(rSet.getString(2));
            } else {
                func.setNomeFunc("FUNCIONARIO INEXISTENTE");
            }

        } catch (Exception e) {
            System.out.println("Falha = " + e);
        }

        return func;
        
    }
    
}
