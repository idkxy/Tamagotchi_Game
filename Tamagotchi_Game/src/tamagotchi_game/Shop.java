package tamagotchi_game;

import java.util.ArrayList;

/**
 * This class stores the pet to be displayed in the shop 
 * @author DaisyXiao -1392836
 */
public class Shop {
    
    public static Shop shop = new Shop();

    private ArrayList<Pet> pets = new ArrayList<Pet>();
    String[] namesShop = {"Mocha", "Lucky", "Ginko", "Dolby", "Levi"};

    private final int WATER_COST = 10;
    private final int FOOD_COST = 18;

    // This method will randomly generate 5 pets and compute the value according to the stats of the
    // pet generated and print out the pets that are generated 
    public void PetInShop() {
        System.out.println("  |  Name  |  Species |  Gender  |  Maturity  | Hunger | Thirst | Energy | Price |");
        for (int i = 0; i < 5; i++) {
            pets.add(Pet.PetGenerator());
            pets.get(i).computeValue(pets.get(i));
            System.out.println((i + 1) + ". " + pets.get(i));
        
        }
    }

    /**
     * @return the pets
     */
    public ArrayList<Pet> getPets() {
        return pets;
    }
    /**
     * @return the WATER_COST
     */
    public int getWATER_COST() {
        return WATER_COST;
    }

    /**
     * @return the FOOD_COST
     */
    public int getFOOD_COST() {
        return FOOD_COST;
    }

}
