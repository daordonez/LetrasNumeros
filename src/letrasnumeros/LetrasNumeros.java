/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letrasnumeros;

import java.util.Scanner;

public class LetrasNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int numero;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introdueix numero:");
        numero = teclado.nextInt();
        //Llamadas
        
        int resUnidades = digitUnidades(numero);
        int resDecenas = digitDecenas(numero);
        int resCentenas = digitCentenas(numero);
        
        unidadesLet(resUnidades);
        
        
        
        
    }
    
    //Separadores de Centenas-Decenas-Unidades
    static int digitUnidades (int numEx){
        int unidades;
            unidades = numEx % 10;
        return unidades;
    }
    static int digitDecenas( int numEx){
        int decenas;
            decenas = (numEx / 10) % 10;
        return decenas;
    }
    static int digitCentenas(int numEx){
        int centenas;
            centenas = numEx / 100;
        return centenas;
    }
    //Longitud del numero introducido
    static int longNumero (int num){
        int bloque = 0;
        
        if (num <= 0) {
            eixNum("Zero");
        } else if (num > 9) {
            bloque = 1;
        } else if (num > 20 && num < 99) {
            bloque = 2;
        } else if (num >= 100 && num < 999) {
            bloque = 3;
        } else if (num >= 1000 && num < 999999) {
            bloque = 4;
        } else if (num >= 1000000 && num < 999999999) {
            bloque = 5;
        }else {
            eixidaNumCab("Nombre massa llarg", "Informació");
        }
        
        return bloque;
    }
    //Conversores a letras
    static void unidadesLet(int unidad){
    switch (unidad) {
            case 1:
                eixNum("U");
                break;
            case 2:
                eixNum("Dos");
                break;
            case 3:
                eixNum("Tres");
                break;
            case 4:
                eixNum("Quatre");
                break;
            case 5:
                eixNum("Cinc");
                break;
            case 6:
                eixNum("Sis");
                break;
            case 7:
                eixNum("Set");
                break;
            case 8:
                eixNum("Huit");
                break;
            case 9:
                eixNum("Nou");
                break;
            default:
                eixidaNumCab("Valor no comprés", "Informació");
        }
    }
    static void desenaEnLet(int desena){
        switch (desena) {

            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            default:
                eixidaNumCab("Valor no comprés", "Información");
                break;
        }
    }
    //Salida de mensajes
    static void eixNum(String num){
        System.out.println(num);
    }
    static void eixidaNumCab( String mensaje, String cabecera){
        
        for (int i = 0; i < 10;i++){System.out.print("_");}
        System.out.println("+ "+cabecera+" +");
        for (int i = 0; i < 10;i++){System.out.print("_");}
        System.out.println("+ "+mensaje+" +");   
        for (int i = 0; i < 10;i++){System.out.print("_");}
    }
    static void misatgeUs(String mensaje){
        System.out.println(mensaje);
    }
    //Concatenadores
    
    
}
