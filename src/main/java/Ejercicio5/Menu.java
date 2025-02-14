package Ejercicio5;

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
        System.out.println("1. Listar un Directorio. \n" +
                "2. Leer un archiv.txt.\n" +
                "3. Serializar un Archivo.\n" +
                "4. Desserializar un archivo. \n");

        int option = input.nextInt();
        input.nextLine();
        String relativePath;
        switch (option) {

            case 1:
                try {
                    System.out.println("\nIngresa la ruta relativa del directorio que quieres listar: \n");
                    relativePath = input.nextLine();
                    ManageDirectory manageDirectory = new ManageDirectory(relativePath);
                    System.out.print("Ingresa la ruta y el nombre del archivo donde deseas guardar el contenido (.txt): \n");
                    String path = input.nextLine();
                    for (String content : manageDirectory.listFiles()) {
                        System.out.println(content);
                        manageDirectory.saveDirectoryContentInTxt(path, content);
                    }
                    System.out.println("Ruta actual: " + System.getProperty("user.dir"));
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

            case 3:

                System.out.println("Ingrese la ruta del directorio: \n");
                String originFilePath = input.nextLine();
                System.out.println("Ingrese la ruta y nombre donde guardar el Objeto serializado: \n");
                String destinationFilePath = input.nextLine();
                try {
                    ManageDirectory serialziarObj = new ManageDirectory();
                    serialziarObj.serializeFile(originFilePath, destinationFilePath);
                    System.out.println("Archivo serializado con éxito.");
                } catch (RuntimeException e) {
                    System.err.println("Ocurrió un error: " + e.getMessage());
                }
                break;

            case 4:

                System.out.println("Ingrese la ruta del Archivo que desea Deserializar:");
                relativePath = input.nextLine();
                try {
                    manageDirectory = manageDirectory.deserializeFile(relativePath);
                    for (String content : manageDirectory.filesList) {
                        System.out.println(content);
                    }
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al deserializar el archivo: " + e.getMessage());
                }
                break;

            default:
                System.out.println("Opcion invalida");
        }
    }

}
