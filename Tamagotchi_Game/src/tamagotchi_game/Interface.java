package tamagotchi_game;

public class Interface {

    public static void dashBoard() {
        String energy = String.format("%02d", Pet.currentPet.stats.getEnergy());
        String hunger = String.format("%02d", Pet.currentPet.stats.getHunger());
        String thirst = String.format("%02d", Pet.currentPet.stats.getThirst());
        String happiness = String.format("%02d", Pet.currentPet.stats.getHappiness());
        String gender = Pet.currentPet.getGender().name();
        String maturity = Pet.currentPet.getMaturity().name();
        String species = Pet.currentPet.getSpecies().name();

        //TODO: Add the pets dashBoard into large space in the middle as well as gender of pet/ maturity.
        System.out.println("____________________________________________________________________________");
        System.out.println("| Name: " + Pet.currentPet.getName() + "                                                               |");
        System.out.println("|    __________________________________________________________________    |");
        System.out.println("|   |  INTERACT (I) |  FEED (F) |  COMPETE (C) |  SHOP (S) | QUIT (Q)  |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        SpeciesArt.checkStatus(Pet.currentPet);
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|   | ENERGY: " + energy + "  |  HUNGER: " + hunger + "  |  THIRST: " + thirst + "  |  HAPPINESS: " + happiness + "       |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|   |    " + gender + "   |    " + maturity + "      |     " + species + "      |                      |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|__________________________________________________________________________|");
    }

    public static void menuInteract() {
        System.out.println("____________________________________________________________________________");
        System.out.println("|    __________________________________________________________________    |");
        System.out.println("|   |       PAT (1) | BREED (2) | SELECT PET (3) | SELL PET (4)        |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|__________________________________________________________________________|");
    }

    public static void menuFeed() {
        System.out.println("____________________________________________________________________________");
        System.out.println("|    __________________________________________________________________    |");
        System.out.println("|   | SINGLE USE:      FOOD (1) | WATER (2) | BOTH (3)                 |   |");
        System.out.println("|   | FILL ATTRIBUTE:  FOOD (4) | WATER (5) | BOTH (6)                 |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|__________________________________________________________________________|");
    }

    public static void menuCompetition() {
        //TODO: add a print or something to indicate competitions progress, finish and/ or start.
    }

    public static void menuShop() {
        String pC = String.format("%05d", Player.player.getCurrency());
        String fA = String.format("%02d", Player.player.getFoodAmount());
        String wA = String.format("%02d", Player.player.getWaterAmount());

        System.out.println("____________________________________________________________________________");
        System.out.println("|    __________________________________________________________________    |");
        System.out.println("|   |    PLAYER CURRENCY: " + pC + " | FOOD AMOUNT: " + fA + " | WATER AMOUNT: " + wA + "   |   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   | PURCHACE FOOD x01  | (1)                                COST:" + Shop.shop.getFOOD_COST() + "|   |");
        System.out.println("|   | FILL FOOD x" + (99 - Integer.parseInt(fA)) + "      | (2)                                COST: " + ((99 - Integer.parseInt(wA)) * Shop.shop.getFOOD_COST()) + " |   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   | PURCHACE WATER x01 | (3)                                COST:" + Shop.shop.getWATER_COST() + "|   |");
        System.out.println("|   | FILL WATER x" + (99 - Integer.parseInt(wA)) + "     | (4)                                COST: " + ((99 - Integer.parseInt(wA)) * Shop.shop.getWATER_COST()) + " |   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   | PURCHACE PET (RANDOM STATS) x 1 (5)                              |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|__________________________________________________________________________|");
    }
}
