/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.ob201802;
import uy.ort.ob201802.Grafo.NodoGrafo;

/**
 *
 * @author sflaquer
 */
public class Canalera extends NodoGrafo{
    
    private String chipid;
    private String CIafiliado;
    
    ////////////////////////////////
    //CONSTRUCTOR
    ////////////////////////////////
    public Canalera() {
        super();
        this.chipid = null;
        this.CIafiliado = null;
    }
    
    public Canalera(String chipid, String CIafiliado, double coordX, double coordY) {
        super("Canalera", coordX, coordY);
        this.chipid = chipid;
        this.CIafiliado = CIafiliado;
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
    
}
