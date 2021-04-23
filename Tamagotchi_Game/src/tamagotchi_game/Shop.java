package tamagotchi_game;

import java.util.ArrayList;

public class Shop {

    /**
     * @return the pets
     */
    public ArrayList<Pet> getPets() {
        return pets;
    }

    public static Shop shop = new Shop();

    private ArrayList<Pet> pets = new ArrayList<Pet>();
    String[] namesShop = {"Mocha", "Lucky", "Ginko", "Dolby", "Levi"};

    private final int WATER_COST = 10;
    private final int FOOD_COST = 18;

    public void PetInShop() {
        System.out.println("  |  Name  |  Species |  Gender  |  Maturity  | Hunger | Thirst | Energy | Price |");
        for (int i = 0; i < 5; i++) {
            pets.add(Pet.PetGenerator());
            pets.get(i).computeValue(pets.get(i));
            System.out.println((i + 1) + ". " + pets.get(i));
        
        }
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
