/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.dao.FuncDAO;
import model.domain.Func;

/**
 *
 * @author anderson
 */
public class RecepCTR {

    private final FuncDAO funcDAO;
    
    public RecepCTR() {
        funcDAO = new FuncDAO();
    }
    
    public Func getVerRecep(Func func) {
        return funcDAO.verFuncRecep(func);
    }
    
}
