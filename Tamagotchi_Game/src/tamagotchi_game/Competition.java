package tamagotchi_game;

import java.util.Scanner;

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

    public void confirmation() throws InterruptedException
    {
        Scanner scan = new Scanner(System.in);
        String confirm = "";
        confirm = InputValidation.regexValidate(scan, "YynN");
        
        if(confirm.equalsIgnoreCase("Y"))
        {
            entryCheck();
            computeResult();
            System.out.println(this.toString());
            System.out.println("");
            System.out.println("Going back to the previous menu....");
            Thread.sleep(2000);
        }
        else
        {
            System.out.println("Going back to the previous menu....");
            Thread.sleep(2000);
        }
        
    }
    public void entryCheck() throws InterruptedException {
        
        if(Player.player.getCurrency() > 0 && Pet.currentPet.stats.getEnergy() > 0 )
        {
            total ++;
            Pet.currentPet.stats.setEnergy(Pet.currentPet.stats.getEnergy() - 1);
            Pet.currentPet.stats.setHappiness(Pet.currentPet.stats.getHappiness() - 1);
            Pet.currentPet.stats.setHunger(Pet.currentPet.stats.getHunger() - 1);
            Pet.currentPet.stats.setThirst(Pet.currentPet.stats.getThirst() - 1);
            Player.player.setCurrency(Player.player.getCurrency() - 100);
           
        }
        else if(Player.player.getCurrency() <= 0)
        {
            System.out.println("Insufficient fund! Can not enter competition");
        }
        else if (Pet.currentPet.stats.getEnergy() <= 0) {
            System.out.println("No energy left! Your pet can not enter game!");
        } 
    }

    public void computeResult() throws InterruptedException {
        System.out.println(Pet.currentPet.getName() + " is now competing against " + opponent.getName() + " ......");
        System.out.println("");
        Thread.sleep(1000);
        System.out.println("Details of your pet: " + "\n" + Pet.currentPet.printPetDetails());
        System.out.println("");
        System.out.println("Opponent's Details: " + "\n" + opponent.printPetDetails());
        System.out.println("");
        if ((Pet.currentPet.stats.getEnergy() + Pet.currentPet.stats.getHappiness() + Pet.currentPet.stats.getHunger() + Pet.currentPet.stats.getThirst())
            > (opponent.stats.getEnergy() + opponent.stats.getHappiness() + opponent.stats.getHunger() +opponent.stats.getThirst()))
           {
            winCount ++;
            System.out.println("Congrats! " + Pet.currentPet.getName() + " wins! :)");
            System.out.println("You've earned $200!");
            System.out.println("");
            Player.player.setCurrency(Player.player.getCurrency() + 200);
            
        } 
        else if ((Pet.currentPet.stats.getEnergy() + Pet.currentPet.stats.getHappiness() + Pet.currentPet.stats.getHunger() + Pet.currentPet.stats.getThirst())
            == (opponent.stats.getEnergy() + opponent.stats.getHappiness() + opponent.stats.getHunger() +opponent.stats.getThirst()))
           {
            total ++;
            System.out.println("Draw! You get your money back!");
            System.out.println("");
            Player.player.setCurrency(Player.player.getCurrency() + 100);
            
        } 
        else {
            loseCount++;
            System.out.println("Too bad " + Pet.currentPet.getName() + " loses! :(");
            System.out.println("You will get $30 back!");
            System.out.println("");
            Player.player.setCurrency(Player.player.getCurrency() + 10);
        }
    }

    public String toString() {
        return (Pet.currentPet.getName() + " has entered " + this.total + " game(s). " + "Win " + this.getWinCount() + " time(s)." + " Lost " + this.getLoseCount() + " time(s)." + "\n");

    }

}
