package uy.ort.ob201802;

import java.awt.Desktop;
import java.net.URL;
import uy.ort.ob201802.Grafo.Grafo;
import uy.ort.ob201802.Grafo.NodoGrafo;
import uy.ort.ob201802.Grafo.NodoRed;
import uy.ort.ob201802.Grafo.NodoServidor;
import uy.ort.ob201802.Retorno.Resultado;

public class Sistema implements ISistema {
    
    private int maxPuntos;
    private int cantPuntos;
    public Double coordX;
    public Double coordY;
    private ABBAfiliados AbbAfiliados;
    private Grafo Grafo;
    //private int[][] matrizVertices;
    

    // GETERS Y SETTERS
    public int getMaxPuntos() {
        return maxPuntos;
    }
    public void setMaxPuntos(int maxPuntos) {
        this.maxPuntos = maxPuntos;
    }
    public int getCantPuntos() {
        return cantPuntos;
    }
    public void setCantPuntos(int cantPuntos) {
        this.cantPuntos = cantPuntos;
    }
    public Double getCoordX() {
        return coordX;
    }
    public void setCoordX(Double coordX) {
        this.coordX = coordX;
    }
    public Double getCoordY() {
        return coordY;
    }
    public void setCoordY(Double coordY) {
        this.coordY = coordY;
    }
    public ABBAfiliados getAbbAfiliados() {
        return AbbAfiliados;
    }
    public void setAbbAfiliados(ABBAfiliados AbbAfiliados) {
        this.AbbAfiliados = AbbAfiliados;
    }
    public Grafo getGrafo() {
        return Grafo;
    }
    public void setGrafo(Grafo Grafo) {
        this.Grafo = Grafo;
    }
    
    ///////////////////////////////////////////////////////////
    //METODOS                                                //
    ///////////////////////////////////////////////////////////    

    //DONE - REVISAR
    @Override
    public Retorno inicializarSistema (int maxPuntos, Double coordX, Double coordY) {
        //SI ES MAYOR A 0
        if(maxPuntos > 0){
            this.setMaxPuntos(maxPuntos);
            this.setCoordX(coordX);
            this.setCoordY(coordY);
             //ADD NODO SISTEMA
            NodoServidor NodoServidorActual = new NodoServidor("Sistema");
            NodoGrafo nodoActual = new NodoGrafo(NodoServidorActual, coordX, coordY);
            this.setCantPuntos(cantPuntos + 1);
            this.setGrafo(new Grafo(maxPuntos));
            this.Grafo.agregarVertice(nodoActual);
            this.setAbbAfiliados(new ABBAfiliados());
            //this.setListaCanalera();
            return new Retorno(Retorno.Resultado.OK);
        }
        return new Retorno(Resultado.ERROR_1);
    }
    
    //DONE - REVISAR
    @Override
    public Retorno destruirSistema() {
        this.setMaxPuntos(0);
        this.setCoordX(null);
        this.setCoordY(null);
        this.setGrafo(null);
        this.setAbbAfiliados(null);
        return new Retorno(Retorno.Resultado.OK);
    }

    //REGISTRAR AFILIADO
    //DONE - REVISAR
    @Override
    public Retorno registrarAfiliado(String cedula, String nombre, String email) {
        
        busquedaAfiliado busquedaAfiliado = this.AbbAfiliados.buscarPorCi(cedula);
        
        //SI EL AFILIADO YA EXISTE
        if(busquedaAfiliado != null){
            return new Retorno(Resultado.ERROR_3);
        }else{
            //SI LA CI ES VALIDA
            if(this.AbbAfiliados.esCIValida(cedula)){
                //SI EL MAIL ES VALIDO
                if(this.AbbAfiliados.esMailValido(email)){
                    
                    Afiliado AfiliadoActual = new Afiliado(cedula, nombre, email);
                    this.AbbAfiliados.insertar(AfiliadoActual);
                    return new Retorno(Resultado.OK);
                }
                //SI EL MAIL NO ES VALIDO
                else{
                    return new Retorno(Resultado.ERROR_2);
                }
            }
            //SI LA CI NO VALIDA 
            else{
                return new Retorno(Resultado.ERROR_1);
            }            
        }
    }
    
    //BUSCAR AFILIADO
    //DONE - REVISAR
    @Override
    public Retorno buscarAfiliado(String CI) {
        
        String datosAfiliado = "";
        int cantElemRec = 0;
        
        //SI LA CEDULA ES VALIDA
        if(this.AbbAfiliados.esCIValida(CI)){
            
            //BUSCA AL AFILIADO
            busquedaAfiliado busquedaAfiliadoActual = this.AbbAfiliados.buscarPorCi(CI);
            if(busquedaAfiliadoActual!=null){
                INodoTadAbb<Afiliado> NodoAfiliado =  busquedaAfiliadoActual.getAfiliado();
  
                //SI EXISTE
                //if(NodoAfiliado != null){
                    datosAfiliado = NodoAfiliado.obtener().getCI()+";"+ NodoAfiliado.obtener().getNombre()+";"+NodoAfiliado.obtener().getEmail();
                    cantElemRec = busquedaAfiliadoActual.getCantidad();

                    //FALTA PASAR LA CANTIDAD DE NODOS POR LOS CUALES PASO.
                    return new Retorno(Resultado.OK, datosAfiliado, cantElemRec);
                //}
                //SI NO EXISTE EL AFILIADO
//                else{
//                    return new Retorno(Resultado.ERROR_2);
//                }
            }
            //SI NO EXISTE EL AFILIADO
            else{
                return new Retorno(Resultado.ERROR_2);
            }
        }
        //SI LA CI NO VALIDA 
        else{
            return new Retorno(Resultado.ERROR_1);
        }
        
    }

    //LISTAR AFILIADO
    //DONE - REVISAR
    @Override
    public Retorno listarAfiliados() {
        
        String datosAfiliado = this.AbbAfiliados.listarAscendente();
        
        //FALTA PASAR LA CANTIDAD DE NODOS POR LOS CUALES PASO.
        return new Retorno(Resultado.OK, datosAfiliado, 0);
    }    
    
    //REGISTRAR CANALERA
    //DONE - REVISAR
    @Override
    public Retorno registrarCanalera(String chipid, String CIafiliado, Double coordX, Double coordY) {
        
        //si la cantidad es menor que el maximo
        if(cantPuntos < maxPuntos){
            
            Canalera canaleraActual = new Canalera(chipid, CIafiliado, coordX, coordY);
            NodoGrafo nodoActual = new NodoGrafo(canaleraActual, coordX,coordY);
            
            //si ya existe un punto en esas cordenadas
            boolean existe = this.Grafo.existeVertice(nodoActual);
            if(!existe){                
                //chequea que exite el afiliado
                busquedaAfiliado busquedaAfiliado = this.AbbAfiliados.buscarPorCi(CIafiliado);
              
                //SI EXISTE EL AFILIADO ACTUAL
                if(busquedaAfiliado != null){
                    this.Grafo.agregarVertice(nodoActual);
                    //registrar la canalera
                    cantPuntos = cantPuntos + 1;
                    return new Retorno(Resultado.OK);
                }else{
                    return new Retorno(Resultado.ERROR_3);
                }
            }else{
                return new Retorno(Resultado.ERROR_2);
            }
        }
        //si la cantidad es mayor o igual que el maximo
        else{
            return new Retorno(Resultado.ERROR_1);
        }   
    }
    
    //REGISTRAR NODO
    //DONE - REVISAR
    @Override
    public Retorno registrarNodo(String nodoid, Double coordX, Double coordY) {
        
        //si la cantidad es menor que el maximo
        if(cantPuntos < maxPuntos){
            
            NodoRed nodoRedActual = new NodoRed(nodoid);
            NodoGrafo nodoActual = new NodoGrafo(nodoRedActual, coordX,coordY);
            
            //si ya existe un punto en esas cordenadas
            boolean existe = this.Grafo.existeVertice(nodoActual);
            if(!existe){
               
                this.Grafo.agregarVertice(nodoActual);
                //registrar la canalera
                cantPuntos = cantPuntos + 1;
                return new Retorno(Resultado.OK);
                
            }else{
                return new Retorno(Resultado.ERROR_2);
            }
        }
        //si la cantidad es mayor o igual que el maximo
        else{
            return new Retorno(Resultado.ERROR_1);
        }
        
    }
    
    //REGISTRAR TRAMO
    //DONE - REVISAR
    @Override
    public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int perdidaCalidad) {
        
        //1. Si peso es MAYOR o igual a 0.
        if(perdidaCalidad > 0){
            
            NodoGrafo nodoOrigen = this.Grafo.existeVerticeCordenadas(coordXi, coordYi);
            NodoGrafo nodoDestino = this.Grafo.existeVerticeCordenadas(coordXf, coordYf);
            
            if(nodoOrigen != null && nodoDestino != null){
                
                boolean existeArista = this.Grafo.existeArista(nodoOrigen, nodoDestino);
                
                //3. Si ya existe un tramo registrado desde coordi a coordf.
                if(!existeArista){
                    
                    if( ((nodoOrigen.getDato() instanceof Canalera) || (nodoDestino.getDato() instanceof Canalera)) && (nodoOrigen.getDato() instanceof NodoServidor) || (nodoDestino.getDato() instanceof NodoServidor)){             
                        return new Retorno(Resultado.ERROR_4);
                    }else{
                        
                        //CREO EL TRAMO
                        this.Grafo.agregarArista(nodoOrigen, nodoDestino, perdidaCalidad);
                        return new Retorno(Resultado.OK);
                        
                    }
                }else{
                    return new Retorno(Resultado.ERROR_3);
                }
            }else{
                return new Retorno(Resultado.ERROR_2);
            }
        }else{
            return new Retorno(Resultado.ERROR_1);
        }
    }
    
    //MODIFICAR TRAMO
    //DONE - REVISAR
    @Override
    public Retorno modificarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int nuevoValorPerdidaCalidad) {
        if(nuevoValorPerdidaCalidad >= 0){
            
            NodoGrafo nodoOrigen = this.Grafo.existeVerticeCordenadas(coordXi, coordYi);
            NodoGrafo nodoDestino = this.Grafo.existeVerticeCordenadas(coordXf, coordYf);
            boolean existeArista = this.Grafo.existeArista(nodoOrigen, nodoDestino);
            
            if(existeArista){
                this.Grafo.modificarPesoArista(nodoOrigen, nodoDestino, nuevoValorPerdidaCalidad);
                return new Retorno(Resultado.OK);
            }else{
                return new Retorno(Resultado.ERROR_2);
            }
            
        }else{
            return new Retorno(Resultado.ERROR_1);
        }
    }
    
    //DIBUJAR MAPA
    //
    @Override
    public Retorno dibujarMapa() {
        
        String url = mimapa.getURLMapaPuntos(this.Grafo);
        
        try {
            Desktop.getDesktop().browse(new URL(url).toURI());
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        }
         return new Retorno(Resultado.OK);
    }	
    
    //CALIDAD CANALERA
    //
    @Override
    public Retorno calidadCanalera(Double coordX, Double coordY) {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }
    
    //NODOSCRITICOS
    //
    @Override
    public Retorno nodosCriticos() {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }
    
    
	
	
}
