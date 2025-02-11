package Ejercicio1;

import java.io.File;
import java.util.Arrays;

public class ListDirectory {

    private File directory;

    public ListDirectory(String pathDirectory) {
        this.directory = new File(System.getProperty("user.dir") + File.separator + pathDirectory);

        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("La ruta no es Válida");
        }
    }

    public void listFiles() {
        String[] directoryContent = directory.list();

        if (directoryContent != null && directoryContent.length > 0) {
            Arrays.sort(directoryContent);

            for (String content : directoryContent) {
                System.out.println(content);
            }
        } else {
            System.out.println("No Archivos en el directorio");
        }
    }
}
