/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.ob201802;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author sflaquer
 */
public class ArbolAfiliados {
    
    private TadAbb<Afiliado> raiz;
    
    public TadAbb<Afiliado> getRaiz(){
        return raiz;
    }
    
    public void insertar(Afiliado a) {
        if (raiz == null) {
            raiz = new implTadAbb<> (a);
        } else {
            insertarRec(raiz, a);
        }
    }

    //INSERTAR
    private void insertarRec(TadAbb<Afiliado> raiz, Afiliado a) {
        //1 - este mayor a este
        //0 - iguales
        //-1 - este mayor a este        
        
        //SI EL ID ES MENOR
        //if(a.getId() < raiz.obtener().getId()){
        if(a.getCI().compareTo(raiz.obtener().getCI()) < 0){
            if(raiz.izq()==null){
                raiz.enlIzq(new implTadAbb<>(a));
            }else{
                insertarRec(raiz.izq(), a);
            }
        }
        //SI EL ID ES MAYOR
        else{
          if(raiz.der()==null){
              raiz.enlDer(new implTadAbb<>(a));
          }else{
              insertarRec(raiz.der(), a);
          }
        }
    }
    
    //BUSCAR
    String con ="";
    public void mostrarTodo(TadAbb<Afiliado> r){
        if(r!=null){
            visitar(r);
            mostrarTodo(r.izq());
            mostrarTodo(r.der());
        }
    }
    public void visitar(TadAbb<Afiliado> r) {
        con+="Nombre: "+r.obtener().getNombre()+"Cedula:"+r.obtener().getCI()+"Mail:"+r.obtener().getEmail()+"\n";
    }
    
    public String mostrar(TadAbb<Afiliado> r){
        con=" ";
        mostrarTodo(r);
        return con;
    }
    
    /////////////////////////////////////////////////////////////
    // VALIDA CEDULA
    public boolean validarCedula(TadAbb<Afiliado> r){
        boolean retorno = false;
        retorno =  esCIValida(r.obtener().getCI());
        return retorno;
    }
    
    public boolean esCIValida(String ci) { 
        String aux = ci.replaceAll("\\.", "");
        String aux2 = aux.replaceAll("-", "");
        ci = aux2;
        
        if(ci.length() != 7 && ci.length() != 8){ 
            return false;
        }else{ 
            try{ 
                Integer.parseInt(ci); 
            }catch (NumberFormatException e){ 
                return false; 
            } 
        }
        
        int digVerificador = Integer.parseInt((ci.charAt(ci.length() - 1)) + "" ); 
        int[] factores; 
        if(ci.length() == 7){ // CI viejas 
            factores = new int[]{9, 8, 7, 6, 3, 4}; 
        }else{ 
            factores = new int[]{2, 9, 8, 7, 6, 3, 4}; 
        } 
        
        int suma = 0; 
        for(int i=0; i<ci.length()-1; i++ ){ 
            int digito = Integer.parseInt(ci.charAt(i) + "" ); 
            suma += digito * factores[ i ]; 
        } 

        int resto = suma % 10;
        int checkdigit = 10 - resto;

        if(checkdigit == 10){ 
            return (digVerificador == 0); 
        }else { 
            return (checkdigit == digVerificador) ; 
        } 
    } 
    
    public boolean esMailValido(String email) {
        
        boolean retorno = false;
        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            retorno = true;
        }        
        return retorno;
    }
    
    /////////////////////////////////////////////////////////////
    // BUSCAR
    public TadAbb<Afiliado> buscarPorCi(String ci){
        if(raiz==null){
            return null;
        }else{
            return buscarRec(raiz, ci);
        }
    }
    
    private TadAbb<Afiliado> buscarRec(TadAbb<Afiliado> raiz, String ci) {
        //SI EL ID ES IGUAL A LA RAIZ        
        if(ci.compareTo(raiz.obtener().getCI()) == 0){
            return raiz;
        }
        else{
            //SI EL ID ES MENOR
            if(ci.compareTo(raiz.obtener().getCI()) < 0){
                if(raiz.izq()==null){
                    return null;
                }else{
                    return buscarRec(raiz.izq(), ci);
                }
            }
            //SI ES MAYOR
            else{
                if(raiz.der()==null){
                    return null;
                }else{
                    return buscarRec(raiz.der(), ci);
                }
            }
        }
    }
    
    /////////////////////////////////////////////////////////////
    // ELIMINAR
    private TadAbb<Afiliado> eliminar(TadAbb<Afiliado> raiz, String x){
        if(raiz.obtener().getCI().compareTo(x) == 0){
            return borrar(raiz, x);
        }else{
            if(x.compareTo(raiz.obtener().getCI()) < 0){
                raiz.enlIzq(eliminar(raiz.izq(), x));
            }else{
                raiz.enlDer(eliminar(raiz.izq(), x));
            }
            return raiz;
        }
    }

    /////////////////////////////////////////////////////////////
    // BORRAR
    
    private TadAbb<Afiliado> borrar(TadAbb<Afiliado> raiz, String x) {
        if(raiz.izq()==null && raiz.der()==null){
            return null;
        }else{
            if(raiz.izq()==null){
                return raiz.der();
            }else{
                if(raiz.der()==null){
                    return raiz.der();
                }else{
                    TadAbb<Afiliado> may = numeroMayor(raiz.izq());
                    raiz.modificar(may.obtener());
                    raiz.enlIzq(eliminar(raiz.izq(), may.obtener().getCI()));
                    return raiz;
                }
            }
        } 
    }

    /////////////////////////////////////////////////////////////
    // NUMERO MAYOR
    private TadAbb<Afiliado> numeroMayor(TadAbb<Afiliado> raiz) {
        if(raiz!=null){
            if(raiz.der()!=null){
                return numeroMayor(raiz.der());
            }else{
                return raiz;
            }
        }else{
            return null;
        }
    }

    
}
