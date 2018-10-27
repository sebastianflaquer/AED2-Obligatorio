package uy.ort.ob201802;

import uy.ort.ob201802.Retorno.Resultado;

public class Sistema implements ISistema {
    
    private int maxPuntos;
    private int cantPuntos;
    private Double coordX;
    private Double coordY;
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
//    public ABB getListaAfiliado() {
//        return listaAfiliado;
//    }
//    public void setListaAfiliado(ABB listaAfiliado) {
//        this.listaAfiliado = listaAfiliado;
//    }
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
            //this.setListaAfiliado();
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
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno registrarAfiliado(int id, String cedula, String nombre, String email) {
        
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }
        
    //chequea que la cedula tenga el formato correcto
    //boolean okCedula = listaAfiliado.ckCedula(cedula);

    //chequea que el mail tenga un formato correcto
    //boolean okMail = listaAfiliado.ckMail(email);

    //chequea que exite el afiliado
    //Afiliado afiliadoActual = null;
    //listaAfiliado.buscarAfiliado(cedula);


//        if(false){
//            //si ya existe un afiliafo con esa CI registrado
//            return new Retorno(Retorno.Resultado.ERROR_3);
//        }else{
//            //SI LA CEDULA ESTA OK
//            //if(okCedula){
//                //SI EL MAIL ESTA OK
//                //if(okMail){
//                    Afiliado afiliadoActual = new Afiliado(id, cedula, nombre);                    
//                    //listaAfiliado.insertar(id);// .insertar(afiliadoActual);
//                    //liafiliadoActualstaAfiliado.insertar(afiliadoActual);
//                    //ACA VA LA LOGICA PARA CREAR EL AFILIADO
//                    
//                    return new Retorno(Resultado.OK);
//                    
//                //}else{
//                //    return new Retorno(Resultado.ERROR_2);
//                //}
//            //}else{
//            //    return new Retorno(Resultado.ERROR_1);
//            //}
//            //return new Retorno(Resultado.NO_IMPLEMENTADA);
//        }

    @Override
    public Retorno buscarAfiliado(String CI) {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno listarAfiliados() {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno registrarCanalera(String chipid, String CIafiliado, Double coordX, Double coordY) {
        
        //chequea que exite la canalera
        //Canalera canaleraActual = listaCanalera.buscarCanalera(chipid);
        
        //chequea que exite el afiliado
        //Afiliado afiliadoActual = this.buscarAfiliado(CIafiliado);
        
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
