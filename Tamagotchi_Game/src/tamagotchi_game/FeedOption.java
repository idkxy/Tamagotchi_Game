package tamagotchi_game;

public class FeedOption {
    
    public static void Feed(int userInput){
        switch(userInput) {
                case 1:
                  //Food
                    if (Player.player.getFoodAmount() > 0 && Pet.currentPet.stats.getHunger() < 10){
                        Player.player.setFoodAmount(Player.player.getFoodAmount() - 1);
                        Pet.currentPet.stats.setHunger(Pet.currentPet.stats.getHunger() + 1);
                    }
                    else{
                        System.out.println("Not enough food or pet is not hungry, could not feed.");
                    }
                  break;
                case 2:
                  //Water
                    if (Player.player.getWaterAmount()> 0 && Pet.currentPet.stats.getThirst()< 10){
                        Player.player.setWaterAmount(Player.player.getWaterAmount() - 1);
                        Pet.currentPet.stats.setThirst(Pet.currentPet.stats.getThirst()+ 1);
                    }
                    else{
                        System.out.println("Not enough water or pet is not thirsty, could not feed.");
                    }
                  break;
                case 3:
                  //Both
                    if ((Player.player.getFoodAmount() > 0 && Pet.currentPet.stats.getHunger() < 10) && (Player.player.getWaterAmount()> 0 && Pet.currentPet.stats.getThirst()< 10)){
                        Player.player.setFoodAmount(Player.player.getFoodAmount() - 1);
                        Pet.currentPet.stats.setHunger(Pet.currentPet.stats.getHunger() + 1);
                        
                        Player.player.setWaterAmount(Player.player.getWaterAmount() - 1);
                        Pet.currentPet.stats.setThirst(Pet.currentPet.stats.getThirst()+ 1);
                    }
                    else{
                        System.out.println("Not enough food and/ or water or pet is not hungry and/ or thirsty.");
                    }
                  break;
                case 4:
                  //Fill food
                    if (Player.player.getFoodAmount() >= (10 - Player.player.getFoodAmount()) && Pet.currentPet.stats.getHunger() < 10){
                        Player.player.setFoodAmount(10 - Pet.currentPet.stats.getHunger());
                        Pet.currentPet.stats.setHunger(10);
                    }
                    else{
                        System.out.println("Not enough food or pet is not hungry, could not feed.");
                    }
                  break;
                case 5:
                  //Fill water
                    if (Player.player.getWaterAmount()>= (10 - Player.player.getWaterAmount()) && Pet.currentPet.stats.getThirst()< 10){
                        Player.player.setWaterAmount(10 - Pet.currentPet.stats.getThirst());
                        Pet.currentPet.stats.setThirst(10);
                    }
                    else{
                        System.out.println("Not enough water or pet is not thirsty, could not feed.");
                    }
                  break;
                case 6:
                  //Fill both
                    if ((Player.player.getFoodAmount() > 0 && Pet.currentPet.stats.getHunger() < 10) && (Player.player.getWaterAmount()> 0 && Pet.currentPet.stats.getThirst()< 10)){
                        //Fills food at a cost.
                        Player.player.setFoodAmount(10 - Pet.currentPet.stats.getHunger());
                        Pet.currentPet.stats.setHunger(10);
                        //Fills water at a cost.
                        Player.player.setWaterAmount(10 - Pet.currentPet.stats.getThirst());
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
