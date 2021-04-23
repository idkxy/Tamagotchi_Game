package tamagotchi_game;

import java.util.Random;

public enum Maturity {
    BABY,
    ADULT;

    final static Maturity randomMaturity() {
        Maturity[] maturity = Maturity.values();
        Random random = new Random();
        return maturity[random.nextInt(maturity.length)];
    }
}
