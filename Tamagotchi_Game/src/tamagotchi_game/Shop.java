package tamagotchi_game;

import java.util.ArrayList;
import java.util.*;
public class Shop {

    /**
     * @return the pets
     */
   
    
    public static Shop shop = new Shop();
     
    private static final ArrayList<Pet> pets = new ArrayList<Pet>();
    String[] namesShop = {"Mocha","Lucky","Ginko","Dolby","Levi"};
   
    private final int WATER_COST = 10;
    private final int FOOD_COST = 18;
    
     public ArrayList<Pet> getPets() {
        return pets;
    }
     
    public void nameCheck()
    {
        Pet[] pCheck = new Pet[5];
        for(int i = 0; i < pCheck.length; ++i)
        {
            pCheck[i] = pets.get(i);
        }
        int index = 0;
        
        if(pCheck[index + 1].getName().equals(pets.get(index).getName()))
        {
            pets.remove(index);
            pets.add((pets.size() - index),Pet.PetGenerator());
            pets.get(index).computeValue(pets.get(index));
            index ++;
        }
        
        
    }
    
    public void PetInShop()
    {
        for (int i = 0; i < 5; i++) {
           
            pets.add(Pet.PetGenerator());
            pets.get(i).computeValue(pets.get(i));
        }
        
    }
    
    public void PrintAvailablePets()
    {
        System.out.println("  |  Name  |  Species |  Gender  |  Maturity  | Hunger | Thirst | Energy | Price |");
        for(int i = 0; i < getPets().size();++i)
        {
            System.out.println((i+1) + ". " + pets.get(i));
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
    
    

