/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.dao.ComplVisitanteDAO;
import model.dao.VisitaDAO;
import model.domain.ComplVisitante;

/**
 *
 * @author anderson
 */
public class VisitaCTR {

    private ComplVisitanteDAO complVisitanteDAO;
    private VisitaDAO visitaDAO;
    
    public VisitaCTR() {
        complVisitanteDAO = new ComplVisitanteDAO();
        visitaDAO = new VisitaDAO();
    }
    
    public ComplVisitante getComplVisitante(int idVisitante){
        return complVisitanteDAO.getComplVisitanteBD(idVisitante);
    }
    
}
