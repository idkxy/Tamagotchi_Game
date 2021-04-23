package tamagotchi_game;

/**
 * Print the menus for all sections of the game
 * 
 * @author DaisyXiao - 1392836
 * @author Liam Yates - 18016696
 * @author Liam Rimmer - 18040246
 */
public class Menu {

    public static void dashBoard() {
        String energy = String.format("%02d", Pet.petCollection.get(Pet.getIndex()).stats.getEnergy());
        String hunger = String.format("%02d", Pet.petCollection.get(Pet.getIndex()).stats.getHunger());
        String thirst = String.format("%02d", Pet.petCollection.get(Pet.getIndex()).stats.getThirst());
        String happiness = String.format("%02d", Pet.petCollection.get(Pet.getIndex()).stats.getHappiness());
        String gender = Pet.petCollection.get(Pet.getIndex()).getGender().name();
        String maturity = Pet.petCollection.get(Pet.getIndex()).getMaturity().name();
        String species = Pet.petCollection.get(Pet.getIndex()).getSpecies().name();

        System.out.println("____________________________________________________________________________");
        System.out.println("| Pet Name: " + String.format("%-9s", Pet.petCollection.get(Pet.getIndex()).getName()) + "                 Currency: $" + String.format("%-5s", Player.player.getCurrency()) + "  Food: " + String.format("%-2s", Player.player.getFoodAmount()) + "  Water: " + String.format("%-2s", Player.player.getWaterAmount()) + "|");
        System.out.println("|" + String.format("%-49s", (" Gender: " + gender + " | Maturity: " + maturity + " |" + " Species: " + species)) + "                         |");
        System.out.println("|    __________________________________________________________________    |");
        System.out.println("|   |  INTERACT (I) |  FEED (F) |  COMPETE (C) |  SHOP (S) | QUIT (Q)  |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|   | Total Pets: " + Pet.petCollection.size() + "                                                    |   |");
        System.out.println("|   |                                                                  |   |");
        SpeciesArt.printPet(Pet.petCollection.get(Pet.getIndex()));
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|   | ENERGY: " + energy + "/" + Stats.MAX_ENERGY + " | HUNGER: " + hunger + "/" + Stats.MAX_HUNGER + " | THIRST: " + thirst + "/" + Stats.MAX_THIRST + " | HAPPINESS: " + happiness + "/" + Stats.MAX_HAPPINESS + " |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|__________________________________________________________________________|");
    }

    public static void menuInteract() {
        System.out.println("____________________________________________________________________________");
        System.out.println("|    __________________________________________________________________    |");
        System.out.println("|   |              PAT (1) | BREED (2) | SELECT PET (3)                |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|__________________________________________________________________________|");
    }

    public static void menuFeed() {
        System.out.println("____________________________________________________________________________");
        System.out.println("|    __________________________________________________________________    |");
        System.out.println("|   |         SINGLE USE:      FOOD (1) | WATER (2) | BOTH (3)         |   |");
        System.out.println("|   |         FILL ATTRIBUTE:  FOOD (4) | WATER (5) | BOTH (6)         |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|__________________________________________________________________________|");
    }

    public static void menuCompetition() {
        System.out.println("____________________________________________________________________________");
        System.out.println("|    __________________________________________________________________    |");
        System.out.println("|   | My Pet :   " + String.format("%-8s", Pet.petCollection.get(Pet.getIndex()).getName()) + "            " + "|" + "  Opponent:   " + String.format("%8s", Competition.c.getOpponent().getName()) + "           |   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   |                 $100 to enter.  Compete?  Y / N                  |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|__________________________________________________________________________|");
    }

    public static void menuShop() {
        String pC = String.format("%-5d", Player.player.getCurrency());
        String fA = String.format("%02d", Player.player.getFoodAmount());
        String wA = String.format("%02d", Player.player.getWaterAmount());

        System.out.println("____________________________________________________________________________");
        System.out.println("|    __________________________________________________________________    |");
        System.out.println("|   | PLAYER CURRENCY: $" + pC + " | FOOD AMOUNT: " + fA + " | WATER AMOUNT: " + wA + "     |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   | PURCHACE FOOD x 1  | (Press 1)                       COST: " + Shop.shop.getFOOD_COST() + "    |   |");
        System.out.println("|   | FILL FOOD x" + (99 - Integer.parseInt(fA)) + "      | (Press 2)                       COST: " + ((99 - Integer.parseInt(wA)) * Shop.shop.getFOOD_COST()) + "  |   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   | PURCHACE WATER x 1 | (Press 3)                       COST: " + Shop.shop.getWATER_COST() + "    |   |");
        System.out.println("|   | FILL WATER x" + (99 - Integer.parseInt(wA)) + "     | (Press 4)                       COST: " + ((99 - Integer.parseInt(wA)) * Shop.shop.getWATER_COST()) + "   |   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   | PURCHACE PET (RANDOM STATS) x 1 (Press 5)                        |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|__________________________________________________________________________|");
    }

    public void mainMenu() {
        System.out.println("-----   MAIN MENU   -----");
        System.out.println("1. New Game\n2. Load Game\n3. Instructions");
    }
    
    public void instructions()
    {
        System.out.println("INTERACT: gives options to interact with pet such as breeding\n"
                + "FEED: allows the player to feed and give water to the pet\n"
                + "COMPETE: lets the player compete for prizes!\n"
                + "SHOP: sells items for pets, such as food and pets\n"
                + "QUIT: saves and quits the game\n"
                + "Pets lose stats in competitions so be sure to feed and pat the pet after!\n");
    }
}
