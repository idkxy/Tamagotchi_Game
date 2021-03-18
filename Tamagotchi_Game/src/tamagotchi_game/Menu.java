package tamagotchi_game;

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
    
    public static void mainMenu() throws FileNotFoundException
    {
        System.out.println("-----   MAIN MENU   -----");
        System.out.println("1. New Game\n2. Load Game");
        scan = new Scanner(System.in);
        
        while (!input.equalsIgnoreCase("1") && !input.equalsIgnoreCase("2"))
        {
            input = scan.nextLine();
            switch(input)
            {
                case "1":
                    newGame();
                    input = "1";
                    break;
                case "2":
                    loadGame();
                    break;
                default:
                    System.out.println("Error: Please enter a valid input.");
                    break;
            }    
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
    
    private static void loadGame()
    {
        
    }
    
}
