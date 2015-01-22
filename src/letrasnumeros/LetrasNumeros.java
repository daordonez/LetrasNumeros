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

    static int digitDesenes(int numEx) {
        int decenas;
        decenas = (numEx / 10) % 10;
        return decenas;
    }

    static int digitCentenes(int numEx) {
        int centenas;
        centenas = (numEx / 100) % 10;
        return centenas;
    }

    //Agrupadores
    static String grupTres(int num) {

        String gTres = null;
        int unitats = digitUnit(num);
        int desenes = digitDesenes(num);
        int centenes = digitCentenes(num);
        int espDec = ((desenes * 10) + unitats);
        
        if (num <= 9) {
            gTres= unidadesLet(unitats);
        } else if (num < 20) {
            //Decenas especiales
            gTres = desenesEsp(espDec);
        }else if (num >= 20 && num <= 99) {
            /*
             - Respeta números acabados en cero.
             - Representa numeros (rango 21-29) con "-i-" intermedia.
             - Representa números (rango 30-99) con "-" intermedio.
             */
            if (unitats == 0) {
                gTres = desenaEnLet(desenes);
            } else if (num <= 29) {
                gTres = concatVint(desenaEnLet(desenes), unidadesLet(unitats));
            } else {
                gTres = concatDes(desenaEnLet(desenes), unidadesLet(unitats));
            }
        } else if (num >= 100 && num <= 999) {
            // bloque = 4;
            if (centenes == 1 && desenes == 0 && unitats == 0) {
                gTres = "Cent";
            } else if (desenes == 0 && unitats == 0) {
                gTres = unidadesLet(centenes).concat("-cents ");
            } else if (centenes == 1) {
                if (desenes == 0) {
                    gTres = concatCents(unidadesLet(unitats));
                } else if (desenes == 1) {
                    gTres = concatCents(desenesEsp(espDec));
                } else if (unitats == 0) {
                    gTres = concatCents(desenaEnLet(desenes));
                } else if (desenes == 2 && unitats >= 1 && unitats <= 9) {
                    gTres = concatCents(concatVint(desenaEnLet(desenes), unidadesLet(unitats)));
                } else {
                    gTres = concatCents(concatDes(desenaEnLet(desenes), unidadesLet(unitats)));
                }
            } else if (desenes == 0) {
                gTres = concatCentenes(unidadesLet(centenes), unidadesLet(unitats));
            } else if (unitats == 0) {
                gTres = concatCentenes(unidadesLet(centenes), desenaEnLet(desenes));
            } else {
                gTres = concatCentenes(unidadesLet(centenes),
                        concatDes(desenaEnLet(desenes), unidadesLet(unitats)));
            }
        } else {
            misatgeCab("Nombre massa llarg", "Informació");
        }
        return gTres;
    }

    static String grupNou(int num) {

        String gNou = null;

        int tempNum = num;

        int primGrup = tempNum % 1000;
        tempNum = tempNum / 1000;
        int segGrup = tempNum % 1000;
        tempNum = tempNum / 1000;
        int terGrup = tempNum % 1000;

        if (num >= 1000 && num < 999999) {
            if (segGrup == 1 && primGrup == 0) {
                gNou = "Mil";
            } else if (primGrup == 0) {
                gNou = unidadesLet(segGrup).concat(" mil");
            }else {
                gNou = concatMillar(grupTres(segGrup),grupTres(primGrup));
            }
        }else if (num >= 1000000 && num <= 999999999) {
            if (terGrup == 1 && segGrup == 0 && primGrup == 0) {
                gNou = "Un Milló";
            }
            else if (segGrup == 0 && primGrup == 0){
                gNou = unidadesLet(terGrup).concat(" milions");
            }else {
                gNou = concatMilions(grupTres(terGrup), concatMillar(grupTres(segGrup), grupTres(primGrup)));
            }
        }

        return gNou;
    }

    //Selector segun número
    static void bifNumero(int num) {

        int unitats = digitUnit(num);
        int desenes = digitDesenes(num);
        int centenes = digitCentenes(num);
        int espDec = ((desenes * 10) + unitats);

        if (num <= 0) {
            eixNum("Zero");
        } else if (num >= 1 && num <= 999) {
            eixNum(grupTres(num));
        } else if (num > 999 && num <= 999999999) {
            eixNum(grupNou(num));
        } else {
            misatgeCab("Nombre massa llarg", "Informació");
        }
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

    static String concatMillar(String uMil, String centenes) {

        String MilCent;

        MilCent = uMil.concat(" mil " + centenes);

        return MilCent;
    }
    
    static String concatMilions(String milions, String millars){
        String MiliMilla;
        
        MiliMilla = milions.concat(" milions "+millars);
        return MiliMilla;
    }

}
