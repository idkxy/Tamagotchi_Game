/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tamagotchi_game;

/**
 *
 * @author idkxy
 */
public class SharkImage {
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
    "|                      \\______o   \\/ |   \\  /                      |",    };

    static void checkStatus(Pet p) {
        if (p.stats.getHappiness() > 6) {
            shark[2] = sharkHappy[0];
            shark[3] = sharkHappy[1];
            for (int i = 0; i < shark.length; ++i) {
                System.out.println("|   " +shark[i] + "   |");
            }
        } else if (p.stats.getHappiness() < 3) {
            shark[2] = sharkSad[0];
            shark[3] = sharkSad[1];
            for (int i = 0; i < shark.length; ++i) {
                System.out.println("|   " +shark[i] + "   |");
            }
        } else if (p.stats.getHappiness() < 6 && p.stats.getHappiness() > 3) {
            shark[2] = sharkOk[0];
            shark[3] = sharkOk[1];
            for (int i = 0; i < shark.length; ++i) {
                System.out.println("|   " +shark[i] + "   |");
            }
        }

    }
     public static void main (String[] args)
    {
        Pet p = new Pet("ok", 0, 0, 8, 0);
        SharkImage.checkStatus(p);
        
        
    }
}
