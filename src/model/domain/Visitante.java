/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author anderson
 */
public class Visitante {

    private int idVisitante;
    private String cpfVisitante;
    private String rgVisitante;
    private String nomeVisitante;
    private ComplVisitante complVisitante;
    private int tipoVisitante;

    public Visitante() {
    }

    public int getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(int idVisitante) {
        this.idVisitante = idVisitante;
    }

    public String getCpfVisitante() {
        return (cpfVisitante == null) ? "NULL" : (cpfVisitante.trim().length() == 0) ? "NULL" : cpfVisitante;
    }

    public void setCpfVisitante(String cpfVisitante) {
        this.cpfVisitante = cpfVisitante;
    }

    public String getRgVisitante() {
        return rgVisitante;
    }

    public void setRgVisitante(String rgVisitante) {
        this.rgVisitante = rgVisitante;
    }

    public String getNomeVisitante() {
        return nomeVisitante;
    }

    public void setNomeVisitante(String nomeVisitante) {
        this.nomeVisitante = nomeVisitante;
    }

    public ComplVisitante getComplVisitante() {
        return complVisitante;
    }

    public void setComplVisitante(ComplVisitante complVisitante) {
        this.complVisitante = complVisitante;
    }

    public int getTipoVisitante() {
        return tipoVisitante;
    }

    public void setTipoVisitante(int tipoVisitante) {
        this.tipoVisitante = tipoVisitante;
    }
    
}
