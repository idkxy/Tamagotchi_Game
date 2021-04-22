<<<<<<< Updated upstream
package tamagotchi_game;

import java.time.LocalDateTime;
import java.util.Random;

public class Pet {

    /**
     * @return the competition
     */
    public Competition getCompetition() {
        return competition;
    }

    /**
     * @param competition the competition to set
     */
    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    
    
    public static Pet currentPet = new Pet("", 0, 0, 0, 0);
    private Species species;
    private int value;
    private String name;
    Stats stats;
    private LocalDateTime created;
    private Maturity maturity = Maturity.BABY;
    private Gender gender;
    private LocalDateTime LastpatTime = LocalDateTime.of(1, 1, 1, 1, 1);
    private Competition competition;
   

    public Pet(String name, int hunger, int thirst, int happiness, int energy) {
        this.name = name;
        stats = new Stats(hunger, thirst, happiness, energy);
        created = LocalDateTime.now();
        species = Species.randomSpecies();
        gender = Gender.randomGender();
        maturity = Maturity.randomMaturity();
        Competition.c.setCptEntered(0);
        Competition.c.setWinCount(0);
        Competition.c.setLoseCount(0);
        setCompetition(Competition.c);
    }

    public static void setCurrentPet(Pet temp) {
        currentPet.name = temp.name;
        currentPet.stats.setEnergy(temp.stats.getEnergy());
        currentPet.stats.setHappiness(temp.stats.getHappiness());
        currentPet.stats.setHunger(temp.stats.getHunger());
        currentPet.stats.setThirst(temp.stats.getThirst());
        currentPet.setSpecies(temp.species);
        currentPet.setGender(temp.gender);
        currentPet.setMaturity(temp.maturity);
        currentPet.setCompetition(Competition.c);
        currentPet.competition.setCptEntered(temp.competition.getCptEntered());
        currentPet.competition.setWinCount(temp.competition.getWinCount());
        currentPet.competition.setLoseCount(temp.competition.getLoseCount());
    }

    public static Pet PetGenerator()
    {
        String[] namesCompetition = {"Lolly","Hopper","Dove","April","Bishop","Jack","Jett","Mittens",};
        Random rand = new Random();
        Pet p = new Pet(namesCompetition[rand.nextInt(namesCompetition.length)],rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10));
        p.setSpecies(Species.randomSpecies());
        p.setGender(Gender.randomGender());
        p.setMaturity(Maturity.randomMaturity());
        
        return p;
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
        this.created = LocalDateTime.now();
    }

    //this gotta be fixed perhaps, could probably just use tthe getters for info if we need it
    @Override
    public String toString() {
        return (" " + String.format( "%-33s", String.format("%-7s",getName()) +  "    "+ String.format("%-5s",getSpecies()) + "    " + String.format("%-5s",getGender()) + (getGender()== Gender.MALE? "        " : "       " ) + String.format("%-7s",getMaturity())) + "       " 
                + stats.getHunger() + "        " + stats.getThirst()  + "        " +stats.getEnergy() + "      " +  "$" + getValue());
    }
    
    public String printPetDetails()
    {
        return "Name: " + getName() + ", Species: " + getSpecies() + ", Gender: " + getGender() + ", Maturity: " + getMaturity() + ", Energy: "
                + stats.getEnergy() + ", Hunger: " + stats.getHunger() + ", Thirst: " + stats.getThirst() + ", Happiness: " + stats.getEnergy();
                
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
    public LocalDateTime getLastpatTime() {
        return LastpatTime;
    }

    /**
     * @param lastpatTime the lastpatTime to set
     */
    public void setLastpatTime(LocalDateTime lastpatTime) {
        this.LastpatTime = lastpatTime;
    }
    
    public void computeValue(Pet p)
    {
        p.setValue(100 + (p.stats.getEnergy() * 5));
        
    }

}
=======
package tamagotchi_game;

import java.util.Date;

public class Pet{

    public static Pet currentPet = new Pet("", 0, 0, 0, 0);
    private Species s;
    private int value;
    private String name;
    Stats stats;
    private Date created;
    private boolean maturity;
    
    
   
    public Pet(String name, int hunger, int thirst, int happiness, int energy ){
        this.name = name;
        stats = new Stats(hunger, thirst, happiness, energy);
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
    public boolean isMaturity() {
        return maturity;
    }

    /**
     * @param maturity the maturity to set
     */
    public void setMaturity(boolean maturity) {
        this.maturity = maturity;
    }

    /**
     * @return the created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    //this gotta be fixed perhaps, could probably just use tthe getters for info if we need it
    @Override
    public String toString() {
        return ("Name: " + currentPet.getName() + "\nEnergy: " + currentPet.stats.getEnergy() + "\nHunger: " +
                currentPet.stats.getHunger() + "\nThirst: " + currentPet.stats.getThirst());
    }

}
>>>>>>> Stashed changes
