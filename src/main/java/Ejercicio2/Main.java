package Ejercicio2;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("\n*******LISTA UN ARBOL DE DIRECTORIO CON EL CONTENIDO DE TODOS SUS NIVELES*******\n");
        System.out.print("Ingresa la ruta relativa del directorio: \n");
        String relativePath = input.nextLine();
        input.close();

        try {
            ListDirectory listDirectory = new ListDirectory(relativePath);
            List<String> contents = listDirectory.listFiles();
            for (String listContent : contents){
                System.out.println(listContent);
            }

       } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
       }

    }
}