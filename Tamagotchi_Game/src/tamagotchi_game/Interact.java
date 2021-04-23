package tamagotchi_game;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Control the interactions with the pet 
 * @author DaisyXiao - 1392836
 */
public class Interact {

    public static void Interact(int userInput) {
        Scanner scan = new Scanner(System.in);
        String input;
        switch (userInput) {
            //Handle the pat interaction
            case 1:
                //Will increase pet happiness by 1 if it has been 1 hour since the last pat
                if (Time.getDiff(Pet.petCollection.get(Pet.getIndex()).getLastpatTime()) >= 60) {
                    System.out.println("The happiness level of the current pet has gone up by one from patting!");
                    Pet.petCollection.get(Pet.getIndex()).stats.setHappiness(Pet.petCollection.get(Pet.getIndex()).stats.getHappiness() + 1);
                    Pet.petCollection.get(Pet.getIndex()).setLastpatTime(LocalDateTime.now());
                    //Get $100 from patting when the happiness is greater than or equal to 6 
                    if (Pet.petCollection.get(Pet.getIndex()).stats.getHappiness() >= 6) {
                        System.out.println("Pet is now happy! You will get $100 from patting the pet!");
                        Player.player.setCurrency(Player.player.getCurrency() + 100);
                        //Get 1 energy if the happiness reaches max
                        if (Pet.petCollection.get(Pet.getIndex()).stats.getHappiness() == Stats.MAX_HAPPINESS) {
                            System.out.println("The happiness of the pet has reached max! You get 1 engergy as a bonus!");
                            Pet.petCollection.get(Pet.getIndex()).stats.setEnergy(Pet.petCollection.get(Pet.getIndex()).stats.getEnergy() + 1);
                        }
                    }
                } else {
                    //Show time remaining before the next pat if it is less than 60 mins since the last pat
                    System.out.println(60 - Time.getDiff(Pet.petCollection.get(Pet.getIndex()).getLastpatTime()) + " minutes till next happiness increase through petting!");
                }
                break;
            //Handle the breed interaction
            case 2:
                Breed breed = new Breed();
                breed.create();
                break;
            //Handle the change of pet from the list of pets own by the user if total number of pet is greater than 2
            case 3:
                //Print the list of pets own by the user if total number of pet is greater than 2 and
                //prompt user to enter a number representing the pet the user wish to switch to
                if (Pet.petCollection.size() > 1) {
                    System.out.println("Player pets:");
                    String tempS = "";
                    for (int i = 0; i < Pet.petCollection.size(); i++) {
                        System.out.print(i+1 + ". ");
                        System.out.println(Pet.petCollection.get(i+1).printPetDetails());
                        tempS += String.valueOf(i + 1);
                    }

                    System.out.println("Please select desired pet");
                    input = InputValidation.regexValidate(scan, tempS);
                    Pet.setIndex(Integer.parseInt(input));
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
