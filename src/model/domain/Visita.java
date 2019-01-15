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
    
    private int idVisita;
    private Visitante visitante;
    private Visitado visitado;
    private int matricRecep;
    private String dataHoraEntradaVisita;
    private String dataHoraSaidaVisita;

    public Visita() {
    }

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public int getMatricRecep() {
        return matricRecep;
    }

    public void setMatricRecep(int matricRecep) {
        this.matricRecep = matricRecep;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }

    public Visitado getVisitado() {
        return visitado;
    }

    public void setVisitado(Visitado visitado) {
        this.visitado = visitado;
    }

    public String getDataHoraEntradaVisita() {
        return dataHoraEntradaVisita;
    }

    public void setDataHoraEntradaVisita(String dataHoraEntradaVisita) {
        this.dataHoraEntradaVisita = dataHoraEntradaVisita;
    }

    public String getDataHoraSaidaVisita() {
        return dataHoraSaidaVisita;
    }

    public void setDataHoraSaidaVisita(String dataHoraSaidaVisita) {
        this.dataHoraSaidaVisita = dataHoraSaidaVisita;
    }
    
}