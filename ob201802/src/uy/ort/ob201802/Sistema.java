package uy.ort.ob201802;

import java.awt.Desktop;
import java.net.URL;
import uy.ort.ob201802.Grafo.Grafo;
import uy.ort.ob201802.Grafo.NodoGrafo;
import uy.ort.ob201802.Grafo.NodoRed;
import uy.ort.ob201802.Grafo.NodoServidor;
import uy.ort.ob201802.Retorno.Resultado;

public class Sistema implements ISistema {
    
    private int vMaxPuntos;
    private int vCantPuntos;
    public Double vCoordX;
    public Double vCoordY;
    private ABBAfiliados vAbbAfiliados;
    private Grafo vGrafo;
    

    // GETERS Y SETTERS
    public int getMaxPuntos() {
        return vMaxPuntos;
    }
    public void setMaxPuntos(int maxPuntos) {
        this.vMaxPuntos = maxPuntos;
    }
    public int getCantPuntos() {
        return vCantPuntos;
    }
    public void setCantPuntos(int cantPuntos) {
        this.vCantPuntos = cantPuntos;
    }
    public Double getCoordX() {
        return vCoordX;
    }
    public void setCoordX(Double coordX) {
        this.vCoordX = coordX;
    }
    public Double getCoordY() {
        return vCoordY;
    }
    public void setCoordY(Double coordY) {
        this.vCoordY = coordY;
    }
    public ABBAfiliados getAbbAfiliados() {
        return vAbbAfiliados;
    }
    public void setAbbAfiliados(ABBAfiliados AbbAfiliados) {
        this.vAbbAfiliados = AbbAfiliados;
    }
    public Grafo getGrafo() {
        return vGrafo;
    }
    public void setGrafo(Grafo Grafo) {
        this.vGrafo = Grafo;
    }
    
    ///////////////////////////////////////////////////////////
    //METODOS                                                //
    ///////////////////////////////////////////////////////////    

    //DONE
    @Override
    public Retorno inicializarSistema (int maxPuntos, Double coordX, Double coordY) {
        //SI ES MAYOR A 0
        if(maxPuntos > 0){
            this.setMaxPuntos(maxPuntos);
            this.setCoordX(coordX);
            this.setCoordY(coordY);
             //ADD NODO SISTEMA
            NodoServidor NodoServidorActual = new NodoServidor("Sistema", coordX, coordY);
            this.setCantPuntos(vCantPuntos + 1);
            this.setGrafo(new Grafo(maxPuntos));
            this.vGrafo.agregarVertice(NodoServidorActual);
            this.setAbbAfiliados(new ABBAfiliados());
            //this.setListaCanalera();
            return new Retorno(Retorno.Resultado.OK);
        }
        return new Retorno(Resultado.ERROR_1);
    }
    
    //DONE
    @Override
    public Retorno destruirSistema() {
        this.vMaxPuntos = 0;
        this.vCantPuntos = 0;
        this.vCoordX = null;
        this.vCoordY = null;
        this.setGrafo(null);
        this.setAbbAfiliados(null);
        return new Retorno(Retorno.Resultado.OK);
    }

    //REGISTRAR AFILIADO
    //DONE
    @Override
    public Retorno registrarAfiliado(String cedula, String nombre, String email) {
        
        busquedaAfiliado busquedaAfiliado = this.vAbbAfiliados.buscarPorCi(cedula);
        
        //SI EL AFILIADO YA EXISTE
        if(busquedaAfiliado != null){
            return new Retorno(Resultado.ERROR_3);
        }else{
            //SI LA CI ES VALIDA
            if(this.vAbbAfiliados.esCIValida(cedula)){
                //SI EL MAIL ES VALIDO
                if(this.vAbbAfiliados.esMailValido(email)){
                    
                    Afiliado AfiliadoActual = new Afiliado(cedula, nombre, email);
                    this.vAbbAfiliados.insertar(AfiliadoActual);
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
    //DONE
    @Override
    public Retorno buscarAfiliado(String CI) {
        
        String datosAfiliado = "";
        int cantElemRec = 0;
        
        //SI LA CEDULA ES VALIDA
        if(this.vAbbAfiliados.esCIValida(CI)){
            
            //BUSCA AL AFILIADO
            busquedaAfiliado busquedaAfiliadoActual = this.vAbbAfiliados.buscarPorCi(CI);
            if(busquedaAfiliadoActual!=null){
                INodoTadAbb<Afiliado> NodoAfiliado =  busquedaAfiliadoActual.getAfiliado();
  
                //SI EXISTE
                datosAfiliado = NodoAfiliado.obtener().getCI()+";"+ NodoAfiliado.obtener().getNombre()+";"+NodoAfiliado.obtener().getEmail();
                cantElemRec = busquedaAfiliadoActual.getCantidad();

                //FALTA PASAR LA CANTIDAD DE NODOS POR LOS CUALES PASO.
                return new Retorno(Resultado.OK, datosAfiliado, cantElemRec);
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
    //DONE
    @Override
    public Retorno listarAfiliados() {
        String datosAfiliado = this.vAbbAfiliados.listarAscendente();
        return new Retorno(Resultado.OK, datosAfiliado, 0);
    }    
    
    //REGISTRAR CANALERA
    //DONE
    @Override
    public Retorno registrarCanalera(String chipid, String CIafiliado, Double coordX, Double coordY) {
        
        //si la cantidad es menor que el maximo
        if(vCantPuntos < vMaxPuntos){
            
            Canalera canaleraActual = new Canalera(chipid, CIafiliado, coordX, coordY);
            
            //si ya existe un punto en esas cordenadas
            boolean existe = this.vGrafo.existeVertice(canaleraActual);
            if(!existe){                
                //chequea que exite el afiliado
                busquedaAfiliado busquedaAfiliado = this.vAbbAfiliados.buscarPorCi(CIafiliado);
              
                //SI EXISTE EL AFILIADO ACTUAL
                if(busquedaAfiliado != null){
                    this.vGrafo.agregarVertice(canaleraActual);
                    //registrar la canalera
                    vCantPuntos = vCantPuntos + 1;
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
    //DONE
    @Override
    public Retorno registrarNodo(String nodoid, Double coordX, Double coordY) {
        
        //si la cantidad es menor que el maximo
        if(vCantPuntos < vMaxPuntos){
            
            NodoRed nodoRedActual = new NodoRed(nodoid, coordX, coordY);
            
            //si ya existe un punto en esas cordenadas
            boolean existe = this.vGrafo.existeVertice(nodoRedActual);
            if(!existe){
               
                this.vGrafo.agregarVertice(nodoRedActual);
                //registrar la canalera
                vCantPuntos = vCantPuntos + 1;
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
    //DONE
    @Override
    public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int perdidaCalidad) {
        
        //1. Si peso es MAYOR o igual a 0.
        if(perdidaCalidad > 0){
            
            NodoGrafo nodoOrigen = this.vGrafo.existeVerticeCordenadas(coordXi, coordYi);
            NodoGrafo nodoDestino = this.vGrafo.existeVerticeCordenadas(coordXf, coordYf);
            
            if(nodoOrigen != null && nodoDestino != null){
                
                boolean existeArista = this.vGrafo.existeArista(nodoOrigen, nodoDestino);
                
                //3. Si ya existe un tramo registrado desde coordi a coordf.
                if(!existeArista){
                    if( ((nodoOrigen.getTipo() == "Canalera") || (nodoDestino.getTipo() == "Canalera")) && (nodoOrigen.getTipo() == "Servidor") || (nodoDestino.getTipo() == "Servidor")){             
                        return new Retorno(Resultado.ERROR_4);
                    }else{
                        //CREO EL TRAMO
                        this.vGrafo.agregarArista(nodoOrigen, nodoDestino, perdidaCalidad);
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
    //DONE
    @Override
    public Retorno modificarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int nuevoValorPerdidaCalidad) {
        if(nuevoValorPerdidaCalidad >= 0){
            
            NodoGrafo nodoOrigen = this.vGrafo.existeVerticeCordenadas(coordXi, coordYi);
            NodoGrafo nodoDestino = this.vGrafo.existeVerticeCordenadas(coordXf, coordYf);
            
            if(nodoOrigen != null && nodoDestino != null){
                
                boolean existeArista = this.vGrafo.existeArista(nodoOrigen, nodoDestino);
                if(existeArista){
                    this.vGrafo.modificarPesoArista(nodoOrigen, nodoDestino, nuevoValorPerdidaCalidad);
                    return new Retorno(Resultado.OK);
                }else{
                    return new Retorno(Resultado.ERROR_2);
                }
            }else{
                return new Retorno(Resultado.ERROR_2);
            }
        }else{
            return new Retorno(Resultado.ERROR_1);
        }
    }
    
    
    //CALIDAD CANALERA
    //DONE
    @Override
    public Retorno calidadCanalera(Double coordX, Double coordY) {
        
        int perdidaCalidad = -1;
        NodoGrafo nodoCanalera = this.vGrafo.existeVerticeCordenadas(coordX, coordY);

        if(nodoCanalera!=null){
            
            NodoGrafo nodoServidor = this.vGrafo.getNodoServidor();
            //NodoGrafo nodoServidor = this.vGrafo.existeVerticeCordenadas(this.vCoordX, this.vCoordY);
            perdidaCalidad = this.vGrafo.dijkstra(nodoServidor,nodoCanalera);
            
            if(perdidaCalidad >= 0){   
                return new Retorno(Resultado.OK, "", perdidaCalidad);
            }else{
                return new Retorno(Resultado.ERROR_2);
            }
        }else{
            return new Retorno(Resultado.ERROR_1);
        }       
        //return new Retorno(Resultado.NO_IMPLEMENTADA);
    }
    
    //NODOSCRITICOS
    //DONE
    @Override
    public Retorno nodosCriticos() {
        
        NodoGrafo[] verticesAux = vGrafo.getVertices();
        int canFull = vGrafo.ejecutaDFS();
        int canAux = 0;
        String retorno = "";

        //recorro la lista de vertices
        for(int i = 0; i < verticesAux.length ; i++){

            // ARMA EL STRING CON EL ID DEL NODO
            if(verticesAux[i] != null){
                if(verticesAux[i] instanceof NodoRed){
                    String retAux = "";
                    NodoGrafo puntoActual = verticesAux[i];                    
                    
                    //ARMA EL STRING CON LAS CORDENADAS
                    retAux += puntoActual.getCoordX() + ";";
                    retAux += puntoActual.getCoordY();
                    
                    retAux += "|";

                    //copia el punto para tenerlo al borrarlo
                    NodoGrafo NodoGrafoAux = new NodoGrafo(verticesAux[i].getTipo(), verticesAux[i].getCoordX(), verticesAux[i].getCoordY());
                    //END

                    //BORRA EL VERTICE
                    vGrafo.borrarVertice(verticesAux[i]);                    
                    //END

                    //me fijo si tiene 2 false mas que cantFull
                    canAux = vGrafo.ejecutaDFS();
                    if( canAux > (canFull + 1) ){
                        retorno += retAux;
                    }

                    vGrafo.agregarVertice(NodoGrafoAux);//borrarVertice(verAux[i]);
                    //int canDespues = vGrafo.ejecutaDFS();
                }
            }
        }
        
        //Corta la cadena para eliminar la ultima barra
        String sSubCadena = retorno.substring(0,retorno.length()-1);
        
        return new Retorno(Resultado.OK, sSubCadena, 0);
    }
    
    
    //DIBUJAR MAPA
    //DONE
    @Override
    public Retorno dibujarMapa() {
        
        String url = mimapa.getURLMapaPuntos(this.vGrafo);
        
        try {
            Desktop.getDesktop().browse(new URL(url).toURI());
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        }
         return new Retorno(Resultado.OK);
    }
	
    
    //DESHABILITAR
    @Override
    public Retorno deshabilitarNodo(double coordX, double coordY){
        
        NodoGrafo nodoActual = this.vGrafo.existeVerticeCordenadas(coordX, coordY);
        
        //SI YA EXISTE UN PUNTO EN LAS CORDENADAS
        if(nodoActual!=null){
            //SI EL NODO ES DE TIPO NODO RED
            if("NodoRed".equals(nodoActual.getTipo())){
                
                //boolean deshabilitado = vGrafo.estadoNodo(nodoActual);
                boolean estado = vGrafo.estadoNodo(nodoActual);
                
                if(estado != false){                    
                    vGrafo.deshabilitarNogoGrafo(nodoActual);
                    return new Retorno(Resultado.OK);
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
}
