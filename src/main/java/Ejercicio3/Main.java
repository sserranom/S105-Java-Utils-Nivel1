package Ejercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("\n *******LISTA UN ARBOL CON EL CONTENIDO DE TODOS SUS SUBNIVELES Y LOS GUARDA EN UN ARCHIVO .TXT*******\n");
        System.out.print("Ingresa la ruta relativa del directorio: \n");
        String relativePath = input.nextLine();


        try {
            ManageDirectory manageDirectory = new ManageDirectory(relativePath);
            System.out.print("Ingresa la ruta y el nombre del archivo donde deseas guardar el contenido (.txt): \n");
            String path = input.nextLine();
            for (String content : manageDirectory.listFiles()) {
                System.out.println(content);
                manageDirectory.saveDirectoryContentInTxt(path, content);
            }

            System.out.println("\n Contenido guardado en: " + path);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}