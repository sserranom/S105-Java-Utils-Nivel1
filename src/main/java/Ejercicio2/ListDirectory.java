package Ejercicio2;

import java.nio.file.Paths;
import java.io.File;
import java.util.Arrays;

public class ListDirectory {

    private File directory;

    public ListDirectory(String pathDirectory) {
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
            System.out.println("  ".repeat(level) + "[Vacío] " + dir.getName());
            return;
        }

        Arrays.sort(directoryContent);

        for (String content : directoryContent) {
            File subFile = new File(dir, content);
            System.out.println("  ".repeat(level) + (subFile.isDirectory() ? "(D) " : "(F) ") + content);

            if (subFile.isDirectory()) {
                listFilesRecursive(subFile, level + 1);
            }
        }
    }


}
