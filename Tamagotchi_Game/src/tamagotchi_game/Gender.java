package tamagotchi_game;

import java.util.Random;

public enum Gender {
    M,
    F;
    
    final static Gender randomGender()
    {
        Gender[] gender = Gender.values();
        Random random = new Random();
        return gender[random.nextInt(gender.length)];
    }
}
