package tamagotchi_game;

import java.util.Random;
/**
 * Gender class contains the gender of he pet and a method that randomly generates 
 * the gender
 * @author DaisyXiao - 1392836
 */
public enum Gender {
    MALE,
    FEMALE;

    /**
     * @return an integer representing the gender that's randomly generated
     * 0 represents MALE, 1 represents FEMALE
     */
    final static Gender randomGender() {
        Gender[] gender = Gender.values();
        Random random = new Random();
        return gender[random.nextInt(gender.length)];
    }
}
