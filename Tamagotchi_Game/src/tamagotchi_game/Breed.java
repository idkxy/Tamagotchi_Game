package tamagotchi_game;

import java.util.Scanner;

public class Breed extends Game{
    public static void breedOptions(int petCount){
        Scanner scan = new Scanner(System.in);
        String input = "";
        
        if (petCount > 1){
            System.out.println("Please select an additional pet for breeding");
            
            //Prints the users options
            for (int num = 0; num < petCollection.size(); num++){
                System.out.println(petCollection.get(num));
            }
            
            input = scan.nextLine();
        }
        else{
            System.out.println("Player must have more than one pet for breeding");
        }
    }
}
