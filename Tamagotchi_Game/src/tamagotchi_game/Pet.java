package tamagotchi_game;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * This class contains the details of the pet owned by the user
 * @author DaisyXiao - 1392836
 */
public class Pet {

    public static HashMap<Integer, Pet> petCollection = new HashMap<Integer, Pet>();
    private Species species;
    private int value;
    private String name;
    Stats stats;
    private LocalDateTime created = LocalDateTime.of(1, 1, 1, 1, 1);
    private Maturity maturity = Maturity.BABY;
    private Gender gender;
    private LocalDateTime LastpatTime = LocalDateTime.of(1, 1, 1, 1, 1);
    private Competition competition;
    private static int index = 0;

    
    public Pet(String name, int hunger, int thirst, int happiness, int energy) {
        this.name = name;
        stats = new Stats(hunger, thirst, happiness, energy);
        created = LocalDateTime.now();
        species = Species.randomSpecies();
        gender = Gender.randomGender();
        maturity = Maturity.randomMaturity();
        //This sets the details of the games that the pet has entered
        Competition.c.setCptEntered(Competition.c.getCptEntered());
        Competition.c.setWinCount(Competition.c.getWinCount());
        Competition.c.setLoseCount(Competition.c.getLoseCount());
        Competition.c.setDrawCount(Competition.c.getDrawCount());
        setCompetition(Competition.c);
    }

    /**
     * This method will randomly generate a pet that has random stats but the name of which will be among the names
     * @return a randomly generated pet
     */
    public static Pet PetGenerator() {
        String[] namesCompetition = {"Lolly", "Hopper", "Dove", "April", "Bishop", "Jack", "Jett", "Mittens",};
        Random rand = new Random();
        Pet p = new Pet(namesCompetition[rand.nextInt(namesCompetition.length)], rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
        p.setSpecies(Species.randomSpecies());
        p.setGender(Gender.randomGender());
        p.setMaturity(Maturity.randomMaturity());
        return p;
    }

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
        this.created = created;
    }

    @Override
    public String toString() {
        return (" " + String.format("%-33s", String.format("%-9s", getName()) + "  " + String.format("%-5s", getSpecies()) + "     " + String.format("%-5s", getGender()) + (getGender() == Gender.MALE ? "        " : "       ") + String.format("%-7s", getMaturity())) + "      "
                + stats.getHunger() + "        " + stats.getThirst() + "        " + stats.getEnergy() + "      " + "$" + getValue());
    }

    public String printPetDetails() {
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

    public void computeValue(Pet p) {
        p.setValue(100 + (p.stats.getEnergy() * 5));

    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int aIndex) {
        index = aIndex;
    }
}
