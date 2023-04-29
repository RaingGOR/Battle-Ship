package scr.process;

public class CheckCoordinates {
    public String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    String[][] field;

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
        if (posY.equals("A")) {
            if (one == 1) {
                for (int y = 0; y < 2; y++) {
                    for (int x = one; x < two + 2; x++) {
                        if (field[y][x].equals("O")) {
                            flag = true;
                            break;
                        }
                    }
                }
            } else if (two == 10) {
                for (int y = 0; y < 2; y++) {
                    for (int x = one - 1; x < two + 1; x++) {
                        if (field[y][x].equals("O")) {
                            flag = true;
                            break;
                        }
                    }
                }
            } else { // vse sluchai
                for (int y = 0; y < 2; y++) {
                    for (int x = one - 1; x < two + 2; x++) {
                        if (field[y][x].equals("O")) {
                            flag = true;
                            break;
                        }
                    }
                }
            }
        } else if (posY.equals("J")) {
            if (one == 1) {
                for (int y = 9; y > 7; y--) {
                    for (int x = one; x < two + 2; x++) {
                        if (field[y][x].equals("O")) {
                            flag = true;
                            break;
                        }
                    }
                }
            } else if (two == 10) {
                for (int y = 9; y > 7; y--) {
                    for (int x = one - 1; x < two + 1; x++) {
                        if (field[y][x].equals("O")) {
                            flag = true;
                            break;
                        }
                    }
                }
            } else {
                for (int y = 9; y > 7; y--) {
                    for (int x = one - 1; x < two + 2; x++) {
                        if (field[y][x].equals("O")) {
                            flag = true;
                            break;
                        }
                    }
                }
            }
        } else {
            for (int y = alphabet.indexOf(posY) - 1; y < alphabet.indexOf(posY) + 2; y++) {
                for (int x = one - 1; x < two + 2; x++) {
                    if (field[y][x].equals("O")) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    boolean check(String coordinate, int lenShip) {
        String[] arrayCoordinate = coordinate.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
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
                    }

                } else {
                    System.out.println("Error! Wrong length of the Submarine! Try again:");
                    return false;
                }
                return false;
            }
            case 1 -> {//if vertical
                return false;
            }
            case 2 -> {//if error !!!DON'T TOUCH BELOW!!!
                return false;
            }
        }

        return false;
    }
}
