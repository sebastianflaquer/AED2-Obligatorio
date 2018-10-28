/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebatest;

import uy.ort.ob201802.ArbolAfiliados;
import uy.ort.ob201802.Afiliado;
import uy.ort.ob201802.implTadAbb;
import uy.ort.ob201802.TadAbb;

/**
 *
 * @author sflaquer
 */
public class testing {
    
    ArbolAfiliados af;

    public testing(ArbolAfiliados af) {
        this.af = af;
    }
    
    public static void main(String[] args) {
        ArbolAfiliados af = new ArbolAfiliados();
        //Afiliado a1 = new Afiliado(1, "1.517.456-4", "1 Flaquer");
        //Afiliado a2 = new Afiliado(2, "2.517.456-4", "2 Flaquer");
        //Afiliado a3 = new Afiliado(3, "3.517.456-4", "3 Flaquer");

//        af.insertar(a1);
//        af.insertar(a2);
//        af.insertar(a3);
        
        TadAbb<Afiliado> ar = af.getRaiz();
        
        System.out.print("Mostrar Productos");
        
    }
    
}
