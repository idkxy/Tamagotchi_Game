package tamagotchi_game;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;

/**
 * This class contains the details of the pet owned by the user
 *
 * @author DaisyXiao - 1392836
 * @author Liam Yates - 18016696
 * @author Liam Rimmer - 18040246
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
    private Competition competition = new Competition();
    private static int index = 0;

    public Pet(String name, int hunger, int thirst, int happiness, int energy) {
        this.name = name;
        stats = new Stats(hunger, thirst, happiness, energy);
        created = LocalDateTime.now();
        species = Species.randomSpecies();
        gender = Gender.randomGender();
        maturity = Maturity.randomMaturity();
        //This sets the details of the games that the pet has entered
        
        competition.setCptEntered(competition.getCptEntered());
        competition.setWinCount(competition.getWinCount());
        competition.setLoseCount(competition.getLoseCount());
        competition.setDrawCount(competition.getDrawCount());
        setCompetition(competition);
    }

    /**
     * This method will randomly generate a pet that has random stats but the
     * name of which will be among the names
     *
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

    public String printPetDetails() {
        return "Name: " + getName() + ", Species: " + getSpecies() + ", Gender: " + getGender() + ", Maturity: " + getMaturity() + ", Energy: "
                + stats.getEnergy() + ", Hunger: " + stats.getHunger() + ", Thirst: " + stats.getThirst() + ", Happiness: " + stats.getEnergy();

    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setMaturity(Maturity maturity) {
        this.maturity = maturity;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return (" " + String.format("%-33s", String.format("%-9s", getName()) + "  " + String.format("%-5s", getSpecies()) + "     " + String.format("%-5s", getGender()) + (getGender() == Gender.MALE ? "        " : "       ") + String.format("%-7s", getMaturity())) + "      "
                + stats.getHunger() + "        " + stats.getThirst() + "        " + stats.getEnergy() + "      " + "$" + getValue());
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Maturity getMaturity() {
        return maturity;
    }

    public LocalDateTime getLastpatTime() {
        return LastpatTime;
    }

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
