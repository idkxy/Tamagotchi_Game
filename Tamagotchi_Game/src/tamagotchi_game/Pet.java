/*TODO:
    - kinda forgot tbh
 */
package tamagotchi_game;

public class Pet{

    public static Pet currentPet = new Pet("", 0, 0, 0, 0);

    private String name;
    Stats stats;
    public static final int MAX_HUNGER = 10, MAX_THIRST = 10, MAX_HAPPINESS = 10, MAX_ENERGY = 10;

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

    //this gotta be fixed perhaps, could probably just use tthe getters for info if we need it
//    @Override
//    public String toString() {
//        return ("" + this.getHunger() + this.getThirst() + this.getEnergy());
//    }

}
