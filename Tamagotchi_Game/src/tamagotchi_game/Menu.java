

package tamagotchi_game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    
    private static Scanner scan = new Scanner(System.in);
    private static String input = "";
    
//    Intro credits
    public static void intro()
    {
        System.out.println("\n\nWelcome to unnamed game!");
        System.out.println("\nDesigned and Developed by:\nLiam Rimmer\nDaisy Xiao\nLiam Yates\n");
        System.out.println("-------------------------\n\n");
    }
    
    public static void mainMenu() throws FileNotFoundException {

        System.out.println("-----   MAIN MENU   -----");
        System.out.println("1. New Game\n2. Load Game");
        scan = new Scanner(System.in);

        //Input validation class being run

        input = InputValidation.regexValidate(scan, "12");

        switch (input) {
            case "1":
                newGame();
                input = "1";
                break;
            case "2":
                loadGame();
                break;
            default:
                break;
        }
    }
    
    private static void newGame() throws FileNotFoundException
    {
        //create new pet collection for new player
        HashMap petCollection = new HashMap<String, Pet>();        
        //create starter pets
        Pet[] starterPet = new Pet[3];
        for (int i = 0; i < starterPet.length; i++)
        {
            starterPet[i] = new Pet("pet"+i, Misc.RNG(1, Pet.MAX_HUNGER-5), Misc.RNG(1, Pet.MAX_THIRST-5), Misc.RNG(1, Pet.MAX_ENERGY-5));
        }
        System.out.println("Creating a new game...\n");
        System.out.println("Select starting pet:");
        System.out.println("--------------------");
        System.out.println("Pet Name | Hunger | Thirst | Energy |");
        int count = 1;
        for (Pet x : starterPet) {
            System.out.println(count + ". " + x.getName() + " " + x.getHunger() + " " + x.getThirst() + " " + x.getEnergy());
            count++;
        }
        input = scan.nextLine();
        //add choice to pet collection
        petCollection.put(starterPet[Integer.parseInt(input)-1].getName(), starterPet[Integer.parseInt(input)-1]);

        System.out.println("You have selected " + petCollection.keySet() + "!");
        System.out.println("You now own " + petCollection.size() + " pet" + (petCollection.size() > 1 ? "s." : "."));
    }
    
    private static void loadGame() throws FileNotFoundException {
        File file = new File("./resources/save.txt");
        Scanner scan = new Scanner(file);
        HashMap petCollection = new HashMap<String, Pet>();
        String[] pets;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.equals("@PETS")) {
                line = scan.nextLine();
                while (!line.contains("@")) {
                    pets = line.split(",");
                    Pet currentPet = new Pet(pets[0], Integer.parseInt(pets[1]), Integer.parseInt(pets[2]), Integer.parseInt(pets[3]));
                    petCollection.put(pets[0], currentPet);
                    line = scan.nextLine();
                }
                if (line.equals("@TEST")) {
                    System.out.println("reached test");
                    System.out.println(petCollection.keySet());
                }
            }
        }
        scan.close();
    }
}
