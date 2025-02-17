package Ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n*******LISTA EL CONTENIDO DE UN DIRECTORIO*******\n");
        System.out.print("Ingresa la ruta del directorio que desa listar: \n");
        String relativePath = scanner.nextLine();
        scanner.close();

        try {
            ListDirectory listDirectory = new ListDirectory(relativePath);
            for (String content : listDirectory.listFiles()) {
                System.out.println(content);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}