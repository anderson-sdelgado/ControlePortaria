/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

/**
 *
 * @author anderson
 */
public class Visitado {
    
    private int idVisitado;
    private String nomeVisitado;
    private String localVisitado;

    public Visitado() {
    }

    public int getIdVisitado() {
        return idVisitado;
    }

    public void setIdVisitado(int idVisitado) {
        this.idVisitado = idVisitado;
    }

    public String getNomeVisitado() {
        return nomeVisitado;
    }

    public void setNomeVisitado(String nomeVisitado) {
        this.nomeVisitado = nomeVisitado;
    }

    public String getLocalVisitado() {
        return localVisitado;
    }

    public void setLocalVisitado(String localVisitado) {
        this.localVisitado = localVisitado;
    }
    
}
