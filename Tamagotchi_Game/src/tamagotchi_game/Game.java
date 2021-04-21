package tamagotchi_game;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game{

    public void mainGame() throws FileNotFoundException{
        Scanner scan = new Scanner(System.in);
        String user = "";
        
        for (;;){
            //Might change location of this function later.
            Misc.clearConsole();
            
            MenuLook.look();
            
            user = InputValidation.regexValidate(scan, "ifcsq");
            
            switch(user.toLowerCase()) {
                case "i":
                  MenuLook.InteractMenu();
                  user = InputValidation.regexValidate(scan, "1234");
                  Interact.Interact(Integer.parseInt(user));
                  break;
                case "f":
                  MenuLook.selectionF();
                  user = InputValidation.regexValidate(scan, "123456");
                  FeedOption.Feed(Integer.parseInt(user));
                  break;
                case "c":
                  MenuLook.selectionC();
                  user = InputValidation.regexValidate(scan, "PLACEHOLDER");
                  break;
                case "s":

                  MenuLook.selectionS();

                  user = InputValidation.regexValidate(scan, "12345");
                  //SubMenuOptions.Shop(Integer.parseInt(user));
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