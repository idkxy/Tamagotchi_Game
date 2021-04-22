package tamagotchi_game;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

    public void mainGame() throws FileNotFoundException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        String user;

        for (;;) {
            Misc.clearConsole();

            Interface.dashBoard();

            user = InputValidation.regexValidate(scan, "ifcsq");

            switch (user.toLowerCase()) {
                case "i":
                    Interface.menuInteract();
                    user = InputValidation.regexValidate(scan, "1234");
                    Interact.Interact(Integer.parseInt(user));
                    break;
                case "f":
                    Interface.menuFeed();
                    user = InputValidation.regexValidate(scan, "123456");
                    FeedOption.Feed(Integer.parseInt(user));
                    break;
                case "c":
                    Interface.menuCompetition();
                    user = InputValidation.regexValidate(scan, "YynN");
                    Competition c = new Competition();
                    c.entryCheck();
                    System.out.println(c.toString());
                    break;
                case "s":
                    Interface.menuShop();
                    ShopOption.shopOption.shopInteract();
                    break;
                case "q":
                    Data.saveGame(Main.petCollection);
                    System.out.println("Game ends. Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Something went wrong...");
            }
        }
    }
}
