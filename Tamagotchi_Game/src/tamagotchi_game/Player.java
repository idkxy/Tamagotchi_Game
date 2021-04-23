package tamagotchi_game;

/**
 * This class contains the details of the player: currency, water and food
 * amount
 * 
 * @author DaisyXiao - 1392836
 * @author Liam Yates - 18016696
 * @author Liam Rimmer - 18040246
 */
public class Player {

    public static Player player = new Player();
    private int currency;

    private int foodAmount = 0;
    private int waterAmount = 0;

    public Player() {
        this.currency = 200;
        this.foodAmount = 5;
        this.waterAmount = 5;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(int waterAmount) {
        this.waterAmount = waterAmount;
    }
}
