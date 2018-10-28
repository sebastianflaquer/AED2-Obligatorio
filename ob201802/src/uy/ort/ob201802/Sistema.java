package uy.ort.ob201802;

import uy.ort.ob201802.Retorno.Resultado;

public class Sistema implements ISistema {
    
    private int maxPuntos;
    private int cantPuntos;
    private Double coordX;
    private Double coordY;
    private ABBAfiliados AbbAfiliados;

    
//    private ABB listaAfiliado;
//    private ABB listaCanalera;
    private int[][] matrizVertices;

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
//    public ABB getListaCanalera() {
//        return listaCanalera;
//    }
//    public void setListaCanalera(ABB listaCanalera) {
//        this.listaCanalera = listaCanalera;
//    }
    
    public int[][] getMatrizVertices() {
        return matrizVertices;
    }
    public void setMatrizVertices(int[][] matrizVertices) {
        this.matrizVertices = matrizVertices;
    }
    
    ///////////////////////////////////////////////////////////
    //METODOS                                                //
    ///////////////////////////////////////////////////////////    

    // REVISAR
    @Override
    public Retorno inicializarSistema (int maxPuntos, Double coordX, Double coordY) {
        //SI ES MAYOR A 0
        if(maxPuntos > 0){
            this.setMaxPuntos(maxPuntos);
            this.setCoordX(coordX);
            this.setCoordY(coordY);
            this.setAbbAfiliados(new ABBAfiliados());
            //this.setListaCanalera();
            return new Retorno(Retorno.Resultado.OK);
        }
        return new Retorno(Resultado.ERROR_1);
    }
    
    // REVISAR
    @Override
    public Retorno destruirSistema() {
        this.setMaxPuntos(0);
        this.setCoordX(null);
        this.setCoordY(null);
        this.setAbbAfiliados(null);
        return new Retorno(Retorno.Resultado.OK);
    }

    //REGISTRAR AFILIADO
    // DONE - REVISAR
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
            INodoTadAbb<Afiliado> NodoAfiliado =  busquedaAfiliadoActual.getAfiliado();
            
            //SI EXISTE
            if(NodoAfiliado != null){
                datosAfiliado = NodoAfiliado.obtener().getCI()+"; "+ NodoAfiliado.obtener().getNombre()+"; "+NodoAfiliado.obtener().getEmail()+";";
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
            return new Retorno(Resultado.ERROR_1, "hola", cantElemRec);
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
        

    
    
    
    
    
    
    
    @Override
    public Retorno registrarCanalera(String chipid, String CIafiliado, Double coordX, Double coordY) {
        
        //chequea que exite la canalera
        //Canalera canaleraActual = listaCanalera.buscarCanalera(chipid);
        
        //chequea que exite el afiliado
        busquedaAfiliado busquedaAfiliado = this.AbbAfiliados.buscarPorCi(CIafiliado);
        //SI EXISTE EL AFILIADO ACTUAL
        if(busquedaAfiliado != null){
        
        }
        
        
        
        //si la cantidad es menor que el maximo
        if(cantPuntos < maxPuntos){
                
        }else{//si la cantidad es mayor o igual que el maximo
            return new Retorno(Resultado.ERROR_1);
        }
        
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno registrarNodo(String nodoid, Double coordX, Double coordY) {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int perdidaCalidad) {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno modificarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int nuevoValorPerdidaCalidad) {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno calidadCanalera(Double coordX, Double coordY) {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno nodosCriticos() {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno dibujarMapa() {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }	
	
	
}
