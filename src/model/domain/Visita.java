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
    private Visitante visitante;
    private Visitado visitado;
    private int matricRecep;
    private String dataHoraEntrada;
    private String dataHoraSaida;

    public Visita() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(String dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public String getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(String dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }
    
}
