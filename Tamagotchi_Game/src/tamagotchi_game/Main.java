package tamagotchi_game;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {


    static Game game = new Game();

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {

        MainMenu.intro();
        //Thread.sleep(2000);

        MainMenu.mainMenu();

        game.mainGame();

    }
}
