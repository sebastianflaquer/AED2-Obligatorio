package oblogatorioaed2;

import oblogatorioaed2.Retorno.Resultado;

public class Sistema implements ISistema {
    
    private int maxPuntos;
    private Double coordX;
    private Double coordY;

    // GETERS Y SETTERS
    public int getMaxPuntos() {
        return maxPuntos;
    }

    public void setMaxPuntos(int maxPuntos) {
        this.maxPuntos = maxPuntos;
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
    
    ///////////////////////////////////////////////////////////
    //METODOS                                                //
    ///////////////////////////////////////////////////////////    

    // REVISAR
    @Override
    public Retorno inicializarSistema (int maxPuntos, Double coordX, Double coordY) {
        if(maxPuntos <= 0){
            this.setMaxPuntos(maxPuntos);
            this.setCoordX(coordX);
            this.setCoordY(coordY);
            
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
    
    // NO_IMPLEMENTADA
    @Override
    public Retorno registrarAfiliado(String cedula, String nombre, String email) {
            return new Retorno(Resultado.NO_IMPLEMENTADA);
    }
    
    // NO_IMPLEMENTADA
    @Override
    public Retorno buscarAfiliado(String CI) {
            return new Retorno(Resultado.NO_IMPLEMENTADA);
    }
    
    // NO_IMPLEMENTADA
    @Override
    public Retorno listarAfiliados() {
            return new Retorno(Resultado.NO_IMPLEMENTADA);
    }
    
    // NO_IMPLEMENTADA
    @Override
    public Retorno registrarCanalera(String chipid, String CIafiliado, Double coordX, Double coordY) {
            return new Retorno(Resultado.NO_IMPLEMENTADA);
    }
    
    // NO_IMPLEMENTADA
    @Override
    public Retorno registrarNodo(String nodoid, Double coordX, Double coordY) {
            return new Retorno(Resultado.NO_IMPLEMENTADA);
    }
    
    // NO_IMPLEMENTADA
    @Override
    public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int perdidaCalidad) {
            return new Retorno(Resultado.NO_IMPLEMENTADA);
    }
    
    // NO_IMPLEMENTADA
    @Override
    public Retorno modificarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf,
                    int nuevoValorPerdidaCalidad) {
            return new Retorno(Resultado.NO_IMPLEMENTADA);
    }
    
    // NO_IMPLEMENTADA
    @Override
    public Retorno calidadCanalera(Double coordX, Double coordY) {
            return new Retorno(Resultado.NO_IMPLEMENTADA);
    }
    
    // NO_IMPLEMENTADA
    @Override
    public Retorno nodosCriticos() {
            return new Retorno(Resultado.NO_IMPLEMENTADA);
    }
    
    // NO_IMPLEMENTADA
    @Override
    public Retorno dibujarMapa() {
            return new Retorno(Resultado.NO_IMPLEMENTADA);
    }
	
}
