package tamagotchi_game;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Interact {

    public static void Interact(int userInput) {
        Scanner scan = new Scanner(System.in);
        String input;
        switch (userInput) {
            case 1:
                //Will increase pet happiness by 1
                long currentTime = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                if (Pet.currentPet.getLastpatTime() <= currentTime - 3600000) {
                    Pet.currentPet.stats.setHappiness(Pet.currentPet.stats.getHappiness() + 1);
                    Pet.currentPet.setLastpatTime(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
                } else {
                    //TODO:fix this time 
                    System.out.println(TimeUnit.MILLISECONDS.toMinutes(Pet.currentPet.getLastpatTime()) + "minutes till next happiness increase through petting!");
                }
                break;
            case 2:
                //TODO: Will ask user to select another pet to breed with current pet.

                break;
            case 3:
                //TODO: Change current pet if player has more than one pet
                if (Main.petCollection.size() > 1) {
                    System.out.println("Player pets:");

                    Main.petCollection.forEach((v) -> {
                        System.out.println(v);
                    });

                    System.out.println("Please select desired pet");
                    input = InputValidation.regexValidate(scan, "0123456789");
                    //TODO: what does this do?
                    Main.petCollection.set(Integer.parseInt(input), Pet.currentPet.stats);
                } else {
                    System.out.println("Player requires more than one pet to use this function.");
                }
                //Cap pets displayed at 10 at a time as to enable user to enter only (0 - 9) + 1.
                break;
            case 4:
                //TODO: Sell currently equiped pet if player has more than one pet.
                if (Main.petCollection.size() > 1) {
                    System.out.println("WARNING: YOU ARE ABOUT TO SELL YOUR EQUIPED PET. ARE YOU SURE YOU WISH TO PROCEED? (Y/ N)");
                    System.out.println("NOTE: A pets worth is based on its energy. Maxing this stat will give a max price of 90");
                    System.out.println("Your pets current worth is " + (Pet.currentPet.stats.getHappiness()) * 9);
                    input = InputValidation.regexValidate(scan, "ny");

                    if (input.equals("y") && Main.petCollection.size() > 1) {
                        Player.player.setCurrency(Player.player.getCurrency() + (Pet.currentPet.stats.getHappiness()) * 9);

                        Main.petCollection.remove(Pet.currentPet);
                    } else {
                        System.out.println("CANCELLED");
                    }
                } else {
                    System.out.println("Player needs more pets to use this function.");
                }

                break;
            default:
                System.out.println("Something went wrong...");
        }
    }
}
