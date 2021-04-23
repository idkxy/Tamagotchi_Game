package tamagotchi_game;

import java.util.*;

/**
 * This method is used to breed pets. requires 2 separate gendered pets.
 * 
 * @author DaisyXiao - 1392836
 * @author Liam Yates - 18016696
 * @author Liam Rimmer - 18040246
 */
public class Breed {

    private Pet breed;

    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    String input;
    String name = "";
    boolean LOOP = true;

    /**
     * This method will create a breed from the current pet if the required
     * conditions are met
     */
    public void create() {
        if (Pet.petCollection.size() == 1) {
            System.out.println("Sorry you can not breed! You need two pets to breed!");
        } else {
            while (LOOP) {
                System.out.println("Please choose from the following pets for breeding:");
                String temp = "";
                for (int i = 0; i < Pet.petCollection.size(); ++i) {
                    System.out.print(i + 1 + ": ");
                    System.out.println(Pet.petCollection.get(i + 1).printPetDetails());
                    temp += String.valueOf(i + 1);
                }
                //checks if the pet in the specified index of the petList is mature to breed
                input = InputValidation.regexValidate(scan, temp);
                int choice = Integer.parseInt(input);
                if (Pet.petCollection.get(choice).getMaturity() == Maturity.ADULT) {
                    System.out.println("Great! A new pet has been created!");
                    System.out.println("Please give the new pet a name: ");
                    name = scan.nextLine();
                    breed = new Pet(name, rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
                    breed.setMaturity(Maturity.BABY);
                    Pet.petCollection.put(Pet.petCollection.size() + 1, breed);
                    System.out.println("Details of the breed: " + breed.toString());
                    LOOP = false;
                } else {
                    System.out.println("The chosen pet isnt mature. Please try again!");
                }
            }
        }
    }
}
