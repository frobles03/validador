import java.text.Normalizer;
import java.util.StringTokenizer;
import java.text.Normalizer;
import java.util.*;
import java.lang.*;

public class main {




        // static String correo = "B.s場мале.нькоеيوتيوتيوبдерево合にはáEz01@ufromail.com.mx.arg";
        //static String correo="f.roblоеيوتيوتيوبдерево合にes@ufromail.cl";
        static String correo=("f´.Ró´blوتيوبдерéŠťŕĭńġs03@ufromail.cl");
    static String nickName;

        public static void main(String[] args) {
            System.out.println("tu correo es: "+correo);
            System.out.println("\n+-------------------+\n");
           // validadorUfromail();
            System.out.println("\n+-------------------+\n");
            noCaracteresEspeciales();
            System.out.println("\n+-------------------+\n");
            //generadorNickname();
        }
        public static String generadorNickname() {
            System.out.println( "se generarar tu nickname");
            StringTokenizer tokens = new StringTokenizer(correo, " @");
            String[] newcorreo = new String[tokens.countTokens()];
            int index = 0;
            while (tokens.hasMoreTokens()) {


                newcorreo[index] = tokens.nextToken();

                if (index == 1) {

                    String evaluar = newcorreo[0];

                    nickName=evaluar;
                    break;
                }


                index++;

            }
            System.out.println(nickName);
            return nickName;
        }

        public static void noCaracteresEspeciales() {
            System.out.println("se eliminaran caracteres no deseados, como por ejemplo: ");
            System.out.println("-acentos\n-caracteres que no perteneciente al alfabeto ingles ");
            //posible codigo duplicado
            String cadenaNormalize = Normalizer.normalize(correo, Normalizer.Form.NFD);//borra caracteres con acento
            System.out.println("resultado: "+cadenaNormalize);

            String cadenaSinAcentos = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
            System.out.println("resultado de replaceall: "+cadenaSinAcentos);
            correo=cadenaSinAcentos;

            String cadenaSinCaracteresEsp = correo.replaceAll("[-+!#$%&'*ñ/=?^_`~+¡?=)(,~`;:_,><'+}]*", "");//borra caracteres especiales señalados
            correo=cadenaSinCaracteresEsp;

            correo=correo.toLowerCase();//resultado en minuscula

            System.out.println("Resultado final: "+correo);


        }

        public static String validadorUfromail() {

            System.out.println("se verificara si es ufromail");
            if (correo.contains("ufromail") && correo.contains(".cl")) {
                System.out.println("Su correo posee el dominio 'ufromail.cl' ");
            }else{
                System.out.println("NO CUMPLE con el dominio institucional\n vuelva a inentarlo ");
                System.exit(0);

            }

            char[] evaluar = correo.toCharArray();
            int aux = 0;

            for (int i = 0; i < evaluar.length; i++) {


                if ((evaluar[1] == '.')) {//ve si hay un punto en la posicion 1
                    aux++;
                } else {
                    //System.out.println("no hay un punto de donde corresponde")
                }
                if ((evaluar[evaluar.length - 3] == '.')) {//ve si hay un punto en la anteantepenultima posicion
                    aux++;

                }
                //mensaje de aceptacion o error
                if (aux == 2) {
                    System.out.println("su correo CUMPLE con el estandar del correo institucional");
                    aux = 0;
                    break;

                } else {
                    System.out.println("su correo NO CUMPLE con el estandar del correo institucional");
                    aux = 0;
                    break;
                }


            }
            return correo;
        }

    }







