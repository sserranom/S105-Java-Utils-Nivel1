***S0104-Java Utils N1***

- Ejercicio 1
Crea una clase que liste alfabéticamente el contenido de un directorio recibido por parámetro.

- Ejercicio 2
Añade a la clase del ejercicio anterior, la funcionalidad de listar un árbol de directorios con el contenido de todos sus nivele s(recursivamente) de forma que se impriman
en pantalla en orden alfabético dentro de cada nivel,indicando además si es un directorio (D) o un archivo (F), y su última fecha de modificación.

- Ejercicio 3
Modifica el ejercicio anterior. Ahora, en lugar de mostrar el resultado por la pantalla, guarda el resultado en un archivo TXT.

- Ejercicio 4
Añade la funcionalidad de leer cualquier archivo TXT y muestra su contenido por consola.

- Ejercicio 5
Ahora el programa debe serializar un Objeto Java a un archivo .ser y después debe desserializarlo.

***Tecnologías Utilizadas***

-Lenguaje: Java version "23.0.1" 2024-10-15 -IDE: IntelliJ IDEA 

***Requisitos***

1.Java ( JDK 17 o superior) 
2.IntelliJ IDEA: Puedes descargarlo desde el sitio oficial de JetBrains. 
3. Maven: Si no tienes Maven instalado, sigue las instrucciones en la documentación oficial.

**Instalacion**

Clona este repositorio:https://github.com/sserranom/S105-Java-Utils-Nivel1.git
En IntelliJ IDEA. Ve a "File" -> "Open" y selecciona la carpeta donde clonaste el repositorio. IntelliJ detectará automáticamente el archivo pom.xml y descargará las dependencias de Maven.
Compila el proyecto con Maven: En IntelliJ IDEA, abre el terminal integrado y ejecuta: "mvn clean install". Esto descargará las dependencias necesarias y compilará el proyecto.

***Despliegue***
Este proyecto está destinado principalmente a pruebas unitarias y no tiene un componente web o servidor asociado para despliegue. Si deseas ejecutarlo, sigue los siguientes pasos:

1. Abre una terminal o línea de comandos.
2. Navega al directorio `src/main/java/Ejercicio5` o cualquiera de los otros ejercicios dentro del proyecto.
3. Compila los archivos `.java` utilizando los  siguiente comando:
      - javac *.java
      - java Main java
4. el programa te mostrara el menu de opciones puedes elegir.

## Manejo de rutas

- Las rutas relativas y absolutas pueden ser utilizadas en el programa.
- La opción de **Listar un Directorio** guarda el contenido de un directorio en un archivo `.txt`, especificando la ruta y nombre del archivo de destino.
