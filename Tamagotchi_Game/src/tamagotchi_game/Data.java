package tamagotchi_game;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Data {
        
    public static void saveGame(HashMap<String, Pet> petCollection) throws FileNotFoundException
    {
        String fileName = "./resources/save.txt";
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
        pw.println("@PETS");
        petCollection.forEach((k, v) -> pw.println(k +","+ v.getHunger() +","+ v.getThirst() +","+ v.getEnergy()));
        pw.close();
    }
}
