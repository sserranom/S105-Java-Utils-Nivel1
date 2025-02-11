package Ejercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ManageDirectory manageDirectory = new ManageDirectory();

        try (Scanner input = new Scanner(System.in)) {
            Menu menu = new Menu(manageDirectory, input);
            menu.ShowMenu();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}