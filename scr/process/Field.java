package scr.process;

import java.util.Arrays;

public class Field {
    public String[][] field = new String[10][10];
    public String[] alphabetField = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
    public String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    void createField() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                field[y][x] = "~";
            }
        }
    }

    void printField() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int y = 0; y < 10; y++) {
            System.out.print(alphabetField[y]);
            for (int x = 0; x < 10; x++) {
                System.out.print(" " + field[y][x]);
            }
            System.out.println();
        }
        System.out.println();
    }

    void changesToField(int one, int two, int y, String[][] fieldz) {
        for (int x = one - 1; x < two; x++) {
            fieldz[y][x] = "O";
        }
    }

    void changesToField(String one, String two, int x, String[][] fieldz) {
        for (int y = alphabet.indexOf(one); y < alphabet.indexOf(two) + 1; y++) {
            fieldz[y][x - 1] = "O";
        }
    }
}
