package tamagotchi_game;

import java.util.Random;

/**
 * This class stores information about the species of a pet
 * @author idkxy
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
