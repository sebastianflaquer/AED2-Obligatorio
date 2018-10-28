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
public interface TadAbb<T> {
    
    T obtener();
    TadAbb<T> izq();
    TadAbb<T> der();
    void enlIzq(TadAbb<T> x);
    void enlDer(TadAbb<T> x);
    void modificar(T x);
    
    
}
