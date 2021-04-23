package tamagotchi_game;

import java.util.Random;

/**
 * This class stores information about the species of a pet
 * 
 * @author DaisyXiao - 1392836
 * @author Liam Yates - 18016696
 * @author Liam Rimmer - 18040246
 */
public enum Species {
    BEAR,
    SHARK,
    MOUSE;

    /**
     *
     * @return a randomly generated species that's among BEAR, SHARK, MOUSE
     */
    final static Species randomSpecies() {
        Species[] species = Species.values();
        Random random = new Random();
        return species[random.nextInt(species.length)];
    }
}
