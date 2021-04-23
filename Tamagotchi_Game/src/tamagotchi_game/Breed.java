package tamagotchi_game;

import java.util.*;

/**
 * This method is used to breed pets.
 * requires 2 separate gendered pets.
 */
public class Breed {

    private Pet breed;

    HashMap<Integer, Pet> petList = Pet.petCollection;
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    String input;
    String name = "";
    boolean LOOP = true;

    /**
     *  
     */
    public void create() {
        if (petList.size() == 1) {
            System.out.println("Sorry you can not breed! You need two pets to breed!");
        } else {
            while (LOOP) {
                System.out.println("Please choose from the following pets for breeding:");
                String temp = "";
                for (int i = 0; i < petList.size(); ++i) {
                    System.out.print(i + 1 + ": ");
                    System.out.println(petList.get(i).toString());
                    temp += String.valueOf(i + 1);
                }
                input = InputValidation.regexValidate(scan, temp);
                int choice = Integer.parseInt(input) - 1;
                if (!petList.get(choice).getName().equals(Pet.currentPet.getName())) {
                    if (petList.get(choice).getMaturity() == Maturity.ADULT) {
                        System.out.println("Great! A new pet has been created!");
                        System.out.println("Please give the new pet a name: ");
                        name = scan.nextLine();
                        breed = new Pet(name, rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
                        breed.setMaturity(Maturity.BABY);
                        petList.put(Pet.petCollection.size() + 1, breed);
                        System.out.println("Details of the breed: " + breed.toString());
                        LOOP = false;
                    } else {
                        System.out.println("The chosen pet isnt mature. Please try again!");
                    }
                } else {
                    System.out.println("You can not choose your current pet. Please try again!");
                }
            }
        }
    }
}
