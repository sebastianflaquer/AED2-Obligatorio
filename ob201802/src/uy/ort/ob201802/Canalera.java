/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.ob201802;

/**
 *
 * @author sflaquer
 */
public class Canalera{
    
    private String chipid;
    private String CIafiliado;
    private Double coordX;
    private Double coordY;
    
    ////////////////////////////////
    //CONSTRUCTOR
    ////////////////////////////////
    public Canalera(String chipid, String CIafiliado, Double coordX, Double coordY) {
        this.chipid = chipid;
        this.CIafiliado = CIafiliado;
        this.coordX = coordX;
        this.coordY = coordY;
    }
    
    ////////////////////////////////
    //GETTER AND SETTER
    ////////////////////////////////
    public String getChipid() {
        return chipid;
    }

    public void setChipid(String chipid) {
        this.chipid = chipid;
    }

    public String getCIafiliado() {
        return CIafiliado;
    }

    public void setCIafiliado(String CIafiliado) {
        this.CIafiliado = CIafiliado;
    }

    public Double getCoordX() {
        return coordX;
    }

    public void setCoordX(Double coordX) {
        this.coordX = coordX;
    }

    public Double getCoordY() {
        return coordY;
    }

    public void setCoordY(Double coordY) {
        this.coordY = coordY;
    }
    
}
