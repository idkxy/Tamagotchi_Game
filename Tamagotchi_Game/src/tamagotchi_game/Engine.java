package tamagotchi_game;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The engine is the core game loop which controls the entire game
 *
 * @author DaisyXiao - 1392836
 * @author Liam Yates - 18016696
 * @author Liam Rimmer - 18040246
 */
public class Engine {

    public void Game() throws FileNotFoundException, InterruptedException {
        boolean LOOP = true;
        Scanner scan = new Scanner(System.in);

        while (LOOP) {
            Menu.dashBoard();
            String input = InputValidation.regexValidate(scan, "ifcsq");
            switch (input) {
                //i represents interact
                case "i":
                    Menu.menuInteract();
                    Interact.Interact();
                    break;
                //f represents feed    
                case "f":
                    Menu.menuFeed();
                    FeedOption.Feed();
                    break;
                //c represents compete
                case "c":
                    Menu.menuCompetition();
                    Competition.c.confirmation();
                    break;
                //s represents shop
                case "s":
                    Menu.menuShop();
                    ShopOption.shopOption.shopInteract();
                    break;
                //q represents save and quit
                case "q":
                    LOOP = false;
                    break;
            }
            if (LOOP == true) {
                System.out.println("Returning...");
                Thread.sleep(1000);
            }
        }
    }
}
