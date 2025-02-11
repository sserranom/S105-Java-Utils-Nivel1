package Ejercicio3;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la ruta relativa del directorio: ***Ejemplo: ..\\S103-Collections-Nivel1*** \n");
        String relativePath = scanner.nextLine();
        scanner.close();

        try {
            ManageDirectory manageDirectory = new ManageDirectory(relativePath);
            manageDirectory.listFiles();
            System.out.println("\n Contenido guardado en 'directoryContent.txt'");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}