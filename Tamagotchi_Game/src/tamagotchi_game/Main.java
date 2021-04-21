package tamagotchi_game;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static ArrayList petCollection = new ArrayList<Pet>();
    public static Player player = new Player(200,0,0);


    static Game game = new Game();
    
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        Menu.intro();
        //Thread.sleep(2000);
        
        Menu.mainMenu(petCollection);
     
        game.mainGame();
        
    }
}