/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import model.dao.VisitaDAO;
import model.dao.VisitanteDAO;
import model.domain.Visitante;

/**
 *
 * @author anderson
 */
public class VisitanteCTR {

    private final VisitanteDAO visitanteDAO;
    private final VisitaDAO visitaDAO;

    public VisitanteCTR() {
        visitanteDAO = new VisitanteDAO();
        visitaDAO = new VisitaDAO();
    }

    public List<Visitante> getVisitanteList() {
        return visitanteDAO.getVisitanteList();
    }

    public Visitante getPesqVisitante(Integer valor) {
        return visitanteDAO.pesqVisitante(valor);
    }

    public Visitante ultimoReg() {
        return visitanteDAO.ultimoReg();
    }

    public Boolean inserirReg(Visitante v) {
        if (visitanteDAO.inserirRegBD(v) > 0) {
            visitanteDAO.inserirRegList(v);
            return true;
        } else {
            return false;
        }
    }

    public Boolean atualizarReg(Visitante v) {
        if (visitanteDAO.atualizarRegBD(v) > 0) {
            visitanteDAO.atualizarRegList(v);
            return true;
        } else {
            return false;
        }
    }

    public Boolean excluirReg(Visitante v) {
        if (visitaDAO.verVisVisitante(v) == 0) {
            if (visitanteDAO.excluirRegBD(v) > 0) {
                FotoCTR fotoCTR = new FotoCTR();
                fotoCTR.excluirFotoJPG(v.getIdVisitante());
                visitanteDAO.excluirRegList(v);
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

}
