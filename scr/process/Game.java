package scr.process;

public class Game {
    public void StartGame() {
        Field field = new Field();
        field.createField();
        field.printField();
        Ships ships = new Ships(field.field);

        ships.Aircraft_Carrier();
        field.printField();

        ships.Battleship();
        field.printField();

        ships.Submarine();
        field.printField();

        ships.Cruiser();
        field.printField();

        ships.Destroyer();
        field.printField();
    }
}
