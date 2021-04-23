package tamagotchi_game;

/**
 * This class stores the details of the stats of a pet and corresponding getters
 * and setters for retrieving and setting the value of the stats of the pet
 * 
 * @author DaisyXiao - 1392836
 * @author Liam Yates - 18016696
 * @author Liam Rimmer - 18040246
 */
class Stats {

    private int hunger, thirst, happiness, energy;
    public static final int MAX_HUNGER = 10, MAX_THIRST = 10, MAX_HAPPINESS = 10, MAX_ENERGY = 10;

    /**
     * This is the constructor of the Stats class, the value of the stats will
     * be assigned to the pet according to the parameters
     *
     * @param hunger represents the hunger value to be assigned to the pet
     * @param thirst represents the thirst value to be assigned to the pet
     * @param happiness represents the happiness value to be assigned to the pet
     * @param energy represents the energy value to be assigned to the pet
     */
    public Stats(int hunger, int thirst, int happiness, int energy) {
        this.hunger = hunger;
        this.thirst = thirst;
        this.happiness = happiness;
        this.energy = energy;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

}
