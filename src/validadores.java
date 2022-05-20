import java.text.Normalizer;
import java.util.*;
import java.lang.*;
import java.io.*;
public class validadores {
    //static String correo = "f.roblès03@ufromail.cl FERnanDO +!#$%&/(=?¡ñ  ípsilon o ipsilão)";
    static String correo = "f.robles03@ufromail.cl";
    static String clave = "patata";

    static String nickName = "f.robles03";

    public static void main(String[] args) {


        validadores val1 = new validadores("f.robles03@ufromail.cl", "patata", "flan");
        val1.setNickName(genenradorNickName());
        System.out.println(nickName);

    }

    public validadores(String correo, String clave, String nickName) {
        this.correo = correo;
        this.clave = clave;
        this.nickName = nickName;

    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
        System.out.println("Resultado sin acento: " + cadenaSinAcentos);

        System.out.println("resultado sin caracteres especiales: ");
        String result2 = correo.replaceAll("[-+!#$%&'*ñ/=?^_`~+¡?=)(,~`;:_.,><'+}]*", "");//le faltan cosas por agregar
        System.out.println(result2);
        System.out.println("resultado en minuscula");
        System.out.println(correo.toLowerCase());//transforma a minuscula
        System.out.println("fin");


//string que lo recorra  y ver si hay dos @ iguales

        /*
        char[] charSearch = {'.', '@'};
        for (int i = 0; i < correo.length(); i++) {
            char chr = correo.charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    System.out.println("el caracter " + charSearch[j] + " se encuentra en " + correo);
                }
                */
    }


    public static String ufromail() {

        ///////si es ufromail//////
        /*
        y si el ufromail esta antes de la "@"?
        y si el ".cl" no esta despues de "ufromail"
        todo eso analaizar con array en las posicoinbes
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


        return null;
    }

    public static String validadorArroba() {
        char[] evaluar2 = correo.toCharArray();
        int aux2 = 0;
        String num = "0123456789";
        char[] numChar = num.toCharArray();


        for (int i = 0; i < evaluar2.length; i++) {
            for (int j = 0; j < numChar.length; j++) {
                if (evaluar2[i] == numChar[j]) {
                    System.out.println("numeros encontrados:" + numChar[j]);
                    aux2++;
                    System.out.println(aux2);
                    break;
                }
            }

            if (aux2 >= 2) {
                System.out.println("correo no valido");
                //podra exisitir el correo 00?
                aux2 = 0;
                break;
            }


        }
        return correo;
    }

    public static String genenradorNickName() {

        ////analizar la divicion entre los dos "."////
        //servira ahora dividir el mail??
        System.out.println("separacion \n");

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

            System.out.println("separacion: " + index);
            newcorreo[index] = tokens.nextToken();
            System.out.println(newcorreo[index]);
            if (index == 1) {
                System.out.println("se va a guardar la seccion: " + newcorreo[0]);
                String evaluar = newcorreo[0];
                System.out.println("se guardo: " + evaluar  + ", ahora sera tu nickname");
                evaluar=nickName;
                break;
            }


            index++;



        }
        System.out.println(nickName);
        return nickName;
    }

}




















































































