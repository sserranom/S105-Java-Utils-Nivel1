package Ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngresa la ruta relativa del directorio: \n");
        String relativePath = scanner.nextLine();
        scanner.close();

        try {
            ListDirectory listDirectory = new ListDirectory(relativePath);
            listDirectory.listFiles();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}