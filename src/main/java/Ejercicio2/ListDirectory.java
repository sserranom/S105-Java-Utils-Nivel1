package Ejercicio2;

import java.nio.file.Paths;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDirectory {

    private final File DIRECTORY;

    public ListDirectory(String pathDirectory) {
        this.DIRECTORY = Paths.get(System.getProperty("user.dir"), pathDirectory).toAbsolutePath().normalize().toFile();

        if (!DIRECTORY.isDirectory()) {
            throw new IllegalArgumentException("La ruta no es Válida" + pathDirectory);
        }
    }

    public List<String> listFiles() {

        return listFilesRecursive(DIRECTORY, 0);

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

}
