package scr.process;

import java.util.Scanner;

public class Ships {
    String[][] field;
    Scanner scanner = new Scanner(System.in);

    Ships(String[][] field) {
        this.field = field;

    }

    void Aircraft_Carrier() {
        int lenShip = 5;
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        String coordinate = scanner.nextLine();
        CheckCoordinates checkCoordinates = new CheckCoordinates(field);
        while (checkCoordinates.check(coordinate, lenShip, "Aircraft Carrier")) {
            coordinate = scanner.nextLine();
        }
    }

    void Battleship() {
        int lenShip = 4;
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
        String coordinate = scanner.nextLine();
        CheckCoordinates checkCoordinates = new CheckCoordinates(field);
        while (checkCoordinates.check(coordinate, lenShip, "Battleship")) {
            coordinate = scanner.nextLine();
        }
    }

    void Submarine() {
        int lenShip = 3;
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
        String coordinate = scanner.nextLine();
        CheckCoordinates checkCoordinates = new CheckCoordinates(field);
        while (checkCoordinates.check(coordinate, lenShip, "Submarine")) {
            coordinate = scanner.nextLine();
        }
    }

    void Cruiser(){
        int lenShip = 3;
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
        String coordinate = scanner.nextLine();
        CheckCoordinates checkCoordinates = new CheckCoordinates(field);
        while (checkCoordinates.check(coordinate, lenShip, "Cruiser")) {
            coordinate = scanner.nextLine();
        }
    }
    void Destroyer(){
        int lenShip = 3;
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
        String coordinate = scanner.nextLine();
        CheckCoordinates checkCoordinates = new CheckCoordinates(field);
        while (checkCoordinates.check(coordinate, lenShip, "Cruiser")) {
            coordinate = scanner.nextLine();
        }
    }
}
