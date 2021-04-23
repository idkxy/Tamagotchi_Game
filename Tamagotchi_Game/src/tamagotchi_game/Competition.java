package tamagotchi_game;

import java.util.Scanner;

public class Competition {

    public static Competition c = new Competition();
    private static int total = 0;
    private static Pet opponent;
    private static int winCount = 0;
    private static int loseCount = 0;

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
     *
     * @throws InterruptedException
     */
    public void confirmation() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        String confirm = "";
        confirm = InputValidation.regexValidate(scan, "yn");

        if (confirm.equalsIgnoreCase("Y")) {
            entryCheck();
            computeResult();
            System.out.println(Pet.currentPet.getCompetition());
            System.out.println("");
            System.out.println("Going back to the previous menu....");
            Thread.sleep(2000);
        } else {
            System.out.println("Going back to the previous menu....");
            Thread.sleep(2000);
        }

    }

    /**
     *
     * @throws InterruptedException
     */
    public void entryCheck() throws InterruptedException {

        if (Player.player.getCurrency() > 0 && Pet.currentPet.stats.getEnergy() > 0 && Pet.currentPet.stats.getHappiness() > 0 && Pet.currentPet.stats.getHunger() > 0 && Pet.currentPet.stats.getThirst() > 0) {
            Pet.currentPet.stats.setEnergy(Pet.currentPet.stats.getEnergy() - 1);
            Pet.currentPet.stats.setHappiness(Pet.currentPet.stats.getHappiness() - 1);
            Pet.currentPet.stats.setHunger(Pet.currentPet.stats.getHunger() - 1);
            Pet.currentPet.stats.setThirst(Pet.currentPet.stats.getThirst() - 1);
            Player.player.setCurrency(Player.player.getCurrency() - 100);
            total++;
        } else if (Player.player.getCurrency() <= 0) {
            System.out.println("Insufficient fund! Can not enter competition");
        } else if (Pet.currentPet.stats.getEnergy() <= 0) {
            System.out.println("No energy left! Your pet can not enter game!");
        }
    }

    /**
     *
     * @throws InterruptedException
     */
    public void computeResult() throws InterruptedException {

        System.out.println(Pet.currentPet.getName() + " is now competing against " + opponent.getName() + " ......");
        System.out.println("");
        System.out.println("Details of your pet: " + "\n" + Pet.currentPet.printPetDetails());
        System.out.println("");
        System.out.println("Opponent's Details: " + "\n" + opponent.printPetDetails());
        System.out.println("");

        if ((Pet.currentPet.stats.getEnergy() + Pet.currentPet.stats.getHappiness() + Pet.currentPet.stats.getHunger() + Pet.currentPet.stats.getThirst())
                > (opponent.stats.getEnergy() + opponent.stats.getHappiness() + opponent.stats.getHunger() + opponent.stats.getThirst())) {

            System.out.println("Congrats! " + Pet.currentPet.getName() + " wins! :)");
            winCount++;
            System.out.println("You've earned $200!");
            System.out.println("");
            Player.player.setCurrency(Player.player.getCurrency() + 200);
        } else if ((Pet.currentPet.stats.getEnergy() + Pet.currentPet.stats.getHappiness() + Pet.currentPet.stats.getHunger() + Pet.currentPet.stats.getThirst())
                == (opponent.stats.getEnergy() + opponent.stats.getHappiness() + opponent.stats.getHunger() + opponent.stats.getThirst())) {
            System.out.println("Draw! You get your money back!");
            System.out.println("");
            //amount of currency earned from winning to be confirmed 
        } else {

            loseCount++;
            System.out.println("Too bad " + Pet.currentPet.getName() + " loses! :(");
            System.out.println("You will get $30 back!");
            System.out.println("");
            Player.player.setCurrency(Player.player.getCurrency() + 10);
        }

    }

    public String toString() {
        return (Pet.currentPet.getName() + " has entered " + total + " game(s). " + "Win " + winCount + " time(s)." + " Lost " + loseCount + " time(s)." + "\n");

    }

}
