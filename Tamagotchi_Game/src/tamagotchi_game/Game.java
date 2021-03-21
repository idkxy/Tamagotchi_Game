package tamagotchi_game;

import java.util.Scanner;

public class Game extends Main{
    
    static Player play = new Player(25, 10, 10);
    
    public void mainGame(){
        Scanner scan = new Scanner(System.in);
        String user = "";
        
        for (;;){
            MenuLook.look(Pet.currentPet.stats.getEnergy(), Pet.currentPet.stats.getHunger(), Pet.currentPet.stats.getThirst(), Pet.currentPet.stats.getHappiness());
            
            user = InputValidation.regexValidate(scan, "ifcs");
            
            switch(user.toLowerCase()) {
                case "i":
                  MenuLook.selectionI();
                  user = InputValidation.regexValidate(scan, "1234");
                  SubMenuOptions.inputI(Integer.parseInt(user));
                  break;
                case "f":
                  MenuLook.selectionF();
                  user = InputValidation.regexValidate(scan, "123456");
                  SubMenuOptions.inputF(Integer.parseInt(user));
                  break;
                case "c":
                  MenuLook.selectionC();
                  user = InputValidation.regexValidate(scan, "PLACEHOLDER");
                  break;
                case "s":
                  MenuLook.selectionS(play.getCurrency(), play.getFoodAmount(), play.getWaterAmount());
                  user = InputValidation.regexValidate(scan, "1234");
                  SubMenuOptions.inputS(Integer.parseInt(user));
                  break;
                default:
                    System.out.println("Something went wrong...");
              }
        }
    }
}