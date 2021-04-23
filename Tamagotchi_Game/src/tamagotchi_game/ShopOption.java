package tamagotchi_game;

import java.util.Scanner;

/**
 * This is the class that handles all the choice made in the Shop class 
 * @author DaisyXiao - 1392836
 */
public class ShopOption extends Shop {

    /**
     * This method handles all the choice made in the Shop class according to the 
     * available options 
     */
    public static ShopOption shopOption = new ShopOption();
    Scanner s = new Scanner(System.in);
    private String userInput;

    public void shopInteract() throws InterruptedException {
        boolean LOOP = true;
        userInput = InputValidation.regexValidate(s, "12345x");
        while (LOOP) {

            switch (userInput) {
                //checks if the user has sufficient fund to to purchase a single unit of food
                case "1": {
                    if (Player.player.getCurrency() - Shop.shop.getFOOD_COST() >= 0 && Player.player.getFoodAmount() < 99) {
                        Player.player.setCurrency(Player.player.getCurrency() - Shop.shop.getFOOD_COST());
                        Player.player.setFoodAmount(Player.player.getFoodAmount() + 1);
                        Interface.menuShop();
                        System.out.println("Purchase completed! You now have " + Player.player.getFoodAmount() + " units of food!");
                    } else {
                        if(Player.player.getFoodAmount() == 99)
                        {
                            System.out.println("Food amount has reached maximum! Purchase can not be completed!");
                        }
                        else if(Player.player.getCurrency() - Shop.shop.getFOOD_COST() < 0)
                        {
                            System.out.println("Insufficient funds! Purchase could not be completed!");
                        }
                        LOOP = false;
                        System.out.println("Going back to previous menu...");
                        Thread.sleep(1000);
                    }
                }
                break;
                //checks if the user has sufficient fund to make a purchase so that the total amount of food reaches 99
                case "2": {
                    if (Player.player.getCurrency() - Shop.shop.getFOOD_COST() * (99 - Player.player.getFoodAmount()) >= 0 && Player.player.getFoodAmount() < 99) {
                        Player.player.setCurrency(Player.player.getCurrency() - Shop.shop.getFOOD_COST() * (99 - Player.player.getFoodAmount()));
                        Player.player.setFoodAmount(99);
                        System.out.println("Purchase completed! The number of food reaches max now!");
                        Interface.menuShop();
                    } else {
                        if(Player.player.getFoodAmount() == 99)
                        {
                            System.out.println("Water amount has reached maximum! Purchase can not be completed!");
                        }
                        else if(Player.player.getCurrency() - Shop.shop.getFOOD_COST() * (99 - Player.player.getFoodAmount()) < 0)
                                {
                                    System.out.println("Insufficient funds! Purchase could not be completed!");
                                }
                        
                        LOOP = false;
                        System.out.println("Going back to previous menu...");
                        Thread.sleep(1000);
                    }
                }
                break;
                //checks if the user has sufficient fund to make a purchase single unit of water
                case "3": {
                    if (Player.player.getCurrency() - Shop.shop.getWATER_COST() >= 0 && Player.player.getWaterAmount() < 99) {
                        Player.player.setCurrency(Player.player.getCurrency() - Shop.shop.getFOOD_COST());
                        Player.player.setWaterAmount(Player.player.getWaterAmount() + 1);
                        Interface.menuShop();
                        System.out.println("Purchase completed! You now have " + Player.player.getWaterAmount() + " units of water!");
                        LOOP = false;
                        System.out.println("Going back to previous menu...");
                        Thread.sleep(1000);
                    } else {
                        
                       if(Player.player.getWaterAmount() == 99)
                        {
                            System.out.println("Food amount has reached maximum! Purchase can not be completed!");
                        }
                        else if(Player.player.getCurrency() - Shop.shop.getWATER_COST() < 0)
                        {
                             System.out.println("Insufficient funds! Purchase could not be completed!");
                        }
                        LOOP = false;
                        System.out.println("Going back to previous menu...");
                        Thread.sleep(1000);
                    }
                }
                break;
                //checks if the user has sufficient fund to make a purchase so that the water amount could be increased to 99
                case "4": {
                    if (Player.player.getCurrency() - Shop.shop.getWATER_COST() * (99 - Player.player.getWaterAmount()) > 0 && Player.player.getWaterAmount() < 99) {
                        Player.player.setCurrency(Player.player.getCurrency() - Shop.shop.getWATER_COST() * (99 - Player.player.getWaterAmount()));
                        Player.player.setWaterAmount(99);
                        Interface.menuShop();
                        System.out.println("Purchase completed! The number of water reaches max now!");
                        LOOP = false;
                        System.out.println("Going back to previous menu...");
                        Thread.sleep(1000);
                    } else {
                        if(Player.player.getWaterAmount() == 99)
                        {
                            System.out.println("Food amount has reached maximum! Purchase can not be completed!");
                        }
                        else if(Player.player.getCurrency() - Shop.shop.getWATER_COST() * (99 - Player.player.getWaterAmount()) < 0 )
                        {
                             System.out.println("Insufficient funds! Purchase could not be completed!");
                        }
                       
                        LOOP = false;
                        System.out.println("Going back to previous menu...");
                        Thread.sleep(1000);
                    }
                }
                break;
                //Displays the available pets and takes in user input as choice of pet and performs differently according to user input
                case "5":
                    shop.PetInShop();
                    petChoice();
                    System.out.println("Going back to previous menu...");
                    Thread.sleep(1000);
                    LOOP = false;
                    break;
                //Quit from current menu and go back to the main menu
                case "x":
                    LOOP = false;
                    System.out.println("Going back to the previous menu...");
                    Thread.sleep(1000);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * This method handles the user's choice of pet among the pets available in shop
     * and interact with the user accordingly
     */
    public void petChoice() {

        boolean run = true;
        while (run) {
            Scanner sc = new Scanner(System.in);
            String input = InputValidation.regexValidate(sc, "12345");
            int petChosen = Integer.parseInt(input) - 1;
            System.out.println("Pet " + shop.getPets().get(petChosen).getName() + " is chosen");
            System.out.println("Do you wish to purchase the pet? Y/N");
            input = InputValidation.regexValidate(sc, "yn");
            if (input.equalsIgnoreCase("Y")) {
                System.out.println("Purchase completed! The pet cost you $" + shop.getPets().get(petChosen).getValue());
                Player.player.setCurrency(Player.player.getCurrency() - shop.getPets().get(petChosen).getValue());
                System.out.println("Current Balance: $" + Player.player.getCurrency());
                Pet.petCollection.put(Pet.petCollection.size() + 1, shop.getPets().get(petChosen));
                //shop.getPets().remove(shop.getPets().get(petChosen));
                shop.getPets().remove(petChosen);
                run = false;
            } else {
                System.out.println("Do you wish to purchase another pet?");
                input = InputValidation.regexValidate(sc, "yn");
                if (input.equalsIgnoreCase("n")) {
                    run = false;
                }
            }
        }

    }
}
