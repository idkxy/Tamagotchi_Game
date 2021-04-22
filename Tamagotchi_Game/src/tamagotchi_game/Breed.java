package tamagotchi_game;

import java.util.*;

public class Breed {

    private Pet mine;
    private Pet breed;

    ArrayList<Pet> petList = Main.petCollection;

    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    String choice = "";
    String check = "";
    String name = "";
    boolean run = true;
    private int petChosen;

    public void create() {
        System.out.println("Do you wish to breed? Y/N");
        choice = input.next();
        if (choice.trim().equalsIgnoreCase("y")) {
            if (petList.size() > 0 && petList.size() < 1) {
                System.out.println("Sorry you can not breed! You need two pets to breed!");
            } else if (petList.size() >= 2) {
                while (run) {
                    System.out.println("Please choose from the following pets for breeding:");
                    for (int i = 0; i < petList.size(); ++i) {
                        System.out.println(petList.get(i + 1).toString());
                    }
                    petChosen = input.nextInt();
                    if (!petList.get(petChosen).getName().equals(mine.getName()) ) {
                        System.out.println("Details of the pet chosen: " + petList.get(petChosen).toString() + "Maturity stats: " + petList.get(petChosen).getMaturity());
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
                                run = false;
                            } else {
                                System.out.println("The chosen pet isnt mature. Please try again!");
                                run = true;
                            }
                        } else {
                            run = true;
                        }

                    } else {
                        System.out.println("You can not choose your current pet. Please try again!");
                        run = true;
                    }

                }
            } else {
                System.out.println("You do not wish to breed! ");
            }

        }

    }
}
