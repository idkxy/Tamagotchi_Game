package tamagotchi_game;

import java.util.*;

public class Breed {

    private Pet mine;
    private Pet breed;

    ArrayList<Pet> petList = Main.petCollection;
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    String input;
    String name = "";
    boolean LOOP = true;

    public void create() {
        System.out.println("Do you wish to breed?");
        input = InputValidation.regexValidate(scan, "YyNn");
        if (input.trim().equalsIgnoreCase("y")) {
            if (petList.size() == 1) {
                System.out.println("Sorry you can not breed! You need two pets to breed!");
            } else {
                while (LOOP) {
                    System.out.println("Please choose from the following pets for breeding:");
                    for (int i = 0; i < petList.size(); ++i) {
                        System.out.println(petList.get(i + 1).toString());
                    }
                    input = InputValidation.regexValidate(scan, String.valueOf(petList.size()));
                    int choice = Integer.parseInt(input)-1;
                    if (!petList.get(choice).getName().equals(Pet.currentPet.getName())) {
                        System.out.println("Details of the pet chosen: ");
                        System.out.println(petList.get(choice).);
                        System.out.println("Are you sure you want to choose this pet for breeding? Y/N");
                        check = input.next();
                        if (choice.trim().equalsIgnoreCase("y")) {
                            if (petList.get(petChosen).getMaturity() == Maturity.ADULT) {
                                System.out.println("Great! A new pet has been created!");
                                System.out.println("Please give the new pet a name: ");
                                name = input.nextLine();
                                breed = new Pet(name, rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
                                petList.add(breed);
                                System.out.println("Details of the breed: " + breed.toString());
                                LOOP = false;
                            } else {
                                System.out.println("The chosen pet isnt mature. Please try again!");
                                LOOP = true;
                            }
                        } else {
                            LOOP = true;
                        }

                    } else {
                        System.out.println("You can not choose your current pet. Please try again!");
                        LOOP = true;
                    }

                }
            } else {
                System.out.println("You do not wish to breed! ");
            }

        }

    }
}
