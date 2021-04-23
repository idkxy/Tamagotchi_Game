package tamagotchi_game;

import java.util.Random;

/**
 * This class stores the maturity status of a pet with a maturity generator
 * 
 * @author DaisyXiao - 1392836
 * @author Liam Yates - 18016696
 * @author Liam Rimmer - 18040246
 */
public enum Maturity {
    BABY,
    ADULT;

    /**
     * This method will return an integer representing the maturity status of
     * the pet 0 represents BABY, 1 represents ADULT
     *
     * @return
     */
    final static Maturity randomMaturity() {
        Maturity[] maturity = Maturity.values();
        Random random = new Random();
        return maturity[random.nextInt(maturity.length)];
    }
}
