package tamagotchi_game;

import java.util.ArrayList;
import java.util.*;
public class Shop {
    
    public Shop()
    {
        
    }
    ArrayList<Pet> pets = new ArrayList<Pet>();
    String[] names = {"Mocha","Lucky","Ginko","Dolby","Levi"};
    Random rand = new Random();
    private Player p;
    
    public void generatePet()
    {
        for (int i = 0; i < 6; i++) {
            pets.add(new Pet(names[i], rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)));
            pets.get(i).setSpecies(Species.randomSpecies());
            pets.get(i).setGender(Gender.randomGender());
            pets.get(i).setMaturity(Maturity.randomMaturity());
            pets.get(i).computeValue(pets.get(i));
        }
    }
    
    public void availablePets(ArrayList<Pet> availablePets)
    {
        for(int i = 0; i < pets.size();++i)
        {
            System.out.println(pets.get(i).toString());
        }
    }
    
}
