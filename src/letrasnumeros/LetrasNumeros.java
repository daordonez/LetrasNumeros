package letrasnumeros;

import java.util.Scanner;

public class LetrasNumeros {

    public static void main(String[] args) {

        //Contenedor principal de valor
        int numero;

        //Recogida de datos del usuario
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introdueix numero:");
        numero = teclado.nextInt();

        //Disparador de 230funciones
        bifNumero(numero);

    }

    //Separadores de Centenas-Decenas-Unidades
    static int digitUnit(int numEx) {
        int unidades;
        unidades = numEx % 10;
        return unidades;
    }

    static int digitDecenas(int numEx) {
        int decenas;
        decenas = (numEx / 10) % 10;
        return decenas;
    }

    static int digitCentenas(int numEx) {
        int centenas;
        centenas = numEx / 100;
        return centenas;
    }

    //Selector segun número

    static void bifNumero(int num) {
      
        int espDec = (digitDecenas(num) * 10) + digitUnit(num);
        String vint = null;

        if (num <= 0) {
            eixNum("Zero");
        } else if (num <= 9) {
            eixNum(unidadesLet(digitUnit(num)));
        } else if (num < 20) {
            //Decenas especiales
            eixNum(desenesEsp(espDec));
        } else if (num >= 20 && num <= 99) {
            /*
             - Respeta números acabados en cero.
             - Representa numeros (rango 21-29) con "-i-" intermedia.
             - Representa números (rango 30-99) con "-" intermedio.
             */
            if (digitUnit(num) == 0) {
                eixNum(desenaEnLet(digitDecenas(num)));
            } else if (num <= 29) {
                eixNum(concatVint(desenaEnLet(digitDecenas(num)), unidadesLet(digitUnit(num))));
            } else {
                eixNum(concatDes(desenaEnLet(digitDecenas(num)), unidadesLet(digitUnit(num))));
            }
        } else if (num >= 100 && num <= 999) {
            // bloque = 4;
            if (digitCentenas(num) == 1 && digitDecenas(num) == 0 && digitUnit(num) == 0) {
                eixNum("Cent");
            } else if (digitDecenas(num) == 0 && digitUnit(num) == 0) {
                eixNum(unidadesLet(digitCentenas(num)).concat("-cents "));
            } else if (digitCentenas(num) == 1) {
                if (digitDecenas(num) == 0) {
                    eixNum(concatCents(unidadesLet(digitUnit(num))));
                } else if (digitDecenas(num) == 1) {
                    eixNum(concatCents(desenesEsp(espDec)));
                } else if (digitUnit(num) == 0) {
                    eixNum(concatCents(desenaEnLet(digitDecenas(num))));
                } else if (digitDecenas(num) == 2 && digitUnit(num) >= 1 && digitUnit(num) <= 9) {
                    eixNum(concatCents(concatVint(desenaEnLet(digitDecenas(num)), unidadesLet(digitUnit(num)))));
                } else {
                    eixNum(concatCents(concatDes(desenaEnLet(digitDecenas(num)), unidadesLet(digitUnit(num)))));
                }
            } else if (digitUnit(num) == 0) {
                eixNum(concatCentenes(unidadesLet(digitCentenas(num)), desenaEnLet(digitDecenas(num))));
            } else {
                eixNum(concatCentenes(unidadesLet(digitCentenas(num)),
                        concatDes(desenaEnLet(digitDecenas(num)), unidadesLet(digitUnit(num)))));
            }
        } else if (num >= 1000000 && num < 999999999) {
            //bloque = 5;
        } else {
            misatgeCab("Nombre massa llarg", "Informació");
        }
        // return bloque;
    }

    //Conversores a letras

    static String unidadesLet(int unidad) {
        String value = null;
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

    static String desenesEsp(int desena) {
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

    static String desenaEnLet(int desena) {
        String value = null;

        switch (desena) {

            case 2:
                value = "Vint";
                break;
            case 3:
                value = "Trenta";
                break;
            case 4:
                value = "Quaranta";
                break;
            case 5:
                value = "Cinquanta";
                break;
            case 6:
                value = "Seixanta";
                break;
            case 7:
                value = "Setanta";
                break;
            case 8:
                value = "Huitanta";
                break;
            case 9:
                value = "Noranta";
                break;
            default:
                misatgeCab("Desena no compresa", "Informació");
                break;
        }
        return value;
    }

    //Salida de mensajes

    static void eixNum(String numlet) {
        System.out.println(numlet);
    }

    static void misatgeCab(String mensaje, String cabecera) {

        for (int i = 0; i < 15; i++) {
            System.out.print("_");
        }
        System.out.println("");
        System.out.println("+ " + cabecera + " +");
        for (int i = 0; i < 15; i++) {
            System.out.print("_");
        }
        System.out.println("");
        System.out.println("+ " + mensaje + " +");
        for (int i = 0; i < 15; i++) {
            System.out.print("_");
        }
        System.out.println("");
    }

    static void misatgeUs(String mensaje) {
        System.out.println(mensaje);
    }

    //Concatenadores

    static String concatVint(String desena, String unitat) {
        String desenaUnit;
        desenaUnit = desena.concat("-i-" + unitat);
        return desenaUnit;
    }

    static String concatDes(String desena, String unitat) {
        String desenaUnit;
        desenaUnit = desena.concat("-" + unitat);
        return desenaUnit;
    }

    static String concatCents(String desena) {
        String centDesenes;
        centDesenes = "Cent ".concat(desena);
        return centDesenes;
    }

    static String concatCentenes(String centena, String desenas) {
        //Es necesario recibir cadena concatenada Decena-unidades
        String centDes;
        centDes = centena.concat("-cents " + desenas);
        return centDes;
    }

}
