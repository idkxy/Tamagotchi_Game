package tamagotchi_game;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private Engine game = new Engine();

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {

        Interface menu = new Interface();
        Engine engine = new Engine();
        System.out.println("\n\nWelcome to Magic Hand Eventually Extended to Sausage!");
        System.out.println("\nDesigned and Developed by:\nLiam Yates\nDaisy Xiao\nLiam Rimmer\n");
        System.out.println("-------------------------\n\n");
        //Thread.sleep(2000);

        menu.mainMenu();

        Data data = new Data();
        Scanner scan = new Scanner(System.in);
        String input = InputValidation.regexValidate(scan, "12");

        switch (input) {
            case "1":
                data.newGame();
                break;
            case "2":
                data.loadGame();
                break;
        }
        engine.Game();

        data.saveGame();
        System.out.println("Game ends. Bye!");
        System.exit(0);
    }
}
