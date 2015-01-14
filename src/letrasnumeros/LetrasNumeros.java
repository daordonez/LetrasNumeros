
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
        int resUnidades = digitUnit(numero);
        int resDecenas = digitDecenas(numero);
        int resCentenas = digitCentenas(numero);
        
        
        longNumero(numero);
          
    }
    
    //Separadores de Centenas-Decenas-Unidades
    static int digitUnit (int numEx){
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
    static void longNumero (int num){
        //int bloque = 0;
        int dec = digitDecenas(num);
        
        
        if (num <= 0) {
            eixNum("Zero");
        } else if (num <= 9) {
            eixNum(unidadesLet(digitUnit(num)));
        } else if (num < 20) {
            int espDec = (digitDecenas(num)*10) + digitUnit(num);
            eixNum(desenesEsp(espDec));
        } else if (num >= 100 && num < 999) {
           // bloque = 3;
        } else if (num >= 1000 && num < 999999) {
           // bloque = 4;
        } else if (num >= 1000000 && num < 999999999) {
            //bloque = 5;
        }else {
            misatgeCab("Nombre massa llarg", "Informació");
        }
       // return bloque;
    }
    //Conversores a letras
    static String unidadesLet(int unidad){
        String value = null ;
        switch (unidad) {
            case 1:
            value = "Una";
                break;
            case 2:
            value = "Dos";
                break;
            case 3:
            value = "Tres";
                break;
            case 4:
            value = "Quatre";
                break;
            case 5:
            value = "Cinc";
                break;
            case 6:
            value = "Sis";
                break;
            case 7:
            value = "Set";
                break;
            case 8:
            value = "Huit";
                break;
            case 9:
            value = "Nou";
                break;
            default:
                misatgeCab("Valor no comprés", "Informació");
        }
        return value;
    }
    static String desenesEsp(int desena){
        String value = null;
        switch (desena) {
            case 10:
            value = "Deu";
                break;
            case 11:
            value = "Onze";
                break;
            case 12:
            value = "Dotze";
                break;
            case 13:
            value = "Tretze";
                break;
            case 14:
            value = "Catorze";
                break;
            case 15:
            value = "Quinze";
                break;
            case 16:
            value = "Setze";
                break;
            case 17:
            value = "Dèsset";
                break;            
            case 18:
            value = "Dihuit";
                break;
            case 19:
            value = "Dènou";
                break;
            default:
                misatgeCab("Desena especial erronea", "Informació");
                break;
        }
        return value;
    }
    static String desenaEnLet(int desena){
        String value = null;
        
        switch (desena) {

            case 1:
            value = "";
                break;
            case 2:
            value = "Vint-i-";
                break;
            case 3:
            value = "Trenta-";
                break;
            case 4:
            value = "Quaranta-";
                break;
            case 5:
            value = "Cinquanta-";
                break;
            case 6:
            value = "Seixanta-";
                break;
            case 7:
            value = "Setanta-";
                break;
            case 8:
            value = "Huitanta-";
                break;
            case 9:
            value = "Noranta-";
                break;
            default:
                misatgeCab("Valor no comprés", "Información");
                break;
        }
        return value;
    }
    //Bifurcador segun número
    static void bifurcNum (int longNum){
        switch (longNum) {

            case 1:
                eixNum(unidadesLet(digitUnit(longNum)))
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                misatgeCab("Error de bifurcació", "Informació");
        }
    }
    //Salida de mensajes
    static void eixNum(String num){
        System.out.println(num);
    }
    static void misatgeCab( String mensaje, String cabecera){
        
        for (int i = 0; i < 15;i++){System.out.print("_");}
        System.out.println("");
        System.out.println("+ "+cabecera+" +");
        for (int i = 0; i < 15;i++){System.out.print("_");}
        System.out.println("");
        System.out.println("+ "+mensaje+" +");   
        for (int i = 0; i < 15;i++){System.out.print("_");}
        System.out.println("");
    }
    static void misatgeUs(String mensaje){
        System.out.println(mensaje);
    }
    //Concatenadores
    
    
}
