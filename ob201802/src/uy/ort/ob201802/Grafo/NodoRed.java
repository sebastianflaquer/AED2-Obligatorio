/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.ob201802.Grafo;

/**
 *
 * @author sflaquer
 */
public class NodoRed extends NodoGrafo{
    
    private String nodoid;
    
    ////////////////////////////////
    //CONSTRUCTOR
    ////////////////////////////////
    public NodoRed(String nodoid) {
        super();
        this.nodoid = nodoid;
    }
    
    public NodoRed(String nodoid, double coordX, double coordY) {
        super("NodoRed", coordX, coordY);
        this.nodoid = nodoid;
    }
    
    ////////////////////////////////
    //GETTER AND SETTER
    ////////////////////////////////
    public String getNodoid() {
        return nodoid;
    }
    public void setNodoid(String nodoid) {
        this.nodoid = nodoid;
    }
    
}
