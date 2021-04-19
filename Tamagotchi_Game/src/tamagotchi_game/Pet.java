package tamagotchi_game;

import java.*;
import java.time.LocalDateTime;
import sun.util.calendar.BaseCalendar.Date;

public class Pet{

    public static Pet currentPet = new Pet("", 0, 0, 0, 0);
    private Species s;
    private int value;
    private String name;
    Stats stats;
    private LocalDateTime created;
    private MaturityLevel maturity = MaturityLevel.BABY;
    
    
    
   
    public Pet(String name, int hunger, int thirst, int happiness, int energy){
        this.name = name;
        stats = new Stats(hunger, thirst, happiness, energy);
        created = LocalDateTime.now();
        
    }

    public static void setCurrentPet(Pet temp) {
        currentPet.name = temp.name;
        currentPet.stats.setEnergy(temp.stats.getEnergy());
        currentPet.stats.setHappiness(temp.stats.getHappiness());
        currentPet.stats.setHunger(temp.stats.getHunger());
        currentPet.stats.setThirst(temp.stats.getThirst());
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the s
     */
    public Species getS() {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setS(Species s) {
        this.s = s;
    }
    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }
    
    /**
     * @return the maturity
     */
    public MaturityLevel isMaturity() {
        return maturity;
    }

    /**
     * @param maturity the maturity to set
     */
    public void setMaturity(MaturityLevel maturity) {
        this.maturity = maturity;
    }

    /**
     * @return the created
     */
    public LocalDateTime getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(LocalDateTime created) {
        created = LocalDateTime.now();
        this.created = created;
    }
    


    //this gotta be fixed perhaps, could probably just use tthe getters for info if we need it
    @Override
    public String toString() {
        return ("Name: " + currentPet.getName() + "\nEnergy: " + currentPet.stats.getEnergy() + "\nHunger: " +
                currentPet.stats.getHunger() + "\nThirst: " + currentPet.stats.getThirst());
    }

}
