package scr.process;

import java.util.Scanner;

public class Ships {
    String[][] field;

    Scanner scanner = new Scanner(System.in);

    Ships(String[][] field) {
        Aircraft_Carrier();
        this.field = field;

    }

    void Aircraft_Carrier() {
        int lenShip = 5;
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        String coordinate = scanner.nextLine();
        CheckCoordinates checkCoordinates = new CheckCoordinates(field);
        checkCoordinates.check(coordinate, lenShip);
    }
}
