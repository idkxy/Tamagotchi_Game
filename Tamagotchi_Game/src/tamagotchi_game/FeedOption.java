package tamagotchi_game;

import java.util.Scanner;

/* 
   The feed class will take in users input 
   representing the choice they make in eding the pet
 * @author DaisyXiao - 1392836
 * @author Liam Yates - 18016696
 * @author Liam Rimmer - 18040246
 */
public class FeedOption {

    /**
     * The feed method will take in user's input representing the choice they
     * make in feeding the pet
     *
     * @param DaisyXiao - 1392836
     */
    public static void Feed() {
        Scanner scan = new Scanner(System.in);
        String input = InputValidation.regexValidate(scan, "123456x");

        switch (input) {
            case "1":
                //Feed the pet with food
                if (Player.player.getFoodAmount() > 0 && Pet.petCollection.get(Pet.getIndex()).stats.getHunger() < 10) {
                    Player.player.setFoodAmount(Player.player.getFoodAmount() - 1);
                    if (Pet.petCollection.get(Pet.getIndex()).stats.getHunger() < 10) {
                        Pet.petCollection.get(Pet.getIndex()).stats.setHunger(Pet.petCollection.get(Pet.getIndex()).stats.getHunger() + 1);
                    }
                } else if (Pet.petCollection.get(Pet.getIndex()).stats.getHunger() == Stats.MAX_HUNGER) {
                    System.out.println("The hunger level of the pet has reached max! You get 1 energy as a bonus!");
                    Pet.petCollection.get(Pet.getIndex()).stats.setEnergy(Pet.petCollection.get(Pet.getIndex()).stats.getEnergy() + 1);
                } else {
                    System.out.println("Not enough food or pet is not hungry, could not feed.");
                }
                break;
            case "2":
                //Feed the pet with water 
                if (Player.player.getWaterAmount() > 0 && Pet.petCollection.get(Pet.getIndex()).stats.getThirst() < 10) {
                    Player.player.setWaterAmount(Player.player.getWaterAmount() - 1);
                    if (Pet.petCollection.get(Pet.getIndex()).stats.getThirst() < 10) {
                        Pet.petCollection.get(Pet.getIndex()).stats.setThirst(Pet.petCollection.get(Pet.getIndex()).stats.getThirst()+ 1);
                    }
                } else if (Pet.petCollection.get(Pet.getIndex()).stats.getThirst() == Stats.MAX_THIRST) {
                    System.out.println("The thirst level of the pet has reached max! You get 1 energy as a bonus!");
                    Pet.petCollection.get(Pet.getIndex()).stats.setEnergy(Pet.petCollection.get(Pet.getIndex()).stats.getEnergy() + 1);
                } else {
                    System.out.println("Not enough water or pet is not thirsty, could not feed.");
                }
                break;
            case "3":
                //Feed the pet with both water and food
                if ((Player.player.getFoodAmount() > 0 && Pet.petCollection.get(Pet.getIndex()).stats.getHunger() < 10) || (Player.player.getWaterAmount() > 0 && Pet.petCollection.get(Pet.getIndex()).stats.getThirst() < 10)) {

                    Player.player.setFoodAmount(Player.player.getFoodAmount() - 1);
                    Pet.petCollection.get(Pet.getIndex()).stats.setHunger(Pet.petCollection.get(Pet.getIndex()).stats.getHunger() + 1);

                    Player.player.setWaterAmount(Player.player.getWaterAmount() - 1);
                    Pet.petCollection.get(Pet.getIndex()).stats.setThirst(Pet.petCollection.get(Pet.getIndex()).stats.getThirst() + 1);
                } else if (Pet.petCollection.get(Pet.getIndex()).stats.getHunger() == Stats.MAX_HUNGER) {
                    Player.player.setWaterAmount(Player.player.getWaterAmount() - 1);
                    Pet.petCollection.get(Pet.getIndex()).stats.setThirst(Pet.petCollection.get(Pet.getIndex()).stats.getThirst() + 1);
                    System.out.println("The hunger level of the pet has reached max! You get 1 energy as a bonus!");
                    Pet.petCollection.get(Pet.getIndex()).stats.setEnergy(Pet.petCollection.get(Pet.getIndex()).stats.getEnergy() + 1);
                } else if (Pet.petCollection.get(Pet.getIndex()).stats.getThirst() == Stats.MAX_THIRST) {
                    Player.player.setFoodAmount(Player.player.getFoodAmount() - 1);
                    Pet.petCollection.get(Pet.getIndex()).stats.setHunger(Pet.petCollection.get(Pet.getIndex()).stats.getHunger() + 1);
                    System.out.println("The thirst level of the pet has reached max! You get 1 energy as a bonus!");
                    Pet.petCollection.get(Pet.getIndex()).stats.setEnergy(Pet.petCollection.get(Pet.getIndex()).stats.getEnergy() + 1);
                } else {
                    System.out.println("Not enough food and / or water or pet is not hungry and / or thirsty.");
                }
                break;
            case "4":
                //Feed pet with enough food that maximize the hunger level
                if (Player.player.getFoodAmount() >= (10 - Player.player.getFoodAmount()) && Pet.petCollection.get(Pet.getIndex()).stats.getHunger() < 10) {
                    Player.player.setFoodAmount(Player.player.getFoodAmount() - (10 - Player.player.getFoodAmount()));
                    Pet.petCollection.get(Pet.getIndex()).stats.setHunger(10);
                    System.out.println("The hunger level of the pet has reached max! You get 1 energy as a bonus!");
                    Pet.petCollection.get(Pet.getIndex()).stats.setEnergy(Pet.petCollection.get(Pet.getIndex()).stats.getEnergy() + 1);

                } else {
                    System.out.println("Not enough food or pet is not hungry, could not feed.");

                }
                break;
            case "5":
                //Feed pet with enough water that maximize the thirst level
                if (Player.player.getWaterAmount() >= (10 - Player.player.getWaterAmount()) && Pet.petCollection.get(Pet.getIndex()).stats.getThirst() < 10) {
                    Player.player.setWaterAmount(Player.player.getWaterAmount() - (10 - Player.player.getWaterAmount()));
                    Pet.petCollection.get(Pet.getIndex()).stats.setThirst(10);
                    System.out.println("The thirst level of the pet has reached max! You get 1 energy as a bonus!");
                    Pet.petCollection.get(Pet.getIndex()).stats.setEnergy(Pet.petCollection.get(Pet.getIndex()).stats.getEnergy() + 1);
                } else {
                    System.out.println("Not enough water or pet is not thirsty, could not feed.");
                }
                break;
            case "6":
                //Feed pet with enough food and water that maximize the hunger and thrist level
                if (((Player.player.getFoodAmount() > 0 || Pet.petCollection.get(Pet.getIndex()).stats.getHunger() < 10)) && ((Player.player.getWaterAmount() > 0 || Pet.petCollection.get(Pet.getIndex()).stats.getThirst() < 10))) {
                    if ((Player.player.getFoodAmount() - (10 - Pet.petCollection.get(Pet.getIndex()).stats.getHunger()) > 0) && (Player.player.getWaterAmount() - (10 - Pet.petCollection.get(Pet.getIndex()).stats.getThirst()) > 0)) {
                        Pet.petCollection.get(Pet.getIndex()).stats.setHunger(10);
                        Pet.petCollection.get(Pet.getIndex()).stats.setThirst(10);
                        Player.player.setFoodAmount(Player.player.getFoodAmount() - (10 - Pet.petCollection.get(Pet.getIndex()).stats.getHunger()));
                        Player.player.setWaterAmount(Player.player.getWaterAmount() - (10 - Pet.petCollection.get(Pet.getIndex()).stats.getThirst()));
                        System.out.println("The thirst and hunger level of the pet has both eached max! You get 2 energy as a bonus!");
                        Pet.petCollection.get(Pet.getIndex()).stats.setEnergy(Pet.petCollection.get(Pet.getIndex()).stats.getEnergy() + 2);
                    } else {
                        System.out.println("Not enough food and water");
                    }
                } else {
                    System.out.println("Not enough food and/ or water or pet is not hungry and/ or thirsty.");
                }
                break;
            case "x":
                break;
        }
    }

}
