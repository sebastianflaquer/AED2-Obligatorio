

package uy.ort.ob201802;

import javax.swing.JOptionPane;


public class Obligatorio {

    public static void main(String[] args) {
        // TODO code application logic here
        
        Sistema s = new Sistema();
        Prueba p = new Prueba();
        
        s.inicializarSistema(250, 1.5, 1.5);
       
        prueba1(s,p);
        //prueba2(s,p);
        
    }
    
    //PRUEBA 1
    static void prueba1(Sistema s, Prueba p){
        
        //REGISTRAR AFILIADO
        p.ver(s.registrarAfiliado("3.333.333-3", "Tres", "r@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado 3");
        p.ver(s.registrarAfiliado("1.111.111-1", "Uno", "s@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado 1");
        p.ver(s.registrarAfiliado("2.222.222-2", "Dos", "s@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado 2");
        p.ver(s.registrarAfiliado("5.555.555-5", "Cinco", "m@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado 5");
        p.ver(s.registrarAfiliado("4.517.335-3", "Cuatro", "m@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado 4");
        p.ver(s.registrarAfiliado("6.666.666-6", "Seis", "m@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado 6");
        p.ver(s.registrarAfiliado("7.777.777-7", "Siete", "m@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado 7");
        
        //REGISTRA UN AFILIADO QUE YA EXISTE
        p.ver(s.registrarAfiliado("3.333.333-3", "Tres", "r@gmail.com").resultado, Retorno.Resultado.ERROR_3, "NO agrego Afiliado POR DUPLICADO");
        
        //REGISTRA UN AFILIADO CON MAIL INVALIDO
        p.ver(s.registrarAfiliado("8.888.888-8", "Ocho", "gmail.com").resultado, Retorno.Resultado.ERROR_2, "NO agrego Afiliado POR MAIL INVALIDO");
        
        //REGISTRA UN AFILIADO CON CEDULA INVALIDA
        p.ver(s.registrarAfiliado("8.888-1", "Ocho", "r@gmail.com").resultado, Retorno.Resultado.ERROR_1, "NO agrego Afiliado POR CEDULA INVALIDA");
        
        //BUSCA AFILIADO
        //p.ver(s.buscarAfiliado("7.777.777-7").resultado, Retorno.Resultado.OK, "Busca Afiliado");
        //System.out.print( "Datos Afiliado:"+ s.buscarAfiliado("7.777.777-7").valorString + "\n");
        //System.out.print( "Cantidad de Busquedas:"+ s.buscarAfiliado("7.777.777-7").valorEntero + "\n");
        //System.out.print( "\n");
        
        System.out.print( "Listar Afiliados:"+ s.listarAfiliados().valorString + "\n");
        
        INodoTadAbb<Afiliado> ar = s.getAbbAfiliados().getRaiz();
        //JOptionPane.showMessageDialog(null, "Productos: \n"+ s.getAbbAfiliados().mostrar(ar));
        System.out.print( "Productos: \n"+ s.getAbbAfiliados().mostrar(ar));
        
        
        
        
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
