package tamagotchi_game;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static HashMap petCollection = new HashMap<String, Pet>();

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        Menu.intro();
        //Thread.sleep(2000);
        Menu.mainMenu(petCollection);
    }

}
