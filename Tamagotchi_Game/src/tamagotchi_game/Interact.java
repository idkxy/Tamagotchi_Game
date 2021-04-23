package tamagotchi_game;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Interact {

    public static void Interact(int userInput) {
        Scanner scan = new Scanner(System.in);
        String input;
        switch (userInput) {
            case 1:
                //System.out.println(Main.petCollection.indexOf(Pet.currentPet)+1);
                Pet.updatePet();
                //Will increase pet happiness by 1
                if (Time.getDiff(Pet.currentPet.getLastpatTime()) >= 60) {
                    System.out.println("The happiness level of the current pet has gone up by one from patting!");
                    Pet.currentPet.stats.setHappiness(Pet.currentPet.stats.getHappiness() + 1);
                    Pet.currentPet.setLastpatTime(LocalDateTime.now());
                    if (Pet.currentPet.stats.getHappiness() >= 6) {
                        System.out.println("Pet is now happy! You will get $100 from patting the pet!");
                        Player.player.setCurrency(Player.player.getCurrency() + 100);
                        if (Pet.currentPet.stats.getHappiness() == Stats.MAX_HAPPINESS) {
                            System.out.println("The happiness of the pet has reached max! You get 1 engergy as a bonus!");
                            Pet.currentPet.stats.setEnergy(Pet.currentPet.stats.getEnergy() + 1);
                        }
                    }
                } else {
                    System.out.println(60 - Time.getDiff(Pet.currentPet.getLastpatTime()) + " minutes till next happiness increase through petting!");
                }
                break;
            case 2:
                Breed breed = new Breed();
                breed.create();
                break;
            case 3:
                if (Pet.getPetCollection().size() > 1) {
                    System.out.println("Player pets:");
                    ArrayList<Pet> temp = Pet.getPetCollection();
                    String tempS = "";
                    for (int i = 0; i < Pet.getPetCollection().size(); i++) {
                        System.out.println(temp.get(i).toString());
                        tempS += String.valueOf(i + 1);
                    }

                    System.out.println("Please select desired pet");
                    input = InputValidation.regexValidate(scan, tempS);
                    Pet.setCurrentPet((Pet) Pet.getPetCollection().get(Integer.parseInt(input) - 1));
                } else {
                    System.out.println("Player requires more than one pet to use this function.");
                }
                //Cap pets displayed at 10 at a time as to enable user to enter only (0 - 9) + 1.
                break;
            default:
                System.out.println("Something went wrong...");
        }
    }
}
