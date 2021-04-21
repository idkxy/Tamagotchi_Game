package tamagotchi_game;

import java.time.LocalDateTime;

public class Pet {

    public static Pet currentPet = new Pet("", 0, 0, 0, 0);
    private Species species;
    private int value;
    private String name;
    Stats stats;
    private LocalDateTime created;
    private Maturity maturity = Maturity.BABY;
    private Gender gender;
    private long LastpatTime = 0;

    public Pet(String name, int hunger, int thirst, int happiness, int energy) {
        this.name = name;
        stats = new Stats(hunger, thirst, happiness, energy);
        created = LocalDateTime.now();
        species = Species.randomSpecies();
        gender = Gender.randomGender();
        maturity = Maturity.randomMaturity();
    }

    public static void setCurrentPet(Pet temp) {
        currentPet.name = temp.name;
        currentPet.stats.setEnergy(temp.stats.getEnergy());
        currentPet.stats.setHappiness(temp.stats.getHappiness());
        currentPet.stats.setHunger(temp.stats.getHunger());
        currentPet.stats.setThirst(temp.stats.getThirst());
        currentPet.setSpecies(temp.species);
        currentPet.setGender(temp.gender);
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
    public Species getSpecies() {
        return species;
    }

    /**
     * @param species the s to set
     */
    public void setSpecies(Species species) {
        this.species = species;
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
    public Maturity isMaturity() {
        return getMaturity();
    }

    /**
     * @param maturity the maturity to set
     */
    public void setMaturity(Maturity maturity) {
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
        return ("Name: " + currentPet.getName() + "Energy: " + currentPet.stats.getEnergy() + "Hunger: "
                + currentPet.stats.getHunger() + "Thirst: " + currentPet.stats.getThirst() + "Happiness: " + currentPet.stats.getHappiness()
                + "Price: " + currentPet.getValue());
    }

    /**
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * @return the maturity
     */
    public Maturity getMaturity() {
        return maturity;
    }

    /**
     * @return the lastpatTime
     */
    public long getLastpatTime() {
        return LastpatTime;
    }

    /**
     * @param lastpatTime the lastpatTime to set
     */
    public void setLastpatTime(long lastpatTime) {
        this.LastpatTime = lastpatTime;
    }
    
    public void computeValue(Pet p)
    {
        p.setValue(100 + p.stats.getEnergy() * 5);
        
    }

}
