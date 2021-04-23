package tamagotchi_game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This class is for loading, saving and creating new game
 * 
 * @author DaisyXiao - 1392836
 * @author Liam Yates - 18016696
 * @author Liam Rimmer - 18040246 
 */
public class Data {

    /**
     * Create a new game by asking the user to choose from the available pets
     *
     * @throws FileNotFoundException
     * @throws InterruptedException
     */
    public void newGame() throws FileNotFoundException, InterruptedException {
        String input;
        Scanner scan = new Scanner(System.in);
        //create starter pets
        Pet[] starterPet = new Pet[3];
        for (int i = 0; i < starterPet.length; i++) {
            starterPet[i] = Pet.PetGenerator();
            starterPet[i].setMaturity(Maturity.BABY);
        }
        System.out.println("Creating a new game...\n");
        System.out.println("Select starting pet:");
        System.out.println("--------------------");
        System.out.println("  |    Name    |  Species |  Gender  | Maturity | Hunger | Thirst | Energy |");
        int count = 1;
        for (Pet x : starterPet) {
            System.out.printf(count + ".    " + String.format("%-9s", x.getName()) + "    " + String.format("%-5s", x.getSpecies()) + "     " + String.format("%1$5s", x.getGender()) + (x.getGender() == Gender.MALE ? "      " : "     ") + String.format("%1$5s", x.getMaturity()) + "        " + x.stats.getHunger() + "        " + x.stats.getThirst() + "        " + x.stats.getEnergy() + "\n");
            count++;
        }
        input = InputValidation.regexValidate(scan, "123");
        //add choice to pet collection
        Pet.setIndex(0);
        Pet.petCollection.put(Pet.getIndex(), starterPet[Integer.parseInt(input) - 1]);
        Pet.petCollection.get(Pet.getIndex()).setCreated(LocalDateTime.now());

        System.out.println("You have selected " + Pet.petCollection.get(Pet.getIndex()).getName() + "!");
        System.out.println("You now own " + Pet.petCollection.size() + " pet" + (Pet.petCollection.size() > 1 ? "s." : "."));

    }

    /**
     * Load the game from reading information stored in save.txt
     *
     * @throws FileNotFoundException
     * @throws InterruptedException
     */
    public void loadGame() throws FileNotFoundException, InterruptedException {
        File file = new File("save.txt");
        if (file.length() == 0) {
            System.out.println("No saved games! create a new game first!");
            newGame();
        } else {
            try {
                Scanner scan = new Scanner(file);

                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    // store player stats in array
                    if (line.equals("@P_STATS")) {
                        line = scan.nextLine();
                        StringTokenizer st = new StringTokenizer(line, ",");
                        Player.player.setCurrency(Integer.parseInt(st.nextToken()));
                        Player.player.setFoodAmount(Integer.parseInt(st.nextToken()));
                        Player.player.setWaterAmount(Integer.parseInt(st.nextToken()));
                    }
                    // store player pets in array
                    if (line.equals("@PETS")) {
                        int count = 0;
                        while (scan.hasNextLine()) {
                            line = scan.nextLine();
                            StringTokenizer st = new StringTokenizer(line, ",");
                            Pet pet = new Pet(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                            pet.setGender(Gender.valueOf(st.nextToken()));
                            pet.setMaturity(Maturity.valueOf(st.nextToken()));
                            pet.setSpecies(Species.valueOf(st.nextToken()));
                            Competition comp = new Competition();
                            pet.setCompetition(comp);
                            pet.getCompetition().setCptEntered((Integer.parseInt(st.nextToken())));
                            pet.getCompetition().setWinCount((Integer.parseInt(st.nextToken())));
                            pet.getCompetition().setLoseCount((Integer.parseInt(st.nextToken())));
                            pet.getCompetition().setDrawCount(Integer.parseInt(st.nextToken()));
                            LocalDateTime created = LocalDateTime.parse(st.nextToken());
                            LocalDateTime lastpet = LocalDateTime.parse(st.nextToken());
                            pet.setCreated(created);
                            pet.setLastpatTime(lastpet);
                            count++;
                            Pet.petCollection.put(count, pet);
                        }
                    }
                }
                scan.close();
                // set first saved pet to current pet
                Pet.setIndex(1);
            } catch (FileNotFoundException e) {
                System.out.println("No save games found in " + file + "!");
            }
        }
    }

    /**
     * Print the game progress to save.txt
     *
     * @throws FileNotFoundException
     */
    public void saveGame() throws FileNotFoundException {
        String fileName = "save.txt";
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
        pw.println("@P_STATS");
        pw.println(Player.player.getCurrency() + "," + Player.player.getFoodAmount() + "," + Player.player.getWaterAmount());
        pw.println("@PETS");
        Pet.petCollection.forEach((t, v) -> pw.println(v.getName() + "," + v.stats.getHunger() + "," + v.stats.getThirst() + ","
                + v.stats.getHappiness() + "," + v.stats.getEnergy() + "," + v.getGender() + "," + v.getMaturity()
                + "," + v.getSpecies() + "," + v.getCompetition().getCptEntered() + "," + v.getCompetition().getWinCount() + ","
                + v.getCompetition().getLoseCount() + "," + v.getCompetition().getDrawCount() + "," + v.getCreated() + "," + v.getLastpatTime()));
        pw.close();
    }
}
