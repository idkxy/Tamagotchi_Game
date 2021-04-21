package tamagotchi_game;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SubMenuOptions extends Game{
    
    static Scanner scan = new Scanner(System.in);
    
    
    
    public static void Compete(int userInput){
        switch(userInput) {
                case 1:
                  
                  break;
                case 2:
                  
                  break;
                case 3:
                  
                  break;
                case 4:
                  
                  break;
                default:
                    System.out.println("Something went wrong...");
              }
    }
    
    public static void Shop(int userInput){
        String input = "Placeholder";
        
        switch(userInput) {
                case 1:
                    if (play.getCurrency() >= 1 && play.getFoodAmount() < 100){
                        //Removes currency from users inventory for payment.
                        play.setCurrency(play.getCurrency() - 1);
                        //Adds one food to players inventory.
                        play.setFoodAmount(play.getFoodAmount() + 1);
                    }
                    else{
                        System.out.println("Player did not have sufficient currency or food is already full, purchace failed.");
                    }
                  break;
                case 2:
                    if (play.getCurrency() >= (99 - play.getFoodAmount()) && play.getFoodAmount() < 100){
                        //Removes payment from users inventory for maxing food amount.
                        play.setCurrency(99 - play.getFoodAmount());
                        //Sets players food to max value.
                        play.setFoodAmount(99);
                    }
                    else{
                        System.out.println("Player did not have sufficient currency or food is already full, purchace failed.");
                    }
                  break;
                case 3:
                  if (play.getCurrency() >= 1 && play.getWaterAmount()< 100){
                        //Removes currency from users inventory for payment.
                        play.setCurrency(play.getCurrency() - 1);
                        //Adds one food to players inventory.
                        play.setWaterAmount(play.getWaterAmount() + 1);
                    }
                    else{
                        System.out.println("Player did not have sufficient currency or water is already full, purchace failed.");
                    }
                  break;
                case 4:
                  if (play.getCurrency() >= (99 - play.getWaterAmount()) && play.getWaterAmount()< 100){
                        //Removes payment from users inventory for maxing food amount.
                        play.setCurrency(99 - play.getWaterAmount());
                        //Sets players food to max value.
                        play.setWaterAmount(99);
                    }
                    else{
                        System.out.println("Player did not have sufficient currency or water is already full, purchace failed.");
                    }
                  break;
                case 5:
                    if (play.getCurrency() > 98){
                        System.out.print("What would you like to name your new pet: ");
                        input = scan.nextLine();
                      //TODO: Add ability to purchace pet with random stats.
                        Pet temp = new Pet(input, Misc.RNG(1, Stats.MAX_HUNGER), Misc.RNG(1, Stats.MAX_THIRST), Misc.RNG(1, Stats.MAX_ENERGY), 5);
                        Main.petCollection.add(temp);
                        Main.petCollection.forEach((v) -> {System.out.println(v);});
                    }
                    else{
                        System.out.println("Player did not have sufficient currency, could not purchase.");
                    }
                  break;
                default:
                    System.out.println("Something went wrong...");
              }
    }
}
