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

    private int id;
    private String cpf;
    private String rg;
    private String nome;
    private ComplVisitante complVisitante;

    public Visitante() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return (cpf == null) ? "NULL" : (cpf.trim().length() == 0) ? "NULL" : cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ComplVisitante getComplVisitante() {
        return complVisitante;
    }

    public void setComplVisitante(ComplVisitante complVisitante) {
        this.complVisitante = complVisitante;
    }
    
}
