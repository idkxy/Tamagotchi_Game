package tamagotchi_game;

public class Competition {

    
    private int total;
    private Pet opponent = Pet.PetGenerator();
    private int winCount = 0 ;
    private int loseCount= 0;

    
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
        this.total= cptEntered;
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

    public void entryCheck() throws InterruptedException
    {
        if(Pet.currentPet.stats.getEnergy() == 0)
        {
            System.out.println("No energy left! Your pet can not enter game!");
        }
        else
        {
            computeResult();
            Pet.currentPet.stats.setEnergy(Pet.currentPet.stats.getEnergy()-1);
            Player.player.setCurrency(Player.player.getCurrency() - 100);
            total ++;
            
        }
    }
    
    public void computeResult() throws InterruptedException
    {
        System.out.println(Pet.currentPet.getName() + " is now competing against " + opponent.getName() + " ......");
        Thread.sleep(2000);
        System.out.println("Details of your pet: " + "\n" + Pet.currentPet.printPetDetails());
        System.out.println("");
        System.out.println("Opponent's Details: " + "\n" + opponent.printPetDetails() );
        if (Pet.currentPet.stats.getEnergy() > this.opponent.stats.getEnergy() && Pet.currentPet.stats.getHappiness()> this.opponent.stats.getHappiness() 
                && Pet.currentPet.stats.getHunger()> this.opponent.stats.getHunger() && Pet.currentPet.stats.getThirst()> this.opponent.stats.getThirst())
        {
            this.winCount++;
            System.out.println("Congrats! " + Pet.currentPet.getName() + " wins! :)");
            //amount of currency earned from winning to be confirmed 
        }
        else
        {
            this.loseCount++;
            System.out.println("Too bad " + Pet.currentPet.getName() + " loses! :(");
        }
    }
    
    public String toString()
    {
        return (Pet.currentPet.getName() + " has entered " + this.total+ " games. " + "Win " + this.winCount + " times." + " Lost " + this.loseCount + "times." + "\n");
        
    }
    
    
    
    

}
