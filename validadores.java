import java.text.Normalizer;
import java.util.*;
import java.lang.*;

public class validadores {

    static String correo = "B.s場合にはáEz01@ufromail.cl";
    static String clave = "patata";

    static String nickName;

    public static void main(String[] args) {
        System.out.println("tu correo es: "+correo);
        System.out.println("es ufro mail?");
        ufromail();
        caracteresEspeciales();
        System.out.println( "se generarar tu nickname");
        generadorNickname();



    }




    public static String generadorNickname() {

        ////analizar la divicion entre los dos "."////
        //servira ahora dividir el mail??


/*
        no se como lo hice pero funciona
        averiguar para posterior documentacion
        hacer que el validador solo funcione con 3 puntos, si son mas no funciona
        se podra dividir un String con tokenizer teniendo en cuenta que el numero que quiero separa va entre 01 y 99
*/

        StringTokenizer tokens = new StringTokenizer(correo, " @");
        String[] newcorreo = new String[tokens.countTokens()];
        int index = 0;
        while (tokens.hasMoreTokens()) {

           // System.out.println("separacion: " + index);
            newcorreo[index] = tokens.nextToken();
            //System.out.println(newcorreo[index]);
            if (index == 1) {
                //System.out.println("se va a guardar la seccion: " + newcorreo[0]);
                String evaluar = newcorreo[0];
               // System.out.println("se guardo: " + evaluar  + ", ahora sera tu nickname");
                nickName=evaluar;
                break;
            }


            index++;



        }
        System.out.println(nickName);
        return nickName;
    }

    public static void caracteresEspeciales() {
        ////si tiene "." o "@"///
        /*
        pero que pasa si le pongo muchos "." o "@"
        solo tiene que haber 1 "@" y 2"."
         */

        System.out.println("se borraran todos los caracteres con acento");
        String cadenaNormalize = Normalizer.normalize(correo, Normalizer.Form.NFD);
        String cadenaSinAcentos = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
        //System.out.println("Resultado sin acento: " + cadenaSinAcentos);
        correo=cadenaSinAcentos;
        //System.out.println("resultado sin caracteres especiales: ");
        String cadenaSinCaracteresEsp = correo.replaceAll("[-+!#$%&'*ñ/=?^_`~+¡?=)(,~`;:_,><'+}]*", "");//le faltan cosas por agregar
        //System.out.println(cadenaSinCaracteresEsp);
        correo=cadenaSinCaracteresEsp;
        //System.out.println("resultado en minuscula");
        correo=correo.toLowerCase();
        System.out.println(correo);//transforma a minuscula
        System.out.println("fin");


    }

    public static String ufromail() {

        ///////si es ufromail//////
        /*
        y si el ufromail esta antes de la "@"?
        y si el ".cl" no esta despues de "ufromail"

         */
        System.out.println("si es ufromail");
        if (correo.contains("ufromail") && correo.contains(".cl")) {
            System.out.println("cumple con el dominio institucional ");
        }

        System.out.println("probando posicion de '.'");
        char[] evaluar = correo.toCharArray();
        int aux = 0;

        for (int i = 0; i < evaluar.length; i++) {


            if ((evaluar[1] == '.')) {
                System.out.println("hay un punto en la posicion 1");
                aux++;
            } else {
                System.out.println("no hay un punto de donde corresponde");
            }
                if ((evaluar[evaluar.length - 3] == '.')) {
                    System.out.println("hay  punto en la anteantepenultima posicion ");
                    aux++;

                }

                if (aux == 2) {
                    System.out.println("ta  bien");
                    aux = 0;
                    break;

                } else {
                    System.out.println("ta mal. hay mas puntos de los necesarios");
                    aux = 0;
                    break;
                }


            }
            return correo;
        }



    }



