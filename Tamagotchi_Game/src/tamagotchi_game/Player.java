package tamagotchi_game;

public class Player{

    public static Player player = new Player(200,0,0);
    private static int currency = 0;

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
        return foodAmount;
    }

    public void setFoodAmount(int currency) {
        this.foodAmount = foodAmount;
    }
    
    public int getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(int currency) {
        this.waterAmount = waterAmount;
    }
}
