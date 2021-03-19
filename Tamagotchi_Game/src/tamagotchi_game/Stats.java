package tamagotchi_game;

class Stats {

    private int hunger, thirst, happiness, energy;
    
    public Stats(int hunger, int thirst, int happiness, int energy)
    {
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
