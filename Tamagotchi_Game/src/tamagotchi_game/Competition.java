package tamagotchi_game;

public class Competition {

    /*public static int compete(int hunger, int thirst, int happy){
        //equation for money assuming max reward is 100 currency and base is 10:
        //reward = 10 + ((happy + hunger + thirst + energy) * 3)
        //If the reward is equal to 100, the player is rewarded an additional 30 currency
        //i.e. 100 currency = 100 + 30 currency (130)
        
        int pointsEarned = (happy + hunger + thirst) * 3;
        
        if (pointsEarned == 100){
            pointsEarned = 130;
        }
        
        return 10 + pointsEarned;
    }*/
    private int total;
    private Pet myPet;
    private Pet opponent;
    private int winCount = 0 ;
    private int loseCount= 0;

    
    
    public Competition(Pet petA, Pet petB)
    {
        this.myPet = petA;
        this.opponent = petB;
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
        this.total= cptEntered;
    }

    /**
     * @return the myPet
     */
    public Pet getMyPet() {
        return myPet;
    }

    /**
     * @param myPet the myPet to set
     */
    public void setMyPet(Pet myPet) {
        this.myPet = myPet;
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
        if(myPet.stats.getEnergy() == 0)
        {
            System.out.println("No energy left! Your pet can not enter game!");
        }
        else
        {
            computeResult();
            myPet.stats.setEnergy(myPet.stats.getEnergy()-1);
            Player.player.setCurrency(Player.player.getCurrency() - 100);
            total ++;
            
        }
    }
    
    public void computeResult() throws InterruptedException
    {
        System.out.println(myPet.getName() + " is now competing against " + opponent.getName() + " ......");
        Thread.sleep(2000);
        if (this.myPet.stats.getEnergy() > this.opponent.stats.getEnergy() && this.myPet.stats.getHappiness()> this.opponent.stats.getHappiness() && this.myPet.stats.getHunger()> this.opponent.stats.getHunger() && this.myPet.stats.getThirst()> this.opponent.stats.getThirst())
        {
            this.winCount++;
            System.out.println("Congrats! " + myPet.getName() + " wins! :)");
            //amount of currency earned from winning to be confirmed 
        }
        else
        {
            this.loseCount++;
            System.out.println("Too bad " + opponent.getName() + " wins! :(");
        }
    }
    
    public String toString()
    {
        return (myPet.getName() + " has entered " + this.total+ " games. " + "Win " + this.winCount + " times." + " Lost " + this.loseCount + "times." + "\n" + "Current stats: " + myPet.toString());
        
    }
    
    
    
    

}
