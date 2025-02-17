package Ejercicio4;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManageDirectory {

    private File directory;

    public ManageDirectory(String pathDirectory) {
        this.directory = new File(pathDirectory);

        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("La ruta no es Válida " + pathDirectory);
        }
    }

    public ManageDirectory() {

    }

    public List<String> listFiles() {

        return listFilesRecursive(directory, 0);

    }

    private List<String> listFilesRecursive(File dir, int level) {
        List<String> fileList = new ArrayList<>();
        String[] directoryContent = dir.list();

        if (directoryContent == null || directoryContent.length == 0) {
            fileList.add("  ".repeat(level) + "[Vacío] " + dir.getName());
            return fileList;
        }

        Arrays.sort(directoryContent);

        for (String content : directoryContent) {
            File subFile = new File(dir, content);
            String fileType = subFile.isDirectory() ? "(D) " : "(F) ";
            fileList.add("  ".repeat(level) + fileType + content);

            if (subFile.isDirectory()) {
                fileList.addAll(listFilesRecursive(subFile, level + 1));
            }
        }
        return fileList;
    }

    public void saveDirectoryContentInTxt(String filePath, String content) {
        File file = new File(filePath);
        boolean exists = file.exists();

        try (FileWriter writer = new FileWriter(file, true)) {
            if (!exists) {
                writer.write("*******Contenido del Fichero*******\n\n");
            }
            writer.write(content + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo: " + e.getMessage(), e);
        }
    }

    public List<String> readFile(String filePath) {
        File file = new File(filePath);
        List<String> fileContents = new ArrayList<>();

        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException("El archivo no existe o la ruta es incorrecta.");
        }

        try (BufferedReader read = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = read.readLine()) != null) {
                fileContents.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + e.getMessage());
        }

        return fileContents;
    }
}
