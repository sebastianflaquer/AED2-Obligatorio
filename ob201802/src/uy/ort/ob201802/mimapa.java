/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.ob201802;

import uy.ort.ob201802.Grafo.Grafo;
import uy.ort.ob201802.Grafo.NodoGrafo;
import uy.ort.ob201802.Grafo.NodoRed;

/**
 *
 * @author sflaquer
 */
class mimapa {

    static String getURLMapaPuntos(Grafo Grafo) {
        
        //int contador = 0;
        String Marker = "";
        String Tipo;
        NodoGrafo[] vertices = Grafo.getVertices();
                
        for(int i = 0; i < Grafo.getTope(); i++){
            if(vertices[i]!=null){
                
                Double cordX = vertices[i].getCoordX();
                Double cordY = vertices[i].getCoordY();
                NodoGrafo nodoActual = Grafo.existeVerticeCordenadas(cordX, cordY);
                
                //SI ES CANALERA
                if(nodoActual.getDato() instanceof Canalera){
                    Marker += "markers=color:blue";
                    Tipo = "C";
                }else if(nodoActual.getDato() instanceof NodoRed){                    
                    Marker += "markers=color:red";
                    Tipo = "N";
                }else{
                    Marker += "markers=color:green";
                    Tipo = "S";
                }
                
                //contador++;
                Marker += "%7Clabel:"+Tipo+"%7C"+nodoActual.getCoordX()+","+nodoActual.getCoordY()+"&";
            }
        }

        String UrlIni = "http://maps.googleapis.com/maps/api/staticmap?center=Montevideo,Uruguay&zoom=13&size=1200x600&maptype=roadmap&";
        String UrlFin = "sensor=false&key=AIzaSyC2kHGtzaC3OOyc7Wi1LMBcEwM9btRZLqw";
        String urlCompleta = UrlIni + Marker + UrlFin;
        
        return urlCompleta;
        
    }

}
