package tamagotchi_game;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static ArrayList petCollection = new ArrayList<Pet>();

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        Menu.intro();
        //Thread.sleep(2000);
        Menu.mainMenu(petCollection);
        
        int userCurrency = 0;
        
        //Array of avaliable pets
        petCollection.get(0);
        
        //Get access to current pet
        //i.e. energy
        Pet.currentPet.getEnergy();
        //int happy, int hunger, int thirst, int energy
        userCurrency = userCurrency + Competition.compete(Pet.currentPet.getHunger(), Pet.currentPet.getThirst(), Pet.currentPet.getHappiness());
        
        //Testing
        System.out.println("\n\n\n" + userCurrency);
    }
}