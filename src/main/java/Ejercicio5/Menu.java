package Ejercicio5;

import java.util.Scanner;

public class Menu {
    private final Ejercicio4.ManageDirectory manageDirectory;
    private final Scanner input;

    public Menu(Ejercicio4.ManageDirectory manageDirectory, Scanner input) {
        this.manageDirectory = manageDirectory;
        this.input = input;
    }

    public void ShowMenu() {
        System.out.println("\n******Elije la Operacion que deseas Realizar:*******\n ");
        System.out.println("1. Listar un Directorio. \n2. Leer un archiv .txt\n");

        int option = input.nextInt();
        input.nextLine();

        switch (option) {

            case 1:
                try {
                    System.out.print("Ingresa la ruta relativa del directorio: ***Ejemplo: ..\\S103-Collections-Nivel1*** \n");
                    String relativePath = input.nextLine();
                    Ejercicio4.ManageDirectory manageDirectory = new Ejercicio4.ManageDirectory(relativePath);
                    manageDirectory.listFiles();
                    System.out.println("\n Contenido guardado en 'directoryContent.txt'");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

            case 2:

                ManageDirectory manageDirectory = new ManageDirectory();
                System.out.println("\nIngrese la ruta del directorio a Leer: \n");
                String filePath = input.nextLine();
                manageDirectory.readFile(filePath);
                break;

            default:
                System.out.println("Opcion invalida");
        }
    }

}
