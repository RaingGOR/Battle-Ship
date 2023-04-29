package scr.process;

public class Game {
    public void StartGame() {
        Field field = new Field();
        field.createField();
        field.printField();
        Ships ships = new Ships(field.field);

    }
}
