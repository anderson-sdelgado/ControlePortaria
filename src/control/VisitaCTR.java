/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import model.dao.ComplVisitanteDAO;
import model.dao.EmpresaDAO;
import model.dao.VisitaDAO;
import model.domain.ComplVisitante;
import model.domain.EmpresaVisitante;
import model.domain.Visita;
import model.domain.Visitado;
import model.domain.Visitante;

/**
 *
 * @author anderson
 */
public class VisitaCTR {

    private final ComplVisitanteDAO complVisitanteDAO;
    private final EmpresaDAO empresaVisitanteDAO;
    private final VisitaDAO visitaDAO;

    public VisitaCTR() {
        complVisitanteDAO = new ComplVisitanteDAO();
        empresaVisitanteDAO = new EmpresaDAO();
        visitaDAO = new VisitaDAO();
    }

    public ComplVisitante getComplVisitante(int idVisitante) {
        return complVisitanteDAO.getComplVisitante(idVisitante);
    }

    public Boolean salvarVisita(Visita visita) {
        visita.getVisitante().setComplVisitante(complVisitanteDAO.tratarComplVisitante(visita));
        return visitaDAO.inserirRegBD(visita) > 0;
    }

    public void carregListaVisitaNaEmpresa() {
        visitaDAO.carregVisitaNaEmpresa();
    }

    public List<Visita> getVisitaList() {
        return visitaDAO.getVisitaList();
    }

    public List<Visita> getVisitaList(int pos) {
        return visitaDAO.getVisitaList(pos);
    }

    public List<EmpresaVisitante> getEmpresaList() {
        return empresaVisitanteDAO.getEmpresaList();
    }

    public int posEmpresaList(int id) {
        return empresaVisitanteDAO.posEmpresa(id);
    }

    public EmpresaVisitante getEmpresa(int pos, String nome) {
        if (pos > 0) {
            return empresaVisitanteDAO.getEmpresa(pos);
        } else if (pos == 0) {
            EmpresaVisitante empresa = new EmpresaVisitante();
            empresa.setIdEmpresa(0);
            return empresa;
        } else {
            EmpresaVisitante empresa = new EmpresaVisitante();
            empresa.setIdEmpresa(0);
            if (!nome.equals("null")) {
                empresa.setNomeEmpresa(nome);
                if (empresaVisitanteDAO.inserirRegBD(empresa) > 0) {
                    carregListaEmpresa();
                    return empresaVisitanteDAO.ultimoReg();
                } else {
                    empresa.setIdEmpresa(-1);
                    return empresa;
                }
            } else {
                return empresa;
            }
        }
    }

    public void carregListaEmpresa() {
        empresaVisitanteDAO.carregaEmpresaList();
    }

    public List<Visita> getVisitaRelList(Visitante visitante,
            EmpresaVisitante empresa,
            Visitado visitado,
            String dataInicial,
            String dataFinal) {
        return visitaDAO.getRelVisita(visitante, empresa, visitado, dataInicial, dataFinal);
    }

    public EmpresaVisitante getEmpresa(int pos) {
        if (pos < 0) {
            EmpresaVisitante empresaVisitante = new EmpresaVisitante();
            empresaVisitante.setIdEmpresa(0);
            return empresaVisitante;
        } else {
            return empresaVisitanteDAO.getEmpresa(pos);
        }
    }

}
