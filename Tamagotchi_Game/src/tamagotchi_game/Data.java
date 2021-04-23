package tamagotchi_game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * This class is  for loading, saving and creating new game
 * @author DaisyXiao - 1392836
 */
public class Data {
    
    /**
     * Create a new game by asking the user to choose from the available pets
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
                String[] pets;
                String[] stats;

                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    // store player stats in array
                    if (line.equals("@P_STATS")) {
                        line = scan.nextLine();
                        stats = line.split(",");
                        Player.player.setCurrency(Integer.parseInt(stats[0]));
                        Player.player.setFoodAmount(Integer.parseInt(stats[1]));
                        Player.player.setWaterAmount(Integer.parseInt(stats[2]));

                    }
                    // store player pets in array
                    if (line.equals("@PETS")) {
                        int count = 0;
                        while (scan.hasNextLine()) {
                            line = scan.nextLine();
                            pets = line.split(",");
                            Pet pet = new Pet(pets[0], Integer.parseInt(pets[1]), Integer.parseInt(pets[2]), Integer.parseInt(pets[3]), Integer.parseInt(pets[4]));
                            pet.setGender(Gender.valueOf(pets[5]));
                            pet.setMaturity(Maturity.valueOf(pets[6]));
                            pet.setSpecies(Species.valueOf(pets[7]));
                            Competition comp = new Competition();
                            pet.setCompetition(comp);
                            pet.getCompetition().setCptEntered((Integer.parseInt(pets[8])));
                            pet.getCompetition().setWinCount((Integer.parseInt(pets[9])));
                            pet.getCompetition().setLoseCount((Integer.parseInt(pets[10])));
                            pet.getCompetition().setDrawCount(Integer.parseInt(pets[11]));
                            LocalDateTime created = LocalDateTime.parse(pets[12]);
                            LocalDateTime lastpet = LocalDateTime.parse(pets[13]);
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
