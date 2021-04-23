package tamagotchi_game;

/**
 * This class stores the ASCII art to be printed according to pet's species
 * and their stats level
 * @author DaisyXiao
 */
public class SpeciesArt {

    static String[] bear = new String[]{
        "|                          (()___(()                               |",
        "|                          /       \\                               |",
        "|                         (  -   -  \\                              |",
        "|                         \\ o  o   /                               |",
        "|                          (_()_)__/ \\                             |",
        "|                         / _,==.____ \\                            |",
        "|                        (   |--|      )                           |",
        "|                        /\\_.|__|'-.__/\\_                          |",
        "|                       / (        /     \\                         |",
        "|                       \\  \\      (      /                         |",
        "|                        )  '._____)    /                          |",
        "|                     (((____.--(((____/                           |"};

    static String[] bearSad = new String[]{
        "|                         ( /   \\   \\                              |",
        "|                          \\ *  *   /                              |",};

    static String[] bearHappy = new String[]{
        "|                         ( ^   ^   \\                              |",
        "|                          \\ >  <   /                              |",};

    static String[] bearOk = new String[]{
        "|                         ( -   -   \\                              |",
        "|                          \\ o  o   /                              |",};

    static String[] mouse = new String[]{
        "|                      .--,       .--,                             |",
        "|                     ( (  \\.---./  ) )                            |",
        "|                      '.__/o   o\\__.'                             |",
        "|                         {=  ^  =}                                |",
        "|                          >  -  <                                 |",
        "|                         /       \\                                |",
        "|                        //       \\\\                               |",
        "|                       //|   .   |\\\\                              |",
        "|                       \"'\\       /'\"_.-~^`'-.                     |",
        "|                          \\  _  /--'                              |",
        "|                        ___)( )(___                               |",
        "|                       (((__) (__)))                              |",};

    static String[] mouseSad = new String[]{
        "|                      '.__/*   *\\__.'                             |",
        "|                         {=  -  =}                                |",};

    static String[] mouseHappy = new String[]{
        "|                      '.__/^   ^\\__.'                             |",
        "|                         {=  o  =}                                |",};

    static String[] mouseOk = new String[]{
        "|                      '.__/o   o\\__.'                             |",
        "|                         {=  ^  =}                                |",};

    static String[] shark = new String[]{
        "|                     _________         .    .                     |",
        "|                    (..       \\_    ,  |\\  /|                     |",
        "|                     \\       -  \\  /|  \\ \\/ /                    |",
        "|                      \\______o   \\/ |   \\  /                      |",
        "|                         vvvv\\    \\ |   /  |                      |",
        "|                         \\^^^^  ==   \\_/   |                      |",
        "|                          `\\_   ===    \\.  |                      |",
        "|                           / /\\_   \\ /     |                      |",
        "|                           |/   \\_  \\|     /                      |",
        "|                           .     \\   .    /                       |",
        "|                                  \\______/                        |",};

    static String[] sharkSad = new String[]{
        "|                     \\       \\  \\  /|  \\ \\/ /                     |",
        "|                      \\______*   \\/ |   \\  /                      |",};

    static String[] sharkHappy = new String[]{
        "|                     \\       -  \\  /|  \\ \\/ /                     |",
        "|                      \\______^   \\/ |   \\  /                      |",};

    static String[] sharkOk = new String[]{
        "|                     \\       -  \\  /|  \\ \\/ /                     |",
        "|                      \\______o   \\/ |   \\  /                      |",};

    
    /**
     * This method will print the correlated ASCII art base on the species 
     * of the pet passed in the parameter 
     * @param p is the pet whose species will be identified when passing through
     * the method and correlated ASCII art will be printed 
     */
    public static void printPet(Pet p) {

        switch (p.getSpecies()) {
            case BEAR:
                bearExpressions(p);
                break;
            case MOUSE:
                mouseExpressions(p);
                break;
            case SHARK:
                sharkExpressions(p);
                break;
        }
    }

    /**
     * This method is used to determine the face to be printed for the bear 
     * according to the happiness level of the bear pet
     * @param p is used to retrieve the happiness level of the bear pet
     */
    private static void bearExpressions(Pet p) {
        if (p.stats.getHappiness() >= 6) {
            bear[2] = bearHappy[0];
            bear[3] = bearHappy[1];
            for (int i = 0; i < bear.length; ++i) {
                System.out.println("|   " + bear[i] + "   |");
            }
        } else if (p.stats.getHappiness() <= 3) {
            bear[2] = bearSad[0];
            bear[3] = bearSad[1];
            for (int i = 0; i < bear.length; ++i) {
                System.out.println("|   " + bear[i] + "   |");
            }
        } else if (p.stats.getHappiness() < 6 && p.stats.getHappiness() > 3) {
            bear[2] = bearOk[0];
            bear[3] = bearOk[1];
            for (int i = 0; i < bear.length; ++i) {
                System.out.println("|   " + bear[i] + "   |");
            }
        }
    }

    /**
     * This method is used to determine the face to be printed for the mouse 
     * according to the happiness level of the bear pet
     * @param p is used to retrieve the happiness level of the mouse pet
     */
    private static void mouseExpressions(Pet p) {
        if (p.stats.getHappiness() >= 6) {
            mouse[2] = mouseHappy[0];
            mouse[3] = mouseHappy[1];
            for (int i = 0; i < mouse.length; ++i) {
                System.out.println("|   " + mouse[i] + "   |");
            }
        } else if (p.stats.getHappiness() <= 3) {
            mouse[2] = mouseSad[0];
            mouse[3] = mouseSad[1];
            for (int i = 0; i < mouse.length; ++i) {
                System.out.println("|   " + mouse[i] + "   |");
            }
        } else if (p.stats.getHappiness() < 6 && p.stats.getHappiness() > 3) {
            mouse[2] = mouseOk[0];
            mouse[3] = mouseOk[1];
            for (int i = 0; i < mouse.length; ++i) {
                System.out.println("|   " + mouse[i] + "   |");
            }
        }
    }

    /**
     * This method is used to determine the face to be printed for the bear 
     * according to the happiness level of the bear pet
     * @param p is used to retrieve the happiness level of the bear pet
     */
    private static void sharkExpressions(Pet p) {
        if (p.stats.getHappiness() >= 6) {
            shark[2] = sharkHappy[0];
            shark[3] = sharkHappy[1];
            for (int i = 0; i < shark.length; ++i) {
                System.out.println("|   " + shark[i] + "   |");
            }
        } else if (p.stats.getHappiness() <= 3) {
            shark[2] = sharkSad[0];
            shark[3] = sharkSad[1];
            for (int i = 0; i < shark.length; ++i) {
                System.out.println("|   " + shark[i] + "   |");
            }
        } else if (p.stats.getHappiness() < 6 && p.stats.getHappiness() > 3) {
            shark[2] = sharkOk[0];
            shark[3] = sharkOk[1];
            for (int i = 0; i < shark.length; ++i) {
                System.out.println("|   " + shark[i] + "   |");
            }
        }
    }
}
