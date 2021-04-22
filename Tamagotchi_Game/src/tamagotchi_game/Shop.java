package tamagotchi_game;

import java.util.ArrayList;
import java.util.*;
public class Shop {

    /**
     * @return the pets
     */
    public ArrayList<Pet> getPets() {
        return pets;
    }
    
    public static Shop shop = new Shop();
     
    private ArrayList<Pet> pets = new ArrayList<Pet>();
    String[] names = {"Mocha","Lucky","Ginko","Dolby","Levi"};
    Random rand = new Random();
    private final int WATER_COST = 10;
    private final int FOOD_COST = 18;
    
    //TODO: can go out of bounds
    public void generatePet()
    {
        for (int i = 0; i < 5; i++) {

            pets.add(new Pet(names[i], rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)));
            pets.get(i).setSpecies(Species.randomSpecies());
            pets.get(i).setGender(Gender.randomGender());
            pets.get(i).setMaturity(Maturity.randomMaturity());
            pets.get(i).computeValue(pets.get(i));

        }
    }
    
    public void availablePets()
    {
        
        for(int i = 0; i < getPets().size();++i)
        {
            getPets().get(i).computeValue(pets.get(0));
            System.out.println((i +1) + ". " + pets.get(i));
            System.out.println("ok");
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
    
    

