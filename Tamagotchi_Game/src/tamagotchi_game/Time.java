package tamagotchi_game;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *  This class will be used to compare the difference between the current time
    and a time specified by the user

 */
   
public class Time {

    private static LocalDateTime currentTime = LocalDateTime.now();

    /**
     * This method will be returning the difference between the local time
     * and the time specified by the user. The result will be shown in minutes
     * @param d1 is the time specified by the user to be compared with the local time
     * @return the difference between the local time and the user specified time
     * in minutes
     */
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
