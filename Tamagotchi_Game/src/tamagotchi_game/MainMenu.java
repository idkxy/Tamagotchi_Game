package tamagotchi_game;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MainMenu {

//    Intro credits
    public static void intro() {
        System.out.println("\n\nWelcome to Magic Hand Eventually Extended to Sausage!");
        System.out.println("\nDesigned and Developed by:\nLiam Yates\nDaisy Xiao\nLiam Rimmer\n");
        System.out.println("-------------------------\n\n");
    }

    public static void mainMenu() throws FileNotFoundException, InterruptedException {

        System.out.println("-----   MAIN MENU   -----");
        System.out.println("1. New Game\n2. Load Game");
        Scanner scan = new Scanner(System.in);
        String input;
        input = InputValidation.regexValidate(scan, "12");

        switch (input) {
            case "1":
                newGame();
                break;
            case "2":
                loadGame();
                break;
            default:
                System.out.println("error");
                break;
        }
    }

    private static void newGame() throws FileNotFoundException, InterruptedException {
        String input;
        Scanner scan = new Scanner(System.in);
        //create starter pets
        Pet[] starterPet = new Pet[3];
        for (int i = 0; i < starterPet.length; i++) {
            starterPet[i] = Pet.PetGenerator();
            starterPet[i].setMaturity(Maturity.BABY);
        }
        System.out.println("Creating a new game...\n");
        System.out.println("Select starting pet:");
        System.out.println("--------------------");
        System.out.println("  | Name | Species | Gender | Maturity | Hunger | Thirst | Energy |");
        int count = 1;
        for (Pet x : starterPet) {
            System.out.printf(count + ".  " + x.getName() + "    " + String.format("%-5s", x.getSpecies()) + "    " + String.format("%1$5s", x.getGender()) + (x.getGender() == Gender.MALE ? "     " : "    ") + String.format("%1$5s", x.getMaturity()) + "        " + x.stats.getHunger() + "        " + x.stats.getThirst() + "        " + x.stats.getEnergy() + "\n");
            count++;
        }
        input = InputValidation.regexValidate(scan, "123");
        //add choice to pet collection
        Pet.setIndex(0);
        Pet.petCollection.put(Pet.getIndex(), starterPet[Integer.parseInt(input)-1]);
        //Pet.setCurrentPet(starterPet[Integer.parseInt(input) - 1], 0);
        Pet.currentPet.setCreated(LocalDateTime.now());
        //Pet.petCollection.add(Pet.currentPet);

        System.out.println("You have selected " + Pet.currentPet.getName() + "!");
        System.out.println("You now own " + Pet.petCollection.size() + " pet" + (Pet.petCollection.size() > 1 ? "s." : "."));

    }

    private static void loadGame() throws FileNotFoundException, InterruptedException {
        File file = new File("save.txt");
        if (file.length() == 0) {
            System.out.println("No saved games! create a new game first!");
            newGame();
        } else {
            try {
                Scanner scan = new Scanner(file);
                String[] pets;
                String[] stats;

                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    // store player stats in array
                    if (line.equals("@P_STATS")) {
                        line = scan.nextLine();
                        stats = line.split(",");
                        Player.player.setCurrency(Integer.parseInt(stats[0]));
                        Player.player.setFoodAmount(Integer.parseInt(stats[1]));
                        Player.player.setWaterAmount(Integer.parseInt(stats[2]));

                    }
                    // store player pets in array
                    if (line.equals("@PETS")) {
                        int count = 0;
                        while (scan.hasNextLine()) {
                            line = scan.nextLine();
                            pets = line.split(",");
                            Pet pet = new Pet(pets[0], Integer.parseInt(pets[1]), Integer.parseInt(pets[2]), Integer.parseInt(pets[3]), Integer.parseInt(pets[4]));
                            pet.setGender(Gender.valueOf(pets[5]));
                            pet.setMaturity(Maturity.valueOf(pets[6]));
                            pet.setSpecies(Species.valueOf(pets[7]));
                            Competition comp = new Competition();
                            pet.setCompetition(comp);
                            pet.getCompetition().setCptEntered((Integer.parseInt(pets[8])));
                            pet.getCompetition().setWinCount((Integer.parseInt(pets[9])));
                            pet.getCompetition().setLoseCount((Integer.parseInt(pets[10])));
                            LocalDateTime created = LocalDateTime.parse(pets[11]);
                            LocalDateTime lastpet = LocalDateTime.parse(pets[12]);
                            pet.setCreated(created);
                            pet.setLastpatTime(lastpet);
                            count++;
                            Pet.petCollection.put(count, pet);
                        }
                    }
                }
                scan.close();
                // set first saved pet to current pet
                Pet.setIndex(1);
            } catch (FileNotFoundException e) {
                System.out.println("No save games found in " + file + "!");
            }
        }
    }
}
