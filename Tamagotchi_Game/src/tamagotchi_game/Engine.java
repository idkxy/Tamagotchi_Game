package tamagotchi_game;

import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * The engine is the core game loop which controls the entire game
 * @author DaisyXiao - 1392836
 */
public class Engine {

    public void Game() throws FileNotFoundException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        String input;
        boolean LOOP = true;

        while (LOOP) {
            Interface.dashBoard();
            input = InputValidation.regexValidate(scan, "ifcsq");
            switch (input) {
                //i represents interact
                case "i":
                    Interface.menuInteract();
                    input = InputValidation.regexValidate(scan, "123");
                    Interact.Interact(Integer.parseInt(input));
                    System.out.println("Going back to previous menu...");
                    Thread.sleep(1000);
                    break;
                //f represents feed    
                case "f":
                    Interface.menuFeed();
                    input = InputValidation.regexValidate(scan, "123456");
                    FeedOption.Feed(Integer.parseInt(input));
                    System.out.println("Going back to previous menu...");
                    Thread.sleep(1000);
                    break;
                //c represents compete
                case "c":
                    Competition.c.setOpponent(Pet.PetGenerator());
                    Interface.menuCompetition();
                    Competition.c.confirmation();
                    break;
                //s represents shop
                case "s":
                    Interface.menuShop();
                    ShopOption.shopOption.shopInteract();
                    break;
                //q represents save and quit
                case "q":
                    LOOP = false;
                    break;
                default:
                    System.out.println("Something went wrong...");
                    break;
            }
        }
    }
}
