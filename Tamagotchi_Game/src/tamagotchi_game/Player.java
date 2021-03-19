package tamagotchi_game;

public class Player {

    private int currency = 0;

    public Player(int currency) {
        this.currency = currency;

    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }
}
