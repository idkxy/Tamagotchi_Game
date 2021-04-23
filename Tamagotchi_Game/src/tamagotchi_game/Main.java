package tamagotchi_game;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {

        Menu menu = new Menu();
        Engine engine = new Engine();
        System.out.println("\n\nWelcome to Magic Hand Eventually Extended to Sausage!");
        System.out.println("\nDesigned and Developed by:\nLiam Yates\nDaisy Xiao\nLiam Rimmer\n");
        System.out.println("-------------------------\n\n");

        Data data = new Data();

        boolean LOOP = true;
        while (LOOP) {
            menu.mainMenu();
            Scanner scan = new Scanner(System.in);
            String input = InputValidation.regexValidate(scan, "123");
            switch (input) {
                case "1":
                    LOOP = false;
                    data.newGame();
                    break;
                case "2":
                    LOOP = false;
                    data.loadGame();
                    break;
                case "3":
                    menu.instructions();
                    break;
            }
        }

        engine.Game();

        data.saveGame();
        System.out.println("Saving.... Bye!");
        System.exit(0);
    }
}
