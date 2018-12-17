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
    
    private int id;
    private int idVisitante;
    private String empresa;
    private String telFixo;
    private String celular;
    private String modeloVeic;
    private String placaVeic;

    public ComplVisitante() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(String telFixo) {
        this.telFixo = telFixo;
    }

    public String getModeloVeic() {
        return modeloVeic;
    }

    public void setModeloVeic(String modeloVeic) {
        this.modeloVeic = modeloVeic;
    }

    public String getPlacaVeic() {
        return placaVeic;
    }

    public void setPlacaVeic(String placaVeic) {
        this.placaVeic = placaVeic;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(int idVisitante) {
        this.idVisitante = idVisitante;
    }
    
}
