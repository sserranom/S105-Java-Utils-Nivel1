package Ejercicio3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.io.FileWriter;

public class ManageDirectory {

    private File directory;
    private static final String FILE_NAME = "directoryContent.txt";
    private boolean firstWrite = true;

    public ManageDirectory(String pathDirectory) {
        this.directory = Paths.get(System.getProperty("user.dir"), pathDirectory).toAbsolutePath().normalize().toFile();

        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("La ruta no es Válida" + pathDirectory);
        }
    }

    public void listFiles() {

        listFilesRecursive(directory, 0);
    }

    private void listFilesRecursive(File dir, int level) {
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
            saveDirectoryContentInTxt(line);

            if (subFile.isDirectory()) {
                listFilesRecursive(subFile, level + 1);
            }
        }
    }

    private void saveDirectoryContentInTxt(String directoryTxt) {

        try (FileWriter writer = new FileWriter(FILE_NAME, !firstWrite)) {
            if (firstWrite){
                writer.write("*******Contenido del Fichero*******\n\n");
                firstWrite= false;
            }
            writer.write(directoryTxt + "\n");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

    }
}
