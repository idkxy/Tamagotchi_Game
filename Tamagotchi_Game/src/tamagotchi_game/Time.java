package tamagotchi_game;

import java.time.Duration;
import java.time.LocalDateTime;

public class Time {

    private static LocalDateTime currentTime = LocalDateTime.now();

    public static long getDiff(LocalDateTime d1) {
        return Duration.between(d1, LocalDateTime.now()).toMinutes();
    }

    /**
     * @return the currentTime
     */
    public static LocalDateTime getCurrentTime() {
        return currentTime;
    }

    /**
     * @param aCurrentTime the currentTime to set
     */
    public static void setCurrentTime(LocalDateTime aCurrentTime) {
        currentTime = aCurrentTime;
    }
}
