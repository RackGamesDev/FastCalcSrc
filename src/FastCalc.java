import java.util.*;
import BufferFacil.*;

public class FastCalc {
    //agregar: parentesis, mas de dos operandos
    
    public static void main(String[] args) throws Exception {
        try{
            preguntas();
        } catch (Exception e){
            Consola.decir("Ha habido un error, inicia el programa e nuevo");
            System.exit(0);
        }
        contandoTiempo = true;
        temporizador();
        try{
            sesion();
        } catch (Exception e){
            Consola.decir("Ha habido un error, inicia el programa de nuevo");
            System.exit(0);
        }
        resultados();
    }
    static int ejercicios = 0;
    static float maximo = 0;
    static boolean decimales = false;
    static boolean negativos = false;
    static String nombre = "";

    static boolean suma = false;
    static boolean resta = false;
    static boolean multiplicaion = false;
    static boolean division = false;

    static int aciertos = 0;
    static int tiempo = 0;
    static boolean contandoTiempo =  false;
    

    static void preguntas(){
        Consola.decir("Bienvenido a FastCalc 1.0, el programa para entrenar el calculo mental");
        Consola.decir("¿Cuál es tu nombre?");
        nombre = Consola.pedirString(true);
        Consola.decir("¿Cuantas operaciones quieres hacer esta sesión?");
        ejercicios = Consola.pedirInt(true);
        Consola.decir("¿Quieres usar decimales?");
        decimales = Consola.pedirBool();
        Consola.decir("¿Quieres usar números negativos?");
        negativos = Consola.pedirBool();
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
            String decision = Consola.pedirString(true);
            decision = decision.toLowerCase();
            switch (decision) {
                case "a":
                    suma = true;
                    break;
                case "b":
                    resta = true;
                    break;
                case "c":
                    multiplicaion = true;
                    break;
                case "d":
                    division = true;
                    break;
                case "e":
                    suma = true;
                    resta = true;
                    break;
                case "f":
                    multiplicaion = true;
                    division = true;
                    break;
                case "g":
                    suma = true;
                    multiplicaion = true;
                    break;
                case "h":
                    resta = true;
                    division = true;
                    break;
                case "i":
                    suma = true;
                    resta = true;
                    multiplicaion = true;
                    division = true;
                    break;
                case "j":
                    Consola.decir("adios");
                    System.exit(0);
                    break;
                default:
                    Consola.decir("Error con la validacion");
                    validarOperadores = false;
                    break;
            }
        }

        Consola.decir("Muy bien " + nombre + ", ya está todo listo para empezar, pulsa enter cuando estés preparado y con el cronómetro activado:");
        Consola.pedirString(false);
        Consola.decir(""); Consola.decir(""); Consola.decir(""); Consola.decir(""); Consola.decir("");

    }
    static void temporizador(){
        Timer temporizador = new Timer();
        TimerTask tarea = new TimerTask() {
            public void run(){
                if(contandoTiempo){
                    tiempo++;
                }
            }
        };
        temporizador.schedule(tarea, 0, 1000);
    }
    static void sesion(){
        for(int i = 0; i < ejercicios; i++){
            float numA = 0;
            float numB = 0;
            if(decimales){
                numA = Math.round(((float)Math.random() * maximo * 2 - maximo + 1) * 100f) / 100f;
                numB = Math.round(((float)Math.random() * maximo * 2 - maximo + 1) * 100f) / 100f;
            } else {
                numA = (int)Math.floor(Math.random() * maximo * 2 - maximo + 1);
                numB = (int)Math.floor(Math.random() * maximo * 2 - maximo + 1);
            }
            if (!negativos) {
                if (numA < 0) {
                    numA *= -1;
                }
                if (numB < 0) {
                    numB *= -1;
                }
            }
            String operacion = "";
            float resultado = 0;
            while(operacion == ""){
                int curOperacion = (int)Math.floor(Math.random() * 5);
                if(curOperacion == 1 && suma){
                    operacion="+";
                } else if(curOperacion == 2 && resta){
                    operacion="-";
                } else if(curOperacion == 3 && multiplicaion){
                    operacion="*";
                } else if(curOperacion == 4 && division){
                    operacion="/";
                }
            }
            switch (operacion) {
                case "+":
                    resultado = numA + numB;
                    break;
                case "-":
                    resultado = numA - numB;
                    break;
                case "*":
                    resultado = numA * numB;
                    break;
                case "/":
                    if(numB > numA && !decimales){
                        float temp = numA;
                        numA = numB;
                        numB = temp;
                    }
                    if(numA == 0 || numB == 0){
                        numA++;
                        numB++;
                    } else {
                        resultado = numA / numB;
                    }
                    break;
                default:
                    break;
            }
            if(decimales){
                Consola.decir(">  " + numA + " " + operacion + " " + numB + " =");
            } else {
                Consola.decir(">  " + (int)numA + " " + operacion + " " + (int)numB + " =");
            }
            float resultadoConsola = Consola.pedirFloat(false);
            if(resultado == resultadoConsola){
                Consola.decir("Correcto!");
                Consola.decir("");
                aciertos++;
            } else {
                if(decimales){
                    resultado = Math.round(resultado * 100f) / 100f;
                    Consola.decir("Incorrecto, la respuesta era " + resultado);
                } else {
                    Consola.decir("Incorrecto, la respuesta era " + (int)resultado);
                }
                Consola.decir("");
            }
        }
    }
    static void resultados(){
        Consola.decir("");
        Consola.decir("Sesión terminada, estos son tus resultados:");
        Consola.decir("Aciertos= " + aciertos + "/" + ejercicios);
        float porcentaje = (float)((float)aciertos / (float)ejercicios * 100);
        if (porcentaje >= 50) {
            Consola.decir("Porcentaje acertado= " + porcentaje + "%, has aprobado");
        } else {
            Consola.decir("Porcentaje acertado= " + porcentaje + "%, has suspendido");
        }
        Consola.decir("Segundos tardados = " + tiempo);
        Consola.decir("");        
        Consola.decir("Para volver a empecar cierra el programa con Ctrl+C y vuelvelo a abrir...");
        Consola.decir("");
    }
}
