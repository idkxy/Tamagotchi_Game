package tamagotchi_game;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

    public void mainGame() throws FileNotFoundException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        String user;
        boolean LOOP = true;

        while (LOOP) {
            //Misc.clearConsole();
            Interface.dashBoard();

            user = InputValidation.regexValidate(scan, "ifcsq");

            switch (user.toLowerCase()) {
                case "i":
                    Interface.menuInteract();
                    user = InputValidation.regexValidate(scan, "1234");
                    Interact.Interact(Integer.parseInt(user));
                    System.out.println("Going back to previoud menu...");
                    Thread.sleep(1000);
                    break;
                case "f":
                    Interface.menuFeed();
                    user = InputValidation.regexValidate(scan, "123456");
                    FeedOption.Feed(Integer.parseInt(user));
                    System.out.println("Going back to previoud menu...");
                    Thread.sleep(1000);
                    break;
                case "c":
                    Competition.c.setOpponent(Pet.PetGenerator());
                    Interface.menuCompetition();
                    Competition.c.confirmation();   

                    break;
                case "s":
                    Interface.menuShop();
                    ShopOption.shopOption.shopInteract();
                    break;
                case "q":
                    LOOP = false;
                    break;
                default:
                    System.out.println("Something went wrong...");
            }
        }
        Data.saveGame(Main.petCollection);
        System.out.println("Game ends. Bye!");
        System.exit(0);
    }
}