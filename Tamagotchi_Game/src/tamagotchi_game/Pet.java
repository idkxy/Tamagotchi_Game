/*TODO:
    - kinda forgot tbh
 */
package tamagotchi_game;

public class Pet {

    public static Pet currentPet = new Pet("", 0, 0, 0, 0);

    private String name;
    private int hunger, thirst, happiness, energy;
    public static final int MAX_HUNGER = 10, MAX_THIRST = 10, MAX_HAPPINESS = 10, MAX_ENERGY = 10;

    public Pet(String name, int hunger, int thirst, int energy, int happiness) {
        this.name = name;
        this.hunger = hunger;
        this.thirst = thirst;
        this.energy = energy;
        this.happiness = happiness;
    }

    public static void setCurrentPet(Pet temp) {
        currentPet.name = temp.name;
        currentPet.energy = temp.energy;
        currentPet.happiness = temp.happiness;
        currentPet.hunger = temp.hunger;
        currentPet.thirst = temp.thirst;
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
     * @return the hunger
     */
    public int getHunger() {
        return hunger;
    }

    /**
     * @param hunger the hunger to set
     */
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    /**
     * @return the thirst
     */
    public int getThirst() {
        return thirst;
    }

    /**
     * @param thirst the thirst to set
     */
    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    /**
     * @return the happiness
     */
    public int getHappiness() {
        return happiness;
    }

    /**
     * @param happiness the happiness to set
     */
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    /**
     * @return the energy
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * @param energy the energy to set
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    //this gotta be fixed perhaps, could probably just use tthe getters for info if we need it
    @Override
    public String toString() {
        return ("" + this.getHunger() + this.getThirst() + this.getEnergy());
    }

}
