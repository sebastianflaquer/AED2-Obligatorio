

package uy.ort.ob201802;


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
        p.ver(s.registrarAfiliado(1, "4.517.456-4", "Sebastian Flaquer", "s@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado");
        p.ver(s.registrarAfiliado(2, "3.567.932-3", "Roberto Rodriguez", "r@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado");
        p.ver(s.registrarAfiliado(3, "2.987.134-2", "Martin Perez", "m@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado");
        p.ver(s.registrarAfiliado(4, "1.245.567-1", "Pedro Gonzales", "p@gmail.com").resultado, Retorno.Resultado.OK, "Se agrego Afiliado");
        
        //p.imprimirResultadosPrueba();
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
