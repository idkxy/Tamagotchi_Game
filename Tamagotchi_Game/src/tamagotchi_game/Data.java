package tamagotchi_game;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Data {

    public static void saveGame() throws FileNotFoundException {
        String fileName = "save.txt";
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
        pw.println("@P_STATS");
        pw.println(Player.player.getCurrency() + "," + Player.player.getFoodAmount() + "," + Player.player.getWaterAmount());
        pw.println("@PETS");
        Pet.petCollection.forEach((t, v) -> pw.println(v.getName() + "," + v.stats.getHunger() + "," + v.stats.getThirst() + ","
                + v.stats.getHappiness() + "," + v.stats.getEnergy()+ "," + v.getGender() + "," + v.getMaturity()
                + "," + v.getSpecies() + "," + v.getCompetition().getCptEntered() + "," + v.getCompetition().getWinCount() + ","
                + v.getCompetition().getLoseCount() + "," + v.getCompetition().getDrawCount() + "," + v.getCreated() + "," + v.getLastpatTime()));
        pw.close();
    }
}
