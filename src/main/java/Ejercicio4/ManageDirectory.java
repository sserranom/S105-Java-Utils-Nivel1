package Ejercicio4;

import java.io.*;
import java.nio.file.Paths;
import java.util.Arrays;

public class ManageDirectory {

    private File directory;
    private static final String FILE_NAME = "directoryContent.txt";

    public ManageDirectory(String pathDirectory) {
        this.directory = Paths.get(System.getProperty("user.dir"), pathDirectory).toAbsolutePath().normalize().toFile();

        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("La ruta no es Válida " + pathDirectory);
        }
    }

    public ManageDirectory() {

    }

    public void listFiles() {

        boolean fileExists = new File(FILE_NAME).exists();
        listFilesRecursive(directory, 0, !fileExists);
    }

    private void listFilesRecursive(File dir, int level, boolean firstWrite) {
        String[] directoryContent = dir.list();

        if (directoryContent == null || directoryContent.length == 0) {
            System.out.println("    ".repeat(level) + "[Vacío] " + dir.getName());
            return;
        }

        Arrays.sort(directoryContent);

        for (String content : directoryContent) {
            File subFile = new File(dir, content);
            String line = ("    ".repeat(level) + (subFile.isDirectory() ? "(D)" : "(F) ") + content);
            System.out.println(line);
            saveDirectoryContentInTxt(line, firstWrite);

            if (subFile.isDirectory()) {
                listFilesRecursive(subFile, level + 1, false);
            }
        }
    }

    private void saveDirectoryContentInTxt(String directoryTxt, boolean firstWrite) {

        try (FileWriter writer = new FileWriter(FILE_NAME, !firstWrite)) {
            if (firstWrite) {
                writer.write("*******Contenido del Fichero*******\n\n");

            }
            writer.write(directoryTxt + "\n");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

    }

    public void readFile(String filePath) {

        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            System.err.println("Error: El archivo no existe o la ruta es incorrecta.");
            return;
        }

        try (BufferedReader read = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Contenido del archivo " + filePath + ":");
            while ((line = read.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
