package tamagotchi_game;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

//    Intro credits
    public static void intro() {
        System.out.println("\n\nWelcome to Magic Hand Eventually Extended to Sausage!");
        System.out.println("\nDesigned and Developed by:\nLiam Yates\nDaisy Xiao\nLiam Rimmer\n");
        System.out.println("-------------------------\n\n");
    }

    public static void mainMenu(ArrayList<Pet> petCollection) throws FileNotFoundException, InterruptedException {

        System.out.println("-----   MAIN MENU   -----");
        System.out.println("1. New Game\n2. Load Game");
        Scanner scan = new Scanner(System.in);
        String input;
        input = InputValidation.regexValidate(scan, "12");

        switch (input) {
            case "1":
                newGame(petCollection);
                break;
            case "2":
                loadGame();
                break;
            default:
                System.out.println("error");
                break;
        }
    }

    private static void newGame(ArrayList<Pet> petCollection) throws FileNotFoundException, InterruptedException {
        String input;
        Scanner scan = new Scanner(System.in);
        //create starter pets
        Pet[] starterPet = new Pet[3];
        for (int i = 0; i < starterPet.length; i++) {
            starterPet[i] = new Pet("pet" + i, Misc.RNG(1, Stats.MAX_HUNGER - 5), Misc.RNG(1, Stats.MAX_THIRST - 5), Misc.RNG(1, Stats.MAX_ENERGY - 5), 5);
            starterPet[i].setMaturity(Maturity.BABY);
        }
        System.out.println("Creating a new game...\n");
        System.out.println("Select starting pet:");
        System.out.println("--------------------");
        System.out.println("  | Name | Species | Gender | Maturity | Hunger | Thirst | Energy |");
        int count = 1;
        //TODO: tidy this up
        for (Pet x : starterPet) {
            System.out.printf(count + ".  " + x.getName() + "    " + String.format("%1$2s", x.getSpecies()) + "      " + x.getGender() + "        " + x.getMaturity() + "       " + x.stats.getHunger() + "        " + x.stats.getThirst() + "        " + x.stats.getEnergy() + "\n");
            count++;
        }
        input = InputValidation.regexValidate(scan, "123");
        //add choice to pet collection
        Pet.currentPet.setCreated(LocalDateTime.now());
        Pet.setCurrentPet(starterPet[Integer.parseInt(input) - 1]);
        petCollection.add(Pet.currentPet);

        System.out.println("You have selected " + Pet.currentPet.getName() + "!");
        System.out.println("You now own " + petCollection.size() + " pet" + (petCollection.size() > 1 ? "s." : "."));

    }

    private static void loadGame() throws FileNotFoundException {
        File file = new File("save.txt");
        try {
            Scanner scan = new Scanner(file);
            String[] pets;
            String[] stats;

            //TODO: perhaps turn into a case for each section of data needed to load
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.equals("@P_STATS")) {
                    line = scan.nextLine();
                    stats = line.split(",");
                    Player.player.setCurrency(Integer.parseInt(stats[0]));
                    Player.player.setFoodAmount(Integer.parseInt(stats[1]));
                    Player.player.setWaterAmount(Integer.parseInt(stats[2]));

                }
                if (line.equals("@PETS")) {
                    while (scan.hasNextLine()) {
                        line = scan.nextLine();
                        pets = line.split(",");
                        Pet pet = new Pet(pets[0], Integer.parseInt(pets[1]), Integer.parseInt(pets[2]), Integer.parseInt(pets[3]), Integer.parseInt(pets[4]));
                        pet.setGender(Gender.valueOf(pets[5]));
                        pet.setMaturity(Maturity.valueOf(pets[6]));
                        pet.setSpecies(Species.valueOf(pets[7]));
                        Main.petCollection.add(pet);
                    }
                }
            }
            scan.close();
            Pet.setCurrentPet((Pet)Main.petCollection.get(0));
        } catch (FileNotFoundException e) {
            System.out.println("No save games found in " + file + "!");
        }
    }
}
