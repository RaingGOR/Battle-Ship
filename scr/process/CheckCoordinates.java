package scr.process;

import java.util.Objects;

import static java.lang.Integer.parseInt;

public class CheckCoordinates {
    public String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    String[][] field;

    CheckCoordinates(String[][] field) {
        this.field = field;
    }

    int horOrVert; // 0 = horizontal, 1 = Vertical, 2 = Error

    int horizontalOrVertical(String[] arrayCoordinate) {
        System.out.println(arrayCoordinate[0] + " " + arrayCoordinate[2] + " " + (Objects.equals(arrayCoordinate[0], arrayCoordinate[2])));
        if (arrayCoordinate[0].equals(arrayCoordinate[2])) {
            this.horOrVert = 0;
        } else if (arrayCoordinate[1].equals(arrayCoordinate[3])) {
            this.horOrVert = 1;
        } else {
            this.horOrVert = 2;
            System.out.println("Error! Wrong ship location! Try again:");
        }

        return horOrVert;
    } //CHECK POSITION ON THE FIELD AND CHECK FIRST ERROR

    boolean overlay(int one, int two, String posY) {  //horiz
        boolean flag = false;
        int startY, endY;
        int startX, endX;
        if (posY.equals("A")) {
            startY = 0;
            endY = 2;
        } else if (posY.equals("J")) {
            startY = 9;
            endY = 7;
        } else {
            startY = alphabet.indexOf(posY) - 1;
            endY = alphabet.indexOf(posY) + 2;
        }
        if (one == 1) {
            startX = 0;
            endX = 2;
        } else if (one == 10) {
            startX = 7;
            endX = 9;
        } else {
            startX = one - 1;
            endX = two + 2;
        }

        for (int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                if (field[y][x].equals("O")) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    } // CHECK OVERLAY FOR HORIZONTAL POSITION

//    boolean overlay(String one, String two, int posY) {
//        boolean flag = false;
//        return flag;
//    }

    boolean check(String coordinate, int lenShip) {
        String[] arrayCoordinate = coordinate.replaceAll(" ", "").split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        switch (horizontalOrVertical(arrayCoordinate)) {
            case 0 -> {//if horizontal
                int coordinateOne = Integer.parseInt(arrayCoordinate[1]),
                        coordinateTwo = Integer.parseInt(arrayCoordinate[3]);
                if (coordinateTwo < coordinateOne) { //sorted
                    int buffer = coordinateTwo;
                    coordinateTwo = coordinateOne;
                    coordinateOne = buffer;
                }
                if (coordinateTwo - coordinateOne == lenShip) {
                    if (overlay(coordinateOne, coordinateTwo, arrayCoordinate[0])) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        return true;
                    } else return false;
                } else {
                    System.out.println("Error! Wrong length of the Submarine! Try again:");
                    return true;
                }
            }
            case 1 -> {//if vertical
                return false;
            }
            case 2 -> {//if error !!!DON'T TOUCH BELOW!!!
                return true;
            }
        }

        return false;
    }
}
