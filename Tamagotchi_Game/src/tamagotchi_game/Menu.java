package tamagotchi_game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

//    Intro credits
    public static void intro() {
        System.out.println("\n\nWelcome to unnamed game!");
        System.out.println("\nDesigned and Developed by:\nLiam Rimmer\nDaisy Xiao\nLiam Yates\n");
        System.out.println("-------------------------\n\n");
    }

    public static void mainMenu(ArrayList<Pet> petCollection) throws FileNotFoundException {

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
                loadGame(petCollection);
                break;
            default:
                System.out.println("error");
                break;
        }
    }

    private static void newGame(ArrayList<Pet> petCollection) throws FileNotFoundException {
        String input;
        Player player = new Player(100, 0, 0);
        Scanner scan = new Scanner(System.in);
        //create starter pets
        Pet[] starterPet = new Pet[3];
        for (int i = 0; i < starterPet.length; i++) {
            starterPet[i] = new Pet("pet" + i, Misc.RNG(1, Stats.MAX_HUNGER - 5), Misc.RNG(1, Stats.MAX_THIRST - 5), Misc.RNG(1, Stats.MAX_ENERGY - 5), 5);
        }
        System.out.println("Creating a new game...\n");
        System.out.println("Select starting pet:");
        System.out.println("--------------------");
        System.out.println("Pet Name | Hunger | Thirst | Energy |");
        int count = 1;
        for (Pet x : starterPet) {
            System.out.println(count + ". " + x.getName() + " " + x.stats.getHunger() + " " + x.stats.getThirst() + " " + x.stats.getEnergy());
            count++;
        }
        input = InputValidation.regexValidate(scan, "12");
        //add choice to pet collection
        Pet.setCurrentPet(starterPet[Integer.parseInt(input) - 1]);
        petCollection.add(Pet.currentPet);

        System.out.println("You have selected " + Pet.currentPet.getName() + "!");
        System.out.println("You now own " + petCollection.size() + " pet" + (petCollection.size() > 1 ? "s." : "."));

        Data.saveGame(petCollection, player);
    }

    private static void loadGame(ArrayList<Pet> petCollection) throws FileNotFoundException {
        File file = new File("save.txt");
        try {
            Scanner scan = new Scanner(file);
            String[] pets;

            
            //TODO: perhaps turn into a case for each section of data needed to load
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.equals("@P_STATS"))
                {
                    
                }
                if (line.equals("@PETS")) {
                    line = scan.nextLine();
                    while (!line.contains("@")) {
                        pets = line.split(",");
                        Pet pet = new Pet(pets[0], Integer.parseInt(pets[1]), Integer.parseInt(pets[2]), Integer.parseInt(pets[3]), Integer.parseInt(pets[4]));
                        petCollection.add(pet);
                        line = scan.nextLine();
                    }
                    if (line.equals("@TEST")) {
                        System.out.println("reached test");
                    }
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("No save games found in " + file + "!");
        }
    }
}
