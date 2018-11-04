/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.ob201802.Grafo;

public class Arista {

    private boolean existe;
    private int valor;

    public Arista(int valor) {
        this.existe = true;
        this.valor = valor;
    }

    public Arista() {
        // this.existe = false; INNECESARIO
        // this.valor = 0; INNECESARIO
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor + "";
    }
}
