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
class busquedaAfiliado {
    
    private INodoTadAbb<Afiliado> Afiliado;
    private int cantidad;

    busquedaAfiliado(INodoTadAbb<Afiliado> raiz, int i) {
        this.Afiliado = raiz;
        this.cantidad = i;
    }

    public INodoTadAbb<Afiliado> getAfiliado() {
        return Afiliado;
    }

    public void setAfiliado(INodoTadAbb<Afiliado> Afiliado) {
        this.Afiliado = Afiliado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
}
