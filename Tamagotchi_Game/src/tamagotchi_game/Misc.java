package tamagotchi_game;

public class Misc {
    
    //Random number generator based on input min and max values
    public static int RNG(int min, int max)
    {
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
    
    public static void clearConsole()
    {
        System.out.println(new String(new char[100]).replace("\0", "\r\n"));
    }
    
}
