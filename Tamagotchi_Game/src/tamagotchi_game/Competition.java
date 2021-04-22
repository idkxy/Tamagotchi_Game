package tamagotchi_game;

public class Competition {

    public static Competition c = new Competition();
    private  int total;
    private static Pet opponent;
    private  int winCount   ;
    private  int loseCount ;

    /**
     * @return the winCount
     */
    public int getWinCount() {
        return winCount;
    }

    
            
    /**
     * @param winCount the winCount to set
     */
    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    /**
     * @return the loseCount
     */
    public int getLoseCount() {
        return loseCount;
    }

    /**
     * @param loseCount the loseCount to set
     */
    public void setLoseCount(int loseCount) {
        this.loseCount = loseCount;
    }

    /**
     * @return the cptEntered
     */
    public int getCptEntered() {
        return total;
    }

    /**
     * @param cptEntered the cptEntered to set
     */
    public void setCptEntered(int cptEntered) {
        this.total = cptEntered;
    }

    /**
     * @return the opponent
     */
    public Pet getOpponent() {
        return opponent;
    }

    /**
     * @param opponent the opponent to set
     */
    public void setOpponent(Pet opponent) {
        this.opponent = opponent;
    }

    public void entryCheck() throws InterruptedException {
        if (Pet.currentPet.stats.getEnergy() == 0) {
            System.out.println("No energy left! Your pet can not enter game!");
        } else {
            total ++;
            computeResult();
            Pet.currentPet.stats.setEnergy(Pet.currentPet.stats.getEnergy() - 1);
            Player.player.setCurrency(Player.player.getCurrency() - 100);
           

        }
    }

    public void computeResult() throws InterruptedException {
        System.out.println(Pet.currentPet.getName() + " is now competing against " + opponent.getName() + " ......");
        System.out.println("");
        Thread.sleep(2000);
        System.out.println("Details of your pet: " + "\n" + Pet.currentPet.printPetDetails());
        System.out.println("");
        System.out.println("Opponent's Details: " + "\n" + opponent.printPetDetails());
        System.out.println("");
        if (Pet.currentPet.stats.getEnergy() > this.opponent.stats.getEnergy() && Pet.currentPet.stats.getHappiness() > this.opponent.stats.getHappiness()
                && Pet.currentPet.stats.getHunger() > this.opponent.stats.getHunger() && Pet.currentPet.stats.getThirst() > this.opponent.stats.getThirst()) {
            winCount ++;
            System.out.println("Congrats! " + Pet.currentPet.getName() + " wins! :)");
            System.out.println("");
            //amount of currency earned from winning to be confirmed 
        } else {
            loseCount++;
            System.out.println("Too bad " + Pet.currentPet.getName() + " loses! :(");
            System.out.println("");
        }
    }

    public String toString() {
        return (Pet.currentPet.getName() + " has entered " + this.total + " game(s). " + "Win " + this.getWinCount() + " times." + " Lost " + this.getLoseCount() + " times." + "\n");

    }

}
