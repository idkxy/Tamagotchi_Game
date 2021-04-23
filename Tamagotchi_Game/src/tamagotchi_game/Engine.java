package tamagotchi_game;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Engine {

    public void Game() throws FileNotFoundException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        String input;
        boolean LOOP = true;

        while (LOOP) {
            Interface.dashBoard();
            input = InputValidation.regexValidate(scan, "ifcsq");
            switch (input) {
                case "i":
                    Interface.menuInteract();
                    input = InputValidation.regexValidate(scan, "123");
                    Interact.Interact(Integer.parseInt(input));
                    System.out.println("Going back to previous menu...");
                    Thread.sleep(1000);
                    break;
                case "f":
                    Interface.menuFeed();
                    input = InputValidation.regexValidate(scan, "123456");
                    FeedOption.Feed(Integer.parseInt(input));
                    System.out.println("Going back to previous menu...");
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
                    break;
            }
        }
    }
}
