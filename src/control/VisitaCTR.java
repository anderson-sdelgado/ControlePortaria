/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import model.dao.ComplVisitanteDAO;
import model.dao.VisitaDAO;
import model.domain.ComplVisitante;
import model.domain.Visita;

/**
 *
 * @author anderson
 */
public class VisitaCTR {

    private final ComplVisitanteDAO complVisitanteDAO;
    private final VisitaDAO visitaDAO;

    public VisitaCTR() {
        complVisitanteDAO = new ComplVisitanteDAO();
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

}
