<<<<<<< Updated upstream
package tamagotchi_game;

import java.util.Random;

public enum Species {
    BEAR,
    SHARK,
    MOUSE;

    final static Species randomSpecies() {
        Species[] species = Species.values();
        Random random = new Random();
        return species[random.nextInt(species.length)];
    }
}
=======
package tamagotchi_game;

/**
 *
 * @author daisyxiao
 */
public enum Species {
    S1,
    S2,
    S3;
}
>>>>>>> Stashed changes
