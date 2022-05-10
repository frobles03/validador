import java.text.Normalizer;
import java.util.*;
import java.lang.*;
import java.io.*;
public class validadores {
    //static String str = "f.roblès03@ufromail.cl FERnanDO +!#$%&/(=?¡ñ  ípsilon o ipsilão)";
    static String str="f.robles03@ufromail.cl";
    public static void main(String[] args) {

    //caracteresEspeciales();
        ufromail();
        System.out.println("se va a cerrar el programa");
        //System.exit(0);




            }

    public static void caracteresEspeciales(){
        ////si tiene "." o "@"///
        /*
        pero que pasa si le pongo muchos "." o "@"
        solo tiene que haber 1 "@" y 2"."
         */

        System.out.println("se borraran todos los caracteres con acento");
        String cadenaNormalize = Normalizer.normalize(str, Normalizer.Form.NFD);
        String cadenaSinAcentos = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
        System.out.println("Resultado sin acento: " + cadenaSinAcentos);
        System.out.println("resultado sin caracteres especiales: ");
        String  result2 = str.replaceAll("[-+!#$%&'*ñ/=?^_`~+¡?=)(,~`;:_.,><'+}]*", "");//le faltan cosas por agregar
        System.out.println(result2);
        System.out.println("resultado en minuscula");
        System.out.println(str.toLowerCase());//transforma a minuscula
        System.out.println("fin");






//string que lo recorra  y ver si hay dos @ iguales

        /*
        char[] charSearch = {'.', '@'};
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    System.out.println("el caracter " + charSearch[j] + " se encuentra en " + str);
                }
                */
            }


    public static void ufromail(){

        ///////si es ufromail//////
        /*
        y si el ufromail esta antes de la "@"?
        y si el ".cl" no esta despues de "ufromail"
         */
        System.out.println("si es ufromail");
        if (str.contains("ufromail") && str.contains(".cl") ) {
            System.out.println("cumple con el dominio institucional ");
        }
        System.out.println("asd");
        char[] evaluar=str.toCharArray();
        int aux=0;
        for(int i=0;i<evaluar.length;i++)
        {
            if((evaluar[1]=='.')){
                System.out.println("hay un punto en la posicion 1");
                aux++;
            }
            if ((evaluar[evaluar.length-3]=='.') ){
                System.out.println("hay  punto en la anteantepenultima posicion ");
                aux++;

            }
            if(aux==2){
            System.out.println("ta  bien");
            aux=0;
            break;

            }else{
            System.out.println("ta mal");
            break;
            }

        }


        }



}



        /*
        ////analizar la divicion entre los dos "."////
        //servira ahora dividir el mail??
        System.out.println("separacion \n");


        /*no se como lo hice pero funciona
        averiguar para posterior documentacion
        hacer que el validador solo funcione con 3 puntos, si son mas no funciona
        se podra dividir un String con tokenizer teniendo en cuenta que el numero que quiero separa va entre 01 y 99


        StringTokenizer tokens = new StringTokenizer(str, ". @");
        String[] newStr = new String[tokens.countTokens()];
        int index = 0;
        while (tokens.hasMoreTokens()) {

            System.out.println("separacion: " + index);
            newStr[index] = tokens.nextToken();
            System.out.println(newStr[index]);
            if (index == 1) {
                System.out.println("se va a guardar la seccion: " + newStr[1]);
                String evaluar = newStr[1];
                System.out.println("se guardo: " + evaluar +"\n" + "solo se guardaran los numeros de  la palabra guardada");
                //no sirve mejor buscar algo que reconosoca los numeros y los guarde
                String noLetras=evaluar.replaceAll("\\D+","");
                System.out.println("los numeros fueron: "+noLetras);
                break;
            }


            index++;
                */






















