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

    public static void speciesRec(Pet p) {
        switch (p.getSpecies()) {
            case BEAR:
                BearImage.checkStatus(p);
                break;
            case MOUSE:
                MouseImage.checkStatus(p);
                break;
            case SHARK:
                SharkImage.checkStatus(p);
                break;
            default:
                break;
        }
    }
}
