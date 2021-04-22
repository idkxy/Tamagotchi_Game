package tamagotchi_game;

import java.util.Scanner;

public class ShopOption extends Shop {

    public static ShopOption shopOption = new ShopOption();
    Scanner s = new Scanner(System.in);
    private String userInput;

    public void shopInteract() throws InterruptedException {
        boolean LOOP = true;
        userInput = InputValidation.regexValidate(s, "12345x");
        while (LOOP) {
            
            switch (userInput) {
                case "1": {
                    if (Player.player.getCurrency() - Shop.shop.getFOOD_COST() >= 0 && Player.player.getFoodAmount() < 99) {
                        Player.player.setCurrency(Player.player.getCurrency() - Shop.shop.getFOOD_COST());
                        Player.player.setFoodAmount(Player.player.getFoodAmount() + 1);
                        Interface.menuShop();
                        System.out.println("Purchase completed! You now have " + Player.player.getFoodAmount() + " units of food!");
                    } else {
                        System.out.println("Insufficient funds! Purchase could not be completed!");
                        LOOP= false;
                        System.out.println("Going back to previous menu...");
                        Thread.sleep(1000);
                    }
                }
                break;
                case "2": {
                    if (Player.player.getCurrency() - Shop.shop.getFOOD_COST() * (99 - Player.player.getFoodAmount()) >= 0 && Player.player.getFoodAmount() < 99) {
                        Player.player.setCurrency(Player.player.getCurrency() - Shop.shop.getFOOD_COST() * (99 - Player.player.getFoodAmount()));
                        Player.player.setFoodAmount(99);
                        System.out.println("Purchase completed! The number of food reaches max now!");
                        Interface.menuShop();
                    } else {
                        System.out.println("Insufficient funds! Purchase could not be completed!");
                        LOOP= false;
                        System.out.println("Going back to previous menu...");
                        Thread.sleep(1000);
                    }
                }
                break;
                case "3": {
                    if (Player.player.getCurrency() - Shop.shop.getWATER_COST() >= 0 && Player.player.getWaterAmount() < 99) {
                        Player.player.setCurrency(Player.player.getCurrency() - Shop.shop.getFOOD_COST());
                        Player.player.setWaterAmount(Player.player.getWaterAmount() + 1);
                        Interface.menuShop();
                        System.out.println("Purchase completed! You now have " + Player.player.getWaterAmount() + " units of water!");
                        LOOP= false;
                        System.out.println("Going back to previous menu...");
                        Thread.sleep(1000);
                    } else {
                        System.out.println("Insufficient funds! Purchase could not be completed!");
                        LOOP= false;
                        System.out.println("Going back to previous menu...");
                        Thread.sleep(1000);
                    }
                }
                break;
                case "4": {
                    if (Player.player.getCurrency() - Shop.shop.getWATER_COST()* (99 - Player.player.getWaterAmount()) > 0 && Player.player.getWaterAmount() < 99) {
                        Player.player.setCurrency(Player.player.getCurrency() - Shop.shop.getWATER_COST() * (99 - Player.player.getWaterAmount()));
                        Player.player.setWaterAmount(99);
                        Interface.menuShop();
                        System.out.println("Purchase completed! The number of water reaches max now!");
                         LOOP= false;
                        System.out.println("Going back to previous menu...");
                        Thread.sleep(1000);
                    } else {
                        System.out.println("Insufficient funds! Purchase could not be completed!");
                         LOOP= false;
                        System.out.println("Going back to previous menu...");
                        Thread.sleep(1000);
                    }
                }
                break;
                case "5":
                     shop.PetInShop();
                     shop.PrintAvailablePets();
                     petChoice();
                     System.out.println("Going back to previous menu...");
                     Thread.sleep(1000);
                     LOOP= false;
                    break;
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

    public void petChoice() {
        
       
        boolean run = true;
        while(run)
        {   
            Scanner sc = new Scanner(System.in);
            String input = InputValidation.regexValidate(sc, "12345");
            int petChosen = Integer.parseInt(input) - 1;
            System.out.println("Pet " + shop.getPets().get(petChosen).getName() + " is chosen");
            System.out.println("Do you wish to purchase the pet? Y/N");
            String purchase = InputValidation.regexValidate(sc, "YyNn");
            if (purchase.equalsIgnoreCase("Y")) {
                System.out.println("Purchase completed! The pet cost you $" + shop.getPets().get(petChosen).getValue());
                Player.player.setCurrency(Player.player.getCurrency() - shop.getPets().get(petChosen).getValue());
                System.out.println("Current Balance: $" + Player.player.getCurrency());
                Main.petCollection.add(shop.getPets().get(petChosen));
                shop.getPets().remove(shop.getPets().get(petChosen));
                shop.getPets().remove(petChosen);
                run = false;
            } else {
                System.out.println("Do you wish to purchase another pet?");
                String purchaseAnother = InputValidation.regexValidate(sc, "YyNn");
                if (purchaseAnother.equalsIgnoreCase("Y")) {
                    
                }
                else
                {
                    run = false;
                }
            }
        }

    }
}