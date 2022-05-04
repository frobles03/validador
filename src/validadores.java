import java.util.*;
import java.lang.*;
import java.io.*;
public class validadores {

    public static void main(String[] args) {
        String str = "f.robles03@ufromail.cl";

        ////si tiene "." o "@"///
        /*
        pero que pasa si le pongo muchos "." o "@"
        solo tiene que haber 1 "@" y 2"."
         */
        char[] charSearch = {'.', '@'};
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    System.out.println("el caracter " + charSearch[j] + " se encuentra en " + str);
                }
            }
        }


        ///////si es ufromail//////
        /*
        y si el ufromail esta antes de la "@"?
        y si el ".cl" no esta despues de "ufromail"
         */
        System.out.println("si es ufro mail");
        if (str.contains("ufromail")) {
            System.out.println("cumple con el dominio");
        }
        if (str.contains(".cl")) {
            System.out.println("cumple con el ultimo requisito");
        }


        ////analizar la divicion entre los dos "."////
        System.out.println("separacion \n");


        /*no se como lo hice pero funciona
        averiguar para posterior documentacion
        hacer que el validador solo funcione con 3 puntos, si son mas no funciona
        se podra dividir un String con tokenizer teniendo en cuenta que el numero que quiero separa va entre 01 y 99

         */
        StringTokenizer tokens = new StringTokenizer(str, ". @");
        String[] newStr = new String[tokens.countTokens()];
        int index=0;
        while(tokens.hasMoreTokens()){
            newStr[index] = tokens.nextToken();
            System.out.println(newStr[index]);
            index++;
        }
    }


}
