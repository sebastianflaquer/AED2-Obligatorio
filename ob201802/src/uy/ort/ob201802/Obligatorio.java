

package uy.ort.ob201802;

import javax.swing.JOptionPane;


public class Obligatorio {

    public static void main(String[] args) {
        // TODO code application logic here
        
        Sistema s = new Sistema();
        Prueba p = new Prueba();
        
        //Sistema : -34.897518, -56.164655
        s.inicializarSistema(7, -34.897518, -56.164655);
        
        prueba1(s,p);
        
    }
    
    //PRUEBA 1
    static void prueba1(Sistema s, Prueba p){
        
        ////////////////////////////
        // PUNTOS                 //
        ////////////////////////////
        Double PuntoSx = -34.897518;
        Double PuntoSy = -56.164655;
        
        Double PuntoAx = -34.886598;
        Double PuntoAy = -56.136361;
        
        Double PuntoBx = -34.907627;
        Double PuntoBy = -56.155776;
        
        Double PuntoCx = -34.901418;
        Double PuntoCy = -56.174630;
        
        Double PuntoDx = -34.908761;
        Double PuntoDy = -56.169940;
        
        Double PuntoEx = -34.891956;
        Double PuntoEy = -56.169030;
        
        Double PuntoFx = -34.872275;
        Double PuntoFy = -56.146211;
        
        Double PuntoGx = -34.920027;
        Double PuntoGy = -56.161021;
        ////////////////////////////
        // END PUNTOS             //
        ////////////////////////////
        
        
        
        //REGISTRAR AFILIADO
        p.ver(s.registrarAfiliado("3.333.333-3", "Tres", "r@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado 3");
        p.ver(s.registrarAfiliado("1.111.111-1", "Uno", "s@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado 1");
        p.ver(s.registrarAfiliado("2.222.222-2", "Dos", "s@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado 2");
        p.ver(s.registrarAfiliado("5.555.555-5", "Cinco", "m@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado 5");
        p.ver(s.registrarAfiliado("4.444.444-4", "Cuatro", "m@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado 4");
        p.ver(s.registrarAfiliado("6.666.666-6", "Seis", "m@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado 6");
        p.ver(s.registrarAfiliado("7.777.777-7", "Siete", "m@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado 7");
        
        //REGISTRA UN AFILIADO QUE YA EXISTE
        p.ver(s.registrarAfiliado("3.333.333-3", "Tres", "r@gmail.com").resultado, Retorno.Resultado.ERROR_3, "NO agrego Afiliado POR DUPLICADO");
        //REGISTRA UN AFILIADO CON MAIL INVALIDO
        p.ver(s.registrarAfiliado("8.888.888-8", "Ocho", "gmail.com").resultado, Retorno.Resultado.ERROR_2, "NO agrego Afiliado POR MAIL INVALIDO");
        //REGISTRA UN AFILIADO CON CEDULA INVALIDA
        p.ver(s.registrarAfiliado("..702.510-0", "Ocho", "r@gmail.com").resultado, Retorno.Resultado.ERROR_1, "NO agrego Afiliado POR CEDULA INVALIDA");
        p.ver(s.registrarAfiliado("833.191-6", "Ocho", "r@gmail.com").resultado, Retorno.Resultado.ERROR_1, "NO agrego Afiliado POR CEDULA INVALIDA");
        
        //BUSCA AFILIADO
        System.out.print( "Buscar Afiliado: \n");
        p.ver(s.buscarAfiliado("7.777.777-7").resultado, Retorno.Resultado.OK, "Busca Afiliado");
        System.out.print( "Datos Afiliado:"+ s.buscarAfiliado("7.777.777-7").valorString + "\n");
        System.out.print( "Cantidad de Busquedas:"+ s.buscarAfiliado("7.777.777-7").valorEntero + "\n");
        System.out.print( "\n");
        
        //BUSCA AFILIADO ERROR
        System.out.print( "Buscar Afiliado ERROR: \n");
        p.ver(s.buscarAfiliado(".777-7").resultado, Retorno.Resultado.ERROR_1, "Busca Afiliado CI no es una cédula válida");
        p.ver(s.buscarAfiliado("5.333.333-9").resultado, Retorno.Resultado.ERROR_2, "no existe un afiliado registrado con esa CI en el sistema.");
        
        //LISTAR AFILIADOS
        System.out.print( "Listar Afiliados: \n"+ s.listarAfiliados().valorString);
        System.out.print( "\n");
        
        //MUESTRA TODOS LOS AFILIADOS
        INodoTadAbb<Afiliado> ar = s.getAbbAfiliados().getRaiz();
        //JOptionPane.showMessageDialog(null, "Productos: \n"+ s.getAbbAfiliados().mostrar(ar));
        System.out.print( "Afiliados: \n"+ s.getAbbAfiliados().mostrar(ar));
        System.out.print( "\n");
                
        //REGISTRAR CANALERA
        System.out.print( "Registrar Canalera: \n");
        p.ver(s.registrarCanalera("A", "3.333.333-3", PuntoAx, PuntoAy).resultado, Retorno.Resultado.OK, "Registrar Canalera AAA"); //2
        p.ver(s.registrarCanalera("B", "4.444.444-4", PuntoBx, PuntoBy).resultado, Retorno.Resultado.OK, "Registrar Canalera BBB"); //3
        p.ver(s.registrarCanalera("C", "5.555.555-5", PuntoCx, PuntoCy).resultado, Retorno.Resultado.OK, "Registrar Canalera CCC"); //4
        
        System.out.print( "Registrar Canalera con ERROR: \n");
        //p.ver(s.registrarCanalera("AAA", "3.333.333-3", PuntoAx, PuntoAy).resultado, Retorno.Resultado.ERROR_2, "Registrar Canalera AAA Ya existe"); 
        //p.ver(s.registrarCanalera("DDD", "1.234.567-8", PuntoDx, PuntoDy).resultado, Retorno.Resultado.ERROR_3, "Registrar Canalera Afiliado No existe");
        
        //REGISTRAR NODO
        System.out.print( "Registrar Nodo: \n");
        p.ver(s.registrarNodo("nodoIdE", PuntoEx, PuntoEy).resultado, Retorno.Resultado.OK, "Registrar Nodo E"); //5
        p.ver(s.registrarNodo("nodoIdF", PuntoFx, PuntoFy).resultado, Retorno.Resultado.OK, "Registrar Nodo F"); //6
        p.ver(s.registrarNodo("nodoIdG", PuntoGx, PuntoGy).resultado, Retorno.Resultado.OK, "Registrar Nodo G"); //7
        
        //REGISTRAR NODO ERROR
        //System.out.print( "Registrar Nodo ERROR: \n");
        //.ver(s.registrarNodo("Esimposhible", -32.3105144,-58.0759555).resultado, Retorno.Resultado.OK, "Registrar Nodo Error cantidad maxima de puntos");
        
        //REGISTRAR TRAMO
        System.out.print( "Registrar Tramo: \n");
        p.ver(s.registrarTramo(PuntoSx, PuntoSy, PuntoGx, PuntoGy, 10).resultado, Retorno.Resultado.OK, "Registrar Tramo entre Nodo E y Nodo F");
        p.ver(s.registrarTramo(PuntoEx, PuntoEy, PuntoFx, PuntoFy, 11).resultado, Retorno.Resultado.OK, "Registrar Tramo entre Nodo E y Nodo F");
        p.ver(s.registrarTramo(PuntoFx, PuntoFy, PuntoGx, PuntoGy, 12).resultado, Retorno.Resultado.OK, "Registrar Tramo entre Nodo F y Nodo G");
        
        p.ver(s.registrarTramo(PuntoAx, PuntoAy, PuntoGx, PuntoGy, 20).resultado, Retorno.Resultado.OK, "Registrar Tramo entre Nodo F y Nodo G");
        p.ver(s.registrarTramo(PuntoBx, PuntoBy, PuntoGx, PuntoGy, 21).resultado, Retorno.Resultado.OK, "Registrar Tramo entre Nodo F y Nodo G");
        p.ver(s.registrarTramo(PuntoCx, PuntoCy, PuntoFx, PuntoFy, 22).resultado, Retorno.Resultado.OK, "Registrar Tramo entre Nodo F y Nodo G");
        
        System.out.print( "Registrar Tramo Con Error: \n");
        p.ver(s.registrarTramo(PuntoSx, PuntoSy, PuntoAx, PuntoAy, 10).resultado, Retorno.Resultado.ERROR_4, "Registrar Tramo Sitema y Canalera");
        p.ver(s.registrarTramo(1.0, 2.0, 1.0, 2.0, 10).resultado, Retorno.Resultado.ERROR_2, "Registrar Tramo entre Nodos que no existen");
        p.ver(s.registrarTramo(-32.3105104,-58.0759192, -32.3105200,-58.0759192, 0).resultado, Retorno.Resultado.ERROR_1, "Registrar Tramo Peso invalido");
        
        //MODIFICAR TRAMO
        System.out.print( "Modificar Tramo: \n");
        p.ver(s.modificarTramo(PuntoEx, PuntoEy, PuntoFx, PuntoFy, 15).resultado, Retorno.Resultado.OK, "Modificar Tramo Nodo E - Nodo F");
        p.ver(s.modificarTramo(PuntoFx, PuntoFy, PuntoGx, PuntoGy, 15).resultado, Retorno.Resultado.OK, "Modificar Tramo Nodo F - Nodo G");
        
        System.out.print( "Modificar Tramo Error: \n");
        p.ver(s.modificarTramo(PuntoEx, PuntoEy, PuntoAx, PuntoAy, 15).resultado, Retorno.Resultado.ERROR_2, "Modificar Tramo Que no existe");
        //p.ver(s.modificarTramo(PuntoEx, PuntoAx, PuntoEy, PuntoAy, 15).resultado, Retorno.Resultado.ERROR_2, "Modificar Tramo entre Puntos que no existen");
        
        
        //CALIDAD CANALERA
        //System.out.print( "Calidad Canalera: \n");
        //p.ver(s.calidadCanalera(Double.NaN, Double.NaN).resultado, Retorno.Resultado.OK, "Calidad Canalera");
        //p.ver(s.calidadCanalera(Double.NaN, Double.NaN).resultado, Retorno.Resultado.OK, "Calidad Canalera");
        
        //NODOS CRITICOS
        System.out.print( "Nodo Criticos: \n");
        p.ver(s.nodosCriticos().resultado, Retorno.Resultado.OK, "Nodo Criticos");
        
        //s.getGrafo().DFS();
        //System.out.println();
        //s.getGrafo().BFS();

        //System.out.println();
        //esqMin = s.getGrafo().prim();
        //esqMin.DFS();
        //System.out.println();
        //esqMin.BFS();
        
        //DIBUJAR MAPA
        System.out.print( "Dibujar Mapa: \n");
        p.ver(s.dibujarMapa().resultado, Retorno.Resultado.OK, "Dibujar Mapa");
        
        p.imprimirResultadosPrueba();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //PRUEBA 2
    static void prueba2(Sistema s, Prueba p){
//        p.imprimirComentario("CREAMOS SISTMA PARA 5 CIUDADES");
//        p.ver(s.crearSistemaEmergencias(5).resultado, Retorno.Resultado.OK, "Se creÃ³ el sistema de reservas");
//        p.imprimirComentario("INGRESAMOS CIUDADES");
//        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresa Montevideo");
//        p.ver(s.registrarCiudad("Santiago").resultado, Retorno.Resultado.OK, "Se ingresa Santiago");
//        p.ver(s.registrarCiudad("Lima").resultado, Retorno.Resultado.OK, "Se ingresa Lima");
//        p.ver(s.registrarCiudad("San Pablo").resultado, Retorno.Resultado.OK, "Se ingresa San Pablo");
//        p.ver(s.registrarCiudad("New York").resultado, Retorno.Resultado.OK, "Se ingresa New York");
//
//        p.imprimirComentario("INGRESAMOS CIUDAD REPETIDA");
//        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Montevideo ya existe");
//
//        p.imprimirComentario("INTENTAMOS SOBREPASAR EL LIMITE DE CIUDADES");
//        p.ver(s.registrarCiudad("Buenos Aires").resultado, Retorno.Resultado.ERROR_2, "Se sobrepasa el límite de ciudades gestionados por el sistema");
//
//        p.imprimirResultadosPrueba();   
    }
    
}
