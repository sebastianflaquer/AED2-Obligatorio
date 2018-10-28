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
public class implTadAbb<T> implements TadAbb<T> {
    
    T dato;
    TadAbb<T> izq;
    TadAbb<T> der;
    
    public implTadAbb(T dato){
        this.dato = dato;
    }
    

    @Override
    public T obtener() {
        return dato;
    }

    @Override
    public TadAbb<T> izq() {
        return izq;
    }

    @Override
    public TadAbb<T> der() {
        return der;
    }

    @Override
    public void enlIzq(TadAbb<T> x) {
        izq = x;
    }

    @Override
    public void enlDer(TadAbb<T> x) {
        der = x;
    }

    @Override
    public void modificar(T x) {
        dato = x;
    }
    
    
}
