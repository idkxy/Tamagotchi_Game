/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tamagotchi_game;
import java.util.Scanner;

/**
 *
 * @author idkxy
 */
public class ShopOption extends Shop {
    
    Scanner s = new Scanner(System.in);
    private String userInput;
    
    public void shopInteract()
    {
        userInput = InputValidation.regexValidate(s, "12345");
       
        switch(Integer.parseInt(userInput))
        {
            case 1:
                purchaseCheck();
                break;
            case 2:
                purchaseCheck();
                break;
            case 3:
                purchaseCheck();
                break;
            case 4:
                purchaseCheck();
                break;
            case 5:
                shop.toString();
                break;
        }
            
    }
    
    public void purchaseCheck()
    {
        if((Player.player.getCurrency() - Shop.shop.getFOOD_COST()) < 0 || Player.player.getCurrency() - Shop.shop.getFOOD_COST() * (99 - Player.player.getFoodAmount()) < 0
           ||(Player.player.getCurrency() - Shop.shop.getWATER_COST()) < 0 || Player.player.getCurrency() - Shop.shop.getFOOD_COST() * (99 - Player.player.getWaterAmount()) < 0)
        {
            System.out.println("Insufficient fund! Phurchase could not be completed!");
        }
        else
        {
            if(Player.player.getCurrency() - Shop.shop.getFOOD_COST() >= 0)
            {
              Player.player.setCurrency(Player.player.getCurrency() - Shop.shop.getFOOD_COST());
             
              System.out.println("Purchase completed! You now have " + Player.player.getFoodAmount() + " units of food!");
            }
            else if(Player.player.getCurrency() - Shop.shop.getFOOD_COST() * (99 - Player.player.getFoodAmount()) >= 0)
            {
              Player.player.setCurrency(Player.player.getCurrency() - Shop.shop.getFOOD_COST() * (99 - Player.player.getFoodAmount()));
              System.out.println("Purchase completed! The number of food reaches max now!");
              
            }
            else if(Player.player.getCurrency() - Shop.shop.getWATER_COST() >= 0 )
            {
                
                Player.player.setWaterAmount(Player.player.getWaterAmount() + 1);
                System.out.println("Purchase completed! You now have " + Player.player.getWaterAmount() + " units of water!");
            }
            else if(Player.player.getCurrency() - Shop.shop.getFOOD_COST() * (99 - Player.player.getWaterAmount()) < 0)
            {
              Player.player.setCurrency(Player.player.getCurrency() - Shop.shop.getFOOD_COST() * (99 - Player.player.getFoodAmount()));
              System.out.println("Purchase completed! The number of water reaches max now!");
            }
            System.out.println("Your current balance is: " + Player.player.getCurrency());
        }
        
    }
    
    public void petChoice()
    {
        Scanner sc = new Scanner(System.in);
        String input = InputValidation.regexValidate(sc, "12345");
        int petChosen = Integer.parseInt(input);
        String confirmation = "";
        System.out.println("Pet " + shop.getPets().get(petChosen - 1).getName() + "is chosen" );
        System.out.println("Do you wish to purchase the pet? Y/N");
        confirmation = sc.nextLine();
        confirmation =  InputValidation.regexValidate(sc, "YyNn");
        if(confirmation.equalsIgnoreCase("Y"))
        {
            System.out.println("Purchase completed! The pet cost you " + shop.getPets().get( - 1).getValue());
            
        }
        else if(confirmation.equalsIgnoreCase("N"))
        {
            System.out.println("Do you wish to purchase another pet?");
            
        }
        
    }
    
}
