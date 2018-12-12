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

    private VisitanteDAO visitanteDAO;

    public VisitanteCTR() {
        visitanteDAO = new VisitanteDAO();
    }

    public List<Visitante> getVisitantesTabela() {
        return visitanteDAO.getVisitantesTabela();
    }
    
    public Visitante getPesqVisitante(Integer valor) {
        return visitanteDAO.pesqVisitante(valor);
    }
    
    public Visitante ultimoReg(){
        return visitanteDAO.ultimoReg();
    }
    
    public Boolean inserirReg(Visitante v){
        return visitanteDAO.inserirReg(v) != 0;
    }
    
    public Boolean atualizarReg(Visitante v){
        return visitanteDAO.atualizarReg(v) != 0;
    }
    
}
