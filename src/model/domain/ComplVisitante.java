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
public class ComplVisitante {
    
    private int idVisitante;
    private EmpresaVisitante empresaVisitante;
    private String telFixoVisitante;
    private String celularVisitante;
    private String modeloVeicVisitante;
    private String placaVeicVisitante;

    public ComplVisitante() {
    }

    public int getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(int idVisitante) {
        this.idVisitante = idVisitante;
    }

    public EmpresaVisitante getEmpresaVisitante() {
        return empresaVisitante;
    }

    public void setEmpresaVisitante(EmpresaVisitante empresaVisitante) {
        this.empresaVisitante = empresaVisitante;
    }

    public String getTelFixoVisitante() {
        return telFixoVisitante;
    }

    public void setTelFixoVisitante(String telFixoVisitante) {
        this.telFixoVisitante = telFixoVisitante;
    }

    public String getModeloVeicVisitante() {
        return modeloVeicVisitante;
    }

    public void setModeloVeicVisitante(String modeloVeicVisitante) {
        this.modeloVeicVisitante = modeloVeicVisitante;
    }

    public String getPlacaVeicVisitante() {
        return placaVeicVisitante;
    }

    public void setPlacaVeicVisitante(String placaVeicVisitante) {
        this.placaVeicVisitante = placaVeicVisitante;
    }

    public String getCelularVisitante() {
        return celularVisitante;
    }

    public void setCelularVisitante(String celularVisitante) {
        this.celularVisitante = celularVisitante;
    }
    
}
