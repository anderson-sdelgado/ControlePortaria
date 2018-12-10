/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import model.dao.VisitanteDAO;
import model.domain.Visitante;

/**
 *
 * @author anderson
 */
public class VisitanteCTR {

    private List<Visitante> visitantesTabela;
    private VisitanteDAO visitanteDAO;

    public VisitanteCTR() {
        
        visitanteDAO = new VisitanteDAO();
        visitantesTabela = visitanteDAO.visitantesTabela();
        
    }

    public List<Visitante> getVisitantesTabela() {
        return visitantesTabela;
    }
    
    
    
}
