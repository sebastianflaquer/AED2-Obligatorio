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
public class NodoTadAbb<T> implements INodoTadAbb<T> {
    
    T dato;
    INodoTadAbb<T> izq;
    INodoTadAbb<T> der;
    
    public NodoTadAbb(T dato){
        this.dato = dato;
    }
    

    @Override
    public T obtener() {
        return dato;
    }

    @Override
    public INodoTadAbb<T> izq() {
        return izq;
    }

    @Override
    public INodoTadAbb<T> der() {
        return der;
    }

    @Override
    public void enlIzq(INodoTadAbb<T> x) {
        izq = x;
    }

    @Override
    public void enlDer(INodoTadAbb<T> x) {
        der = x;
    }

    @Override
    public void modificar(T x) {
        dato = x;
    }
    
    
}
