package tamagotchi_game;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Data {
        
    public static void saveGame(ArrayList<Pet> petCollection) throws FileNotFoundException
    {
        String fileName = "save.txt";
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
        pw.println("@PETS");
        petCollection.forEach((v) -> pw.println(v.getName() + "," + v.stats.getHunger() + "," + v.stats.getThirst() + "," + v.stats.getEnergy() + "," + v.stats.getHappiness()));
        pw.println("@TEST");
        pw.close();
    }
}
