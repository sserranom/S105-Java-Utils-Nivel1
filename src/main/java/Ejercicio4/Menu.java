package Ejercicio4;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private ManageDirectory manageDirectory;
    private final Scanner input;

    public Menu(ManageDirectory manageDirectory, Scanner input) {
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
                    System.out.println("\nIngresa la ruta relativa del directorio que quieres listar: \n");
                    String relativePath = input.nextLine();
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

                break;

            case 2:

                System.out.println("\nIngrese la ruta del directorio a Leer: \n");
                String filePath = input.nextLine();

                try {
                    List<String> fileContents = manageDirectory.readFile(filePath);
                    for (String line : fileContents) {
                        System.out.println(line);
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

            default:
                System.out.println("Opción invalida");
        }
    }

}
