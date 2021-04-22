package tamagotchi_game;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static ArrayList petCollection = new ArrayList<Pet>();

    static Game game = new Game();
    
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
    
        MainMenu.intro();
        //Thread.sleep(2000);
        
        MainMenu.mainMenu(petCollection);
     
        game.mainGame();
        
    }
}