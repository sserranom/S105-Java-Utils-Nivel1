package Ejercicio1;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ListDirectory {

    private final File DIRECTORY;

    public ListDirectory(String pathDirectory) {
        this.DIRECTORY = new File(pathDirectory);

        if (!DIRECTORY.isDirectory()) {
            throw new IllegalArgumentException("La ruta no es Válida");
        }
    }

    public List<String> listFiles() {
        String[] directoryContent = DIRECTORY.list();

        if (directoryContent == null) {
            return List.of(new String[0]);
        }
        Arrays.sort(directoryContent);
        return List.of(directoryContent);
    }

}
