package tamagotchi_game;

import java.util.Scanner;

/**
 * This class contains all the details of the pet's competition with a method that checks if 
 * the pet is eligible to enter the game
 * @author DaisyXiao - 1392836
 */
public class Competition {

    
    public static Competition c = new Competition();
    private static int total = 0;
    private static Pet opponent;
    private static int winCount = 0;
    private static int loseCount = 0;
    private static int drawCount = 0;

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        Competition.winCount = winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public void setLoseCount(int loseCount) {
        Competition.loseCount = loseCount;
    }

    public int getCptEntered() {
        return total;
    }

    public void setCptEntered(int cptEntered) {
        Competition.total = cptEntered;
    }

    public Pet getOpponent() {
        return opponent;
    }

    public void setOpponent(Pet opponent) {
        Competition.opponent = opponent;
    }

    /**
     * Ask if the user wants to enter the competition and print corresponding information
     * when y/n is pressed 
     * @throws InterruptedException
     */
    public void confirmation() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        String confirm = "";
        confirm = InputValidation.regexValidate(scan, "yn");

        if (confirm.equalsIgnoreCase("Y")) {
            entryCheck();
            computeResult();
            System.out.println(Pet.petCollection.get(Pet.getIndex()).getCompetition());
            System.out.println("");
        } 
            

    }

    /**
     * This method checks if the pet is eligible to enter a competition
     * @throws InterruptedException
     */
public void entryCheck() throws InterruptedException {
        //check if the player has sufficient fund and all the pet's stats are greater than 1
        if (Player.player.getCurrency() <= 0) {
                    System.out.println("Insufficient fund! Can not enter competition");
                   
                }
        else
        {
            if (Player.player.getCurrency() > 0 && Pet.petCollection.get(Pet.getIndex()).stats.getEnergy() > 0 && Pet.petCollection.get(Pet.getIndex()).stats.getHappiness() > 0 && Pet.petCollection.get(Pet.getIndex()).stats.getHunger() > 0 && Pet.petCollection.get(Pet.getIndex()).stats.getThirst() > 0) {
            {
                if ((Pet.petCollection.get(Pet.getIndex()).stats.getEnergy() - 1) > 0 && (Pet.petCollection.get(Pet.getIndex()).stats.getHappiness()) - 1 > 0 && (Pet.petCollection.get(Pet.getIndex()).stats.getHunger()) - 1 > 0 && (Pet.petCollection.get(Pet.getIndex()).stats.getThirst()) - 1 > 0) {
                     Pet.petCollection.get(Pet.getIndex()).stats.setEnergy(Pet.petCollection.get(Pet.getIndex()).stats.getEnergy() - 1); 
                    Pet.petCollection.get(Pet.getIndex()).stats.setHappiness(Pet.petCollection.get(Pet.getIndex()).stats.getHappiness() - 1);
                Pet.petCollection.get(Pet.getIndex()).stats.setHunger(Pet.petCollection.get(Pet.getIndex()).stats.getHunger() - 1);
                Pet.petCollection.get(Pet.getIndex()).stats.setThirst(Pet.petCollection.get(Pet.getIndex()).stats.getThirst() - 1);
                Player.player.setCurrency(Player.player.getCurrency() - 100);
                

        } else if (Pet.petCollection.get(Pet.getIndex()).stats.getEnergy() <= 0 || Pet.petCollection.get(Pet.getIndex()).stats.getHappiness() <= 0 || Pet.petCollection.get(Pet.getIndex()).stats.getHunger() <= 0 || Pet.petCollection.get(Pet.getIndex()).stats.getThirst() <= 0) {
            System.out.println("Required stats level is not met ! Your pet can not enter game!");
        }
        }
        
       
    }
    }}

    /**
     * Compute the result of the competition according to the pet's stats
     * @throws InterruptedException
     */
    public void computeResult() throws InterruptedException {

        System.out.println(Pet.petCollection.get(Pet.getIndex()).getName() + " is now competing against " + opponent.getName() + " ......");
        System.out.println("");
        System.out.println("Details of your pet: " + "\n" + Pet.petCollection.get(Pet.getIndex()).printPetDetails());
        System.out.println("");
        System.out.println("Opponent's Details: " + "\n" + opponent.printPetDetails());
        System.out.println("");
        Pet.petCollection.get(Pet.getIndex()).getCompetition().setCptEntered(Pet.petCollection.get(Pet.getIndex()).getCompetition().getCptEntered()+ 1);
;
        if ((Pet.petCollection.get(Pet.getIndex()).stats.getEnergy() + Pet.petCollection.get(Pet.getIndex()).stats.getHappiness() + Pet.petCollection.get(Pet.getIndex()).stats.getHunger() + Pet.petCollection.get(Pet.getIndex()).stats.getThirst())
                > (opponent.stats.getEnergy() + opponent.stats.getHappiness() + opponent.stats.getHunger() + opponent.stats.getThirst())) {

            System.out.println("Congrats! " + Pet.petCollection.get(Pet.getIndex()).getName() + " wins! :)");
            Pet.petCollection.get(Pet.getIndex()).getCompetition().setWinCount(Pet.petCollection.get(Pet.getIndex()).getCompetition().getWinCount() + 1);
            System.out.println("You've earned $200!");
            System.out.println("");
            Player.player.setCurrency(Player.player.getCurrency() + 200);
        }
        else if ((Pet.petCollection.get(Pet.getIndex()).stats.getEnergy() + Pet.petCollection.get(Pet.getIndex()).stats.getHappiness() + Pet.petCollection.get(Pet.getIndex()).stats.getHunger() + Pet.petCollection.get(Pet.getIndex()).stats.getThirst())
                == (opponent.stats.getEnergy() + opponent.stats.getHappiness() + opponent.stats.getHunger() + opponent.stats.getThirst())) {
            System.out.println("Draw! You get your money back!");
            System.out.println("");
            Player.player.setCurrency(Player.player.getCurrency() + 100);
            Pet.petCollection.get(Pet.getIndex()).getCompetition().setDrawCount(Pet.petCollection.get(Pet.getIndex()).getCompetition().getDrawCount() + 1);
            //amount of currency earned from winning to be confirmed 
        } else {
            Pet.petCollection.get(Pet.getIndex()).getCompetition().setLoseCount(Pet.petCollection.get(Pet.getIndex()).getCompetition().getLoseCount() + 1);
            System.out.println("Too bad " + Pet.petCollection.get(Pet.getIndex()).getName() + " loses! :(");
            System.out.println("You will get $30 back!");
            System.out.println("");
            Player.player.setCurrency(Player.player.getCurrency() + 30);
        }

    }

    public String toString() {
        return (Pet.petCollection.get(Pet.getIndex()).getName() + " has entered " + total + " game(s). " + "Win " + winCount + " time(s)." + " Lost " + loseCount + " time(s)." + "\n");

    }

    /**
     * @return the drawCount
     */
    public int getDrawCount() {
        return drawCount;
    }

    /**
     * @param aDrawCount the drawCount to set
     */
    public void setDrawCount(int aDrawCount) {
        drawCount = aDrawCount;
    }

}
