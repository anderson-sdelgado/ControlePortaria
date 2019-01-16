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
import model.domain.EmpresaVisitante;

/**
 *
 * @author anderson
 */
public class EmpresaDAO {

    private List<EmpresaVisitante> empresaList;

    public EmpresaDAO() {
    }

    private List<EmpresaVisitante> empresaList() {

        List<EmpresaVisitante> list = new ArrayList();

        try {

            Statement stmt = Conn.getInstance().getConnection().createStatement();
            ResultSet rSet = stmt.executeQuery("SELECT"
                    + " CODIGO_EMPRESA "
                    + " , NOME_EMPRESA "
                    + " FROM "
                    + " CPD.PORTARIA_EMPRESA_VISIT "
                    + " ORDER BY "
                    + " NOME_EMPRESA "
                    + " ASC ");

            while (rSet.next()) {
                EmpresaVisitante empresa = new EmpresaVisitante();
                empresa.setIdEmpresa(Integer.parseInt(rSet.getString(1)));
                empresa.setNomeEmpresa(rSet.getString(2));
                list.add(empresa);
            }

        } catch (Exception e) {
            System.out.println("Falha = " + e);
        }

        return list;
    }

    public List<EmpresaVisitante> getEmpresaList() {
        return empresaList;
    }
    
    public void carregaEmpresaList(){
        empresaList = empresaList();
    }

    public EmpresaVisitante pesqEmpresa(Integer valor) {
        EmpresaVisitante ev = empresaList.stream()
                .filter(empresa -> empresa.getIdEmpresa() == valor)
                .findAny()
                .orElse(null);
        return ev;
    }

    public int posEmpresa(Integer valor) {
        return empresaList.indexOf(pesqEmpresa(valor));
    }

    public EmpresaVisitante getEmpresa(Integer pos) {
        return empresaList.get(pos);
    }
    
    public int inserirRegBD(EmpresaVisitante e) {

        String sql = "INSERT INTO "
                + " CPD.PORTARIA_EMPRESA_VISIT "
                + " ( "
                + " NOME_EMPRESA "
                + " ) "
                + " VALUES "
                + " ( '" + e.getNomeEmpresa() + "' )";

        return Conn.getInstance().manipBDDefault(sql);

    }
    
    public EmpresaVisitante ultimoReg() {
        Comparator<EmpresaVisitante> comparator = Comparator.comparing(EmpresaVisitante::getIdEmpresa);
        return empresaList.stream().max(comparator).get();
    }
    

}
