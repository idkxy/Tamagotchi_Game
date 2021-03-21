package tamagotchi_game;

public class Player {

    private int currency = 0;
    private int foodAmount = 0;
    private int waterAmount = 0;
    
    public Player(int currency, int foodAmount, int waterAmount) {
        this.currency = currency;
        this.foodAmount = foodAmount;
        this.waterAmount = waterAmount;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }
    
    public int getFoodAmount() {
        return currency;
    }

    public void setFoodAmount(int currency) {
        this.currency = currency;
    }
    
    public int getWaterAmount() {
        return currency;
    }

    public void setWaterAmount(int currency) {
        this.currency = currency;
    }
}
