package Ejercicio5;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class ManageDirectory implements Serializable {

    private static final long serialVersionUID = 691435423235927464L;
    private File directory;
    private String fileName;
    private String content;
    List<String> filesList;


    public ManageDirectory(String pathDirectory) {
        this.directory = new File(pathDirectory);

        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("La ruta no es Válida " + pathDirectory);
        }
        this.filesList = listFiles();
    }


    public ManageDirectory() {
        this.filesList = new ArrayList<>();
    }

    public String getFileName() {
        return fileName;
    }

    public String getContent() {
        return content;
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

    public void serializeFile(String directoryPath, String destinationFilePath) {

        ManageDirectory directoryToSerialize = new ManageDirectory(directoryPath);

        List<String> sortedFilesList = directoryToSerialize.listFiles();
        sortedFilesList.sort(String::compareTo);
        directoryToSerialize.filesList = sortedFilesList;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(destinationFilePath))) {
            oos.writeObject(directoryToSerialize);
        } catch (IOException e) {
            throw new RuntimeException("Error al serializar el objeto: " + e.getMessage(), e);
        }
    }


    public ManageDirectory deserializeFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (ManageDirectory) ois.readObject();
        }
    }
}
