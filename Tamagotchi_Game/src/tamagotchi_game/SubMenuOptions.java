package tamagotchi_game;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Scanner;

public class SubMenuOptions extends Game{
    
    static Scanner scan = new Scanner(System.in);
    
    public static void inputI(int userInput){
        String input = "";
        switch(userInput) {
                case 1:
                    //Will increase pet happiness by 1
                    long temp = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                    if (Pet.currentPet.getLastpatTime() <= temp-3600000)
                    {
                        Pet.currentPet.stats.setHappiness(Pet.currentPet.stats.getHappiness()+1);
                        Pet.currentPet.setLastpatTime(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());                        
                    }
                    else
                    {
                        System.out.println(Pet.currentPet.getLastpatTime() + "minutes till next happiness increase through petting!");
                    }
                  break;
                case 2:
                    //TODO: Will ask user to select another pet to breed with current pet.
                    
                  break;
                case 3:
                  //TODO: Change current pet if player has more than one pet
                    if (Main.petCollection.size() > 1){
                        System.out.println("Player pets:");

                        
                        Main.petCollection.forEach((v) -> {System.out.println(v);});

                        System.out.println("Please select desired pet");
                        input = InputValidation.regexValidate(scan, "0123456789");

                        petCollection.set(Integer.parseInt(input), Pet.currentPet.stats);
                    }
                    else{
                        System.out.println("Player requires more than one pet to use this function.");
                    }
                    //Cap pets displayed at 10 at a time as to enable user to enter only (0 - 9) + 1.
                  break;
                case 4:
                  //TODO: Sell currently equiped pet if player has more than one pet.
                    if (Main.petCollection.size() > 1){
                        System.out.println("WARNING: YOU ARE ABOUT TO SELL YOUR EQUIPED PET. ARE YOU SURE YOU WISH TO PROCEED? (Y/ N)");
                        System.out.println("NOTE: A pets worth is based on its happiness. Maxing this stat will give a max price of 90");
                        System.out.println("Your pets current worth is " + (Pet.currentPet.stats.getHappiness()) * 9);
                        input = InputValidation.regexValidate(scan, "ny");

                        if (input.equals("y") && Main.petCollection.size() > 1){
                            play.setCurrency(play.getCurrency() + (Pet.currentPet.stats.getHappiness()) * 9);

                            Main.petCollection.remove(Pet.currentPet.stats);
                        }
                        else{
                            System.out.println("CANCELLED");
                        } 
                    }
                    else{
                        System.out.println("Player needs more pets to use this function.");
                    }
                        
                  break;
                default:
                    System.out.println("Something went wrong...");
              }
    }
    
    public static void inputF(int userInput){
        switch(userInput) {
                case 1:
                  //Food
                    if (play.getFoodAmount() > 0 && Pet.currentPet.stats.getHunger() < 10){
                        play.setFoodAmount(play.getFoodAmount() - 1);
                        Pet.currentPet.stats.setHunger(Pet.currentPet.stats.getHunger() + 1);
                    }
                    else{
                        System.out.println("Not enough food or pet is not hungry, could not feed.");
                    }
                  break;
                case 2:
                  //Water
                    if (play.getWaterAmount()> 0 && Pet.currentPet.stats.getThirst()< 10){
                        play.setWaterAmount(play.getWaterAmount() - 1);
                        Pet.currentPet.stats.setThirst(Pet.currentPet.stats.getThirst()+ 1);
                    }
                    else{
                        System.out.println("Not enough water or pet is not thirsty, could not feed.");
                    }
                  break;
                case 3:
                  //Both
                    if ((play.getFoodAmount() > 0 && Pet.currentPet.stats.getHunger() < 10) && (play.getWaterAmount()> 0 && Pet.currentPet.stats.getThirst()< 10)){
                        play.setFoodAmount(play.getFoodAmount() - 1);
                        Pet.currentPet.stats.setHunger(Pet.currentPet.stats.getHunger() + 1);
                        
                        play.setWaterAmount(play.getWaterAmount() - 1);
                        Pet.currentPet.stats.setThirst(Pet.currentPet.stats.getThirst()+ 1);
                    }
                    else{
                        System.out.println("Not enough food and/ or water or pet is not hungry and/ or thirsty.");
                    }
                  break;
                case 4:
                  //Fill food
                    if (play.getFoodAmount() >= (10 - play.getFoodAmount()) && Pet.currentPet.stats.getHunger() < 10){
                        play.setFoodAmount(10 - Pet.currentPet.stats.getHunger());
                        Pet.currentPet.stats.setHunger(10);
                    }
                    else{
                        System.out.println("Not enough food or pet is not hungry, could not feed.");
                    }
                  break;
                case 5:
                  //Fill water
                    if (play.getWaterAmount()>= (10 - play.getWaterAmount()) && Pet.currentPet.stats.getThirst()< 10){
                        play.setWaterAmount(10 - Pet.currentPet.stats.getThirst());
                        Pet.currentPet.stats.setThirst(10);
                    }
                    else{
                        System.out.println("Not enough water or pet is not thirsty, could not feed.");
                    }
                  break;
                case 6:
                  //Fill both
                    if ((play.getFoodAmount() > 0 && Pet.currentPet.stats.getHunger() < 10) && (play.getWaterAmount()> 0 && Pet.currentPet.stats.getThirst()< 10)){
                        //Fills food at a cost.
                        play.setFoodAmount(10 - Pet.currentPet.stats.getHunger());
                        Pet.currentPet.stats.setHunger(10);
                        //Fills water at a cost.
                        play.setWaterAmount(10 - Pet.currentPet.stats.getThirst());
                        Pet.currentPet.stats.setThirst(10);
                    }
                    else{
                        System.out.println("Not enough food and/ or water or pet is not hungry and/ or thirsty.");
                    }
                  break;
                default:
                    System.out.println("Something went wrong...");
                    break;
              }
    }
    
    public static void inputC(int userInput){
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
    
    public static void inputS(int userInput){
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
