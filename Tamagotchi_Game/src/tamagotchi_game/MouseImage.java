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
public class MouseImage {

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

    static void checkStatus(Pet p) {
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
     public static void main (String[] args)
    {
        Pet p = new Pet("ok", 0, 0, 7, 0);
        MouseImage.checkStatus(p);
        
    }
}
