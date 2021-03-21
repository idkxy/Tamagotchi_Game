package tamagotchi_game;

public class MenuLook {
    public static void look(int EN, int HU, int TH, int HA){
        String en = String.format("%02d", EN);
        String hu = String.format("%02d", HU);
        String th = String.format("%02d", TH);
        String ha = String.format("%02d", HA);
        
        //TODO: Add the pets look into large space in the middle as well as gender of pet/ maturity.
        
        System.out.println("____________________________________________________________________________");
        System.out.println("|    __________________________________________________________________    |");
        System.out.println("|   |      INTERACT (I)  |  FEED (F)  |  COMPETE (C)  |  SHOP (S)      |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|   | ENERGY: " + en + "  |  HUNGER: " + hu + "  |  THIRST: " + th + "  |  HAPPINESS: " + ha + "       |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|   | GENDER: M  |  MATURITY: PLACEHOLDER (Enum class?)                |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|__________________________________________________________________________|");
    }
    
    public static void selectionI(){
        System.out.println("____________________________________________________________________________");
        System.out.println("|    __________________________________________________________________    |");       
        System.out.println("|   |       PAT (1) | BREED (2) | SELECT PET (3) | SELL PET (4)        |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|__________________________________________________________________________|");
    }
    
    public static void selectionF(){//TODO: Add section to see current food and water stats.
        System.out.println("____________________________________________________________________________");
        System.out.println("|    __________________________________________________________________    |");       
        System.out.println("|   | SINGLE USE:      FOOD (1) | WATER (2) | BOTH (3)                 |   |");
        System.out.println("|   | FILL ATTRIBUTE:  FOOD (4) | WATER (5) | BOTH (6)                 |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|__________________________________________________________________________|");
    }
    
    public static void selectionC(){
        //TODO: add a print or something to indicate competitions progress, finish and/ or start.
    }
    
    public static void selectionS(int playerCurrency, int foodAmount, int waterAmount){
        String pC = String.format("%05d", playerCurrency);
        String fA = String.format("%02d", foodAmount);
        String wA = String.format("%02d", waterAmount);
        
        System.out.println("____________________________________________________________________________");
        System.out.println("|    __________________________________________________________________    |");
        System.out.println("|   |    PLAYER CURRENCY: " + pC + " | FOOD AMOUNT: " + fA + " | WATER AMOUNT: " + wA + "   |   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   | PURCHACE FOOD x01  | (1)                                COST: 01 |   |");
        System.out.println("|   | FILL FOOD x" + (99 - Integer.parseInt(fA)) + "      | (2)                                COST: " + (99 - Integer.parseInt(wA)) + " |   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   | PURCHACE WATER x01 | (3)                                COST: 01 |   |");
        System.out.println("|   | FILL WATER x" + (99 - Integer.parseInt(wA)) + "     | (4)                                COST: " + (99 - Integer.parseInt(wA)) + " |   |");
        System.out.println("|   |                                                                  |   |");
        System.out.println("|   | PURCHACE PET (RANDOM STATS) x01 (5)                     cost: 99 |   |");
        System.out.println("|   |__________________________________________________________________|   |");
        System.out.println("|__________________________________________________________________________|");
    }
}
