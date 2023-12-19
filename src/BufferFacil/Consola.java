package BufferFacil;

import java.util.Scanner;

public class Consola {
    public static String pedirString(){
        Scanner consola = new Scanner(System.in);
        String entrada = consola.nextLine();
        return entrada;
    }
    public static float pedirFloat(boolean positivo){
        Scanner consola = new Scanner(System.in);
        String entrada = consola.nextLine();
        float numero = 0;
        try{
            numero = Float.parseFloat(entrada);
            if(numero <= 0 && positivo){
                System.out.println("Debes introducir un número mayor que 0");
                return pedirFloat(positivo);
            } else {
                return numero;
            }
        } catch(Exception e){
            if(positivo){
                System.out.println("Debes introducir un número mayor que 0, usa . para especificar decimales");
            } else {
                System.out.println("Debes introducir un número, usa . para especificar decimales");
            }
            return pedirFloat(positivo);
        }
    }
    public static int pedirInt(boolean positivo){
        Scanner consola = new Scanner(System.in);
        String entrada = consola.nextLine();
        int numero = 0;
        try{
            numero = Integer.parseInt(entrada);
            if(numero < 1 && positivo){
                System.out.println("Debes introducir un número entero mayor que 0");
                return pedirInt(positivo);
            } else {
                return numero;
            }
        } catch(Exception e){
            if(positivo){
                System.out.println("Debes introducir un número entero mayor que 0");
            } else {
                System.out.println("Debes introducir un número entero");
            }
            return pedirInt(positivo);
        }
    }
    public static boolean pedirBool(){
        decir("(s/n)");
        Scanner consola = new Scanner(System.in);
        String entrada = consola.nextLine();
        entrada = entrada.toLowerCase();
        if (entrada.equals("y") || entrada.equals("s") || entrada.equals("1") || entrada.equals("si") || entrada.equals("yes")){
            return true;
        } else {
            return false;
        }
    }
    public static void decir(String txt){
        System.out.println(txt);
    }
}
