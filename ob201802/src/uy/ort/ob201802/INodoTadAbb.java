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
public interface INodoTadAbb<T> {
    
    T obtener();
    INodoTadAbb<T> izq();
    INodoTadAbb<T> der();
    void enlIzq(INodoTadAbb<T> x);
    void enlDer(INodoTadAbb<T> x);
    void modificar(T x);
    
    
}
