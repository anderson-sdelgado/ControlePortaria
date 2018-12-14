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
public class Visita {
    
    private int id;
    private int idVisitante;
    private int idCompVisitante;
    private int idVisitado;
    private int matricRecep;

    public Visita() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(int idVisitante) {
        this.idVisitante = idVisitante;
    }

    public int getIdCompVisitante() {
        return idCompVisitante;
    }

    public void setIdCompVisitante(int idCompVisitante) {
        this.idCompVisitante = idCompVisitante;
    }

    public int getIdVisitado() {
        return idVisitado;
    }

    public void setIdVisitado(int idVisitado) {
        this.idVisitado = idVisitado;
    }

    public int getMatricRecep() {
        return matricRecep;
    }

    public void setMatricRecep(int matricRecep) {
        this.matricRecep = matricRecep;
    }
    
}
