import java.util.*;
import BufferFacil.*;

public class App {
    //agregar: parentesis, mas de dos operandos
    
    public static void main(String[] args) throws Exception {
        try{
            preguntas();
        } catch (Exception e){
            Consola.decir("Ha habido un error, inicia el programa e nuevo");
            System.exit(0);
        }
        try{
            sesion();
        } catch (Exception e){
            Consola.decir("Ha habido un error, inicia el programa e nuevo");
            System.exit(0);
        }
    }
    static int ejercicios = 0;
    static float maximo = 0;
    static boolean decimales = false;
    static String nombre = "";

    static boolean suma = false;
    static boolean resta = false;
    static boolean multiplicaion = false;
    static boolean division = false;

    static int aciertos = 0;
    

    static void preguntas(){
        Consola.decir("Bienvenido a FastCalc 1.0, el programa para entrenar el calculo mental");
        Consola.decir("¿Cuál es tu nombre?");
        nombre = Consola.pedirString();
        Consola.decir("¿Cuantas operaciones quieres hacer esta sesión?");
        ejercicios = Consola.pedirInt(true);
        Consola.decir("¿Quieres usar decimales?");
        decimales = Consola.pedirBool();
        Consola.decir("¿Como de grandes quieres que sean los números?");
        if(decimales){
            maximo = Consola.pedirFloat(true);
        } else {
            maximo = (float)Consola.pedirInt(true);
        }
        boolean validarOperadores = false;
        while (!validarOperadores) {
            validarOperadores = true;
            Consola.decir("¿Qué quieres practicar?");
            Consola.decir("A = sumas");
            Consola.decir("B = restas");
            Consola.decir("C = multiplicaciones");
            Consola.decir("D = divisiones");
            Consola.decir("E = sumas y restas");
            Consola.decir("F = multiplicaciones y divisiones");
            Consola.decir("G = sumas y multiplicaciones");
            Consola.decir("H = restas y divisiones");
            Consola.decir("I = todo");
            Consola.decir("J = me ha dado pereza quita quita");
            String decision = Consola.pedirString();
            decision = decision.toLowerCase();
            switch (decision) {
                case "A":
                    suma = true;
                    break;
                case "B":
                    resta = true;
                    break;
                case "C":
                    multiplicaion = true;
                    break;
                case "D":
                    division = true;
                    break;
                case "E":
                    suma = true;
                    resta = true;
                    break;
                case "F":
                    multiplicaion = true;
                    division = true;
                    break;
                case "G":
                    suma = true;
                    multiplicaion = true;
                    break;
                case "H":
                    resta = true;
                    division = true;
                    break;
                case "I":
                    suma = true;
                    resta = true;
                    multiplicaion = true;
                    division = true;
                    break;
                case "J":
                    Consola.decir("adio joputa");
                    System.exit(0);
                    break;
                default:
                    Consola.decir("Error con la validacion");
                    validarOperadores = false;
                    break;
            }
        }

        Consola.decir("Muy bien " + nombre + ", ya está todo listo para empezar, pulsa enter cuando estés preparado y con el cronómetro activado:");
        Consola.pedirString();
        Consola.decir(""); Consola.decir(""); Consola.decir(""); Consola.decir(""); Consola.decir("");
    }
    static void sesion(){
        for(int i = 0; i < ejercicios; i++){

        }
    }
}
