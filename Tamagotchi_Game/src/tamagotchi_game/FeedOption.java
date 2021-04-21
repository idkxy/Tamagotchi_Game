package tamagotchi_game;

import static tamagotchi_game.Game.play;

public class FeedOption {
    
    public static void Feed(int userInput){
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
    
}
