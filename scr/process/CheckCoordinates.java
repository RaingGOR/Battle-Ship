package scr.process;

import static java.lang.Integer.parseInt;

public class CheckCoordinates {
    public String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String[][] field;
    Field fieldClass = new Field();

    CheckCoordinates(String[][] field) {
        this.field = field;
    }

    int horOrVert; // 0 = horizontal, 1 = Vertical, 2 = Error

    int horizontalOrVertical(String[] arrayCoordinate) {
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

    boolean overlay(String one, String two, int posX) {
        boolean flag = false;
        int startY, endY;
        int startX, endX;
        if (one.equals("A")) {
            startY = 0;
            endY = 2;
        } else if (two.equals("J")) {
            startY = 9;
            endY = 7;
        } else {
            startY = alphabet.indexOf(one) - 1;
            endY = alphabet.indexOf(two) + 2;
        }
        if (posX == 1) {
            startX = 0;
            endX = 2;
        } else if (posX == 10) {
            startX = 7;
            endX = 9;
        } else {
            startX = posX - 1;
            endX = posX + 1;
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
    }// CHECK OVERLAY FOR vertical POSITION

    boolean check(String coordinate, int lenShip, String nameShip) {
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
                if (coordinateTwo - coordinateOne == lenShip - 1) {
                    if (overlay(coordinateOne, coordinateTwo, arrayCoordinate[0])) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        return true;
                    } else {
                        fieldClass.changesToField(coordinateOne, coordinateTwo, alphabet.indexOf(arrayCoordinate[0]), field);
                        return false;
                    }
                } else {
                    System.out.printf("Error! Wrong length of the %s! Try again:\n", nameShip);
                    return true;
                }
            }
            case 1 -> {//if vertical
                int coordinateOne = alphabet.indexOf(arrayCoordinate[0]),
                        coordinateTwo = alphabet.indexOf(arrayCoordinate[2]);
                String coord1 = arrayCoordinate[0],
                        coord2 = arrayCoordinate[2];
                if (coordinateTwo < coordinateOne) { //sorted
                    int buffer = coordinateTwo;
                    coordinateTwo = coordinateOne;
                    coordinateOne = buffer;
                }
                if (coordinateTwo - coordinateOne == lenShip - 1) {
                    if (overlay(coord1, coord2, parseInt(arrayCoordinate[1]))) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        return true;
                    } else {
                        fieldClass.changesToField(coord1, coord2, parseInt(arrayCoordinate[1]),field);
                        return false;
                    }
                } else {
                    System.out.printf("Error! Wrong length of the %s! Try again:\n", nameShip);
                    return true;
                }
            }
            case 2 -> {//if error !!!DON'T TOUCH BELOW!!!
                return true;
            }
        }

        return false;
    }
}
