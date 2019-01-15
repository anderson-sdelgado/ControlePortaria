/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import model.dao.VisitaDAO;
import model.dao.VisitadoDAO;
import model.domain.Visitado;

/**
 *
 * @author anderson
 */
public class VisitadoCTR {

    private final VisitadoDAO visitadoDAO;
    private final VisitaDAO visitaDAO;

    public VisitadoCTR() {
        visitadoDAO = new VisitadoDAO();
        visitaDAO = new VisitaDAO();
    }

    public List<Visitado> getVisitadoList() {
        return visitadoDAO.getVisitadoList();
    }

    public Visitado getPesqVisitado(Integer valor) {
        return visitadoDAO.pesqVisitado(valor);
    }

    public Visitado ultimoReg() {
        return visitadoDAO.ultimoReg();
    }

    public Boolean inserirReg(Visitado v) {
        if (visitadoDAO.inserirRegBD(v) > 0) {
            visitadoDAO.inserirRegList(v);
            return true;
        } else {
            return false;
        }
    }

    public Boolean atualizarReg(Visitado v) {
        if (visitadoDAO.atualizarRegBD(v) > 0) {
            visitadoDAO.atualizarRegList(v);
            return true;
        } else {
            return false;
        }
    }

    public Boolean excluirReg(Visitado v) {
        if (visitaDAO.verVisVisitado(v) > 0) {
            if (visitadoDAO.excluirRegBD(v) > 0) {
                visitadoDAO.excluirRegList(v);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Visitado getVisitado(int pos) {
        if (pos < 0) {
            Visitado visitado = new Visitado();
            visitado.setIdVisitado(0);
            return visitado;
        } else {
            return visitadoDAO.getVisitado(pos);
        }
    }

}
