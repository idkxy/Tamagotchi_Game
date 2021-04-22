package tamagotchi_game;

import java.util.Scanner;

public class ShopOption extends Shop {

    public static ShopOption shopOption = new ShopOption();
    Scanner s = new Scanner(System.in);
    private String userInput;

    public void shopInteract() {
        boolean LOOP = true;

        while (LOOP) {
            userInput = InputValidation.regexValidate(s, "12345x");
            switch (userInput) {
                case "1": {
                    if (Player.player.getCurrency() - Shop.shop.getFOOD_COST() >= 0 && Player.player.getFoodAmount() < 99) {
                        Player.player.setCurrency(Player.player.getCurrency() - Shop.shop.getFOOD_COST());
                        Player.player.setFoodAmount(Player.player.getFoodAmount() + 1);
                        Interface.menuShop();
                        System.out.println("Purchase completed! You now have " + Player.player.getFoodAmount() + " units of food!");
                    } else {
                        System.out.println("Insufficient funds! Purchase could not be completed!");
                    }
                }
                break;
                case "2": {
                    if (Player.player.getCurrency() - Shop.shop.getFOOD_COST() * (99 - Player.player.getFoodAmount()) >= 0 && Player.player.getFoodAmount() < 99) {
                        Player.player.setCurrency(Player.player.getCurrency() - Shop.shop.getFOOD_COST() * (99 - Player.player.getFoodAmount()));
                        Player.player.setFoodAmount(Player.player.getFoodAmount() + (99 - Player.player.getFoodAmount()));
                        System.out.println("Purchase completed! The number of food reaches max now!");
                        Interface.menuShop();
                    } else {
                        System.out.println("Insufficient funds! Purchase could not be completed!");
                    }
                }
                break;
                case "3": {
                    if (Player.player.getCurrency() - Shop.shop.getWATER_COST() >= 0 && Player.player.getWaterAmount() < 99) {
                        Player.player.setCurrency(Player.player.getCurrency() - Shop.shop.getFOOD_COST());
                        Player.player.setWaterAmount(Player.player.getWaterAmount() + 1);
                        Interface.menuShop();
                        System.out.println("Purchase completed! You now have " + Player.player.getWaterAmount() + " units of water!");
                    } else {
                        System.out.println("Insufficient funds! Purchase could not be completed!");
                    }
                }
                break;
                case "4": {
                    if (Player.player.getCurrency() - Shop.shop.getFOOD_COST() * (99 - Player.player.getWaterAmount()) < 0 && Player.player.getWaterAmount() < 99) {
                        Player.player.setCurrency(Player.player.getCurrency() - Shop.shop.getFOOD_COST() * (99 - Player.player.getFoodAmount()));
                        Player.player.setWaterAmount(Player.player.getWaterAmount() + (99 - Player.player.getWaterAmount()));
                        Interface.menuShop();
                        System.out.println("Purchase completed! The number of water reaches max now!");
                    } else {
                        System.out.println("Insufficient funds! Purchase could not be completed!");
                    }
                }
                break;
                case "5":
                    shop.generatePet();
                    shop.availablePets();
                    petChoice();
                    break;
                case "x":
                    LOOP = false;
                    break;
                default:
                    break;
            }
        }
    }

    public void petChoice() {
        System.out.print("Enter choice (1-5) | ");
        Scanner sc = new Scanner(System.in);
        String input = InputValidation.regexValidate(sc, "12345");
        int petChosen = Integer.parseInt(input) - 1;
        System.out.println("Pet " + shop.getPets().get(petChosen - 1).getName() + "is chosen");
        System.out.println("Do you wish to purchase the pet? Y/N");
        input = InputValidation.regexValidate(sc, "YyNn");
        if (input.equalsIgnoreCase("Y")) {
            System.out.println("Purchase completed! The pet cost you " + shop.getPets().get(-1).getValue());
            System.out.println("Current Balance: " + Player.player.getCurrency());
        } else if (input.equalsIgnoreCase("N")) {
            System.out.println("Do you wish to purchase another pet?");
        }
    }
}
