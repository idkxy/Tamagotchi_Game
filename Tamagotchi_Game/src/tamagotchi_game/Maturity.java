package tamagotchi_game;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author daisyxiao
 */
public class Maturity {
    
    private final Pet pet;
    
    
    public Maturity(Pet pet)
    {
        this.pet = pet;
    }
    
    
    
    public void maturityCheck()
    {
        if(Time.getdInDay() >= 3)
        {
            pet.setMaturity(MaturityLevel.ADULT);
                   
        }
     
    }
    
    
}
