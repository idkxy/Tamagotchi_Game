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
public class BearImage {
    
    static String[] bear = new String[]
    {
    "|                           (()__(()                            |",
    "|                          /       \\                            |",
    "|                         (  -   -  \\                           |",
    "|                         \\ o  o   /                            |",     
    "|                          (_()_)__/ \\                          |",      
    "|                         / _,==.____ \\                         |",      
    "|                        (   |--|      )                        |",       
    "|                        /\\_.|__|'-.__/\\_                       |",        
    "|                       / (        /     \\                      |",        
    "|                       \\  \\      (      /                      |",        
    "|                        )  '._____)    /                       |",            
    "|                     (((____.--(((____/                        |"};
                                  
    static String[] bearSad = new String[]
    {
    "|                         ( /   \\   \\                           |",
    "|                          \\ *  *   /                           |",     };
    
    static String[] bearHappy = new String[]
    {
    "|                         ( ^   ^   \\                           |",
    "|                          \\ >  <   /                           |",     };
    
    static String[] bearOk = new String[]
    {
    "|                         ( -   -   \\                           |",
    "|                          \\ o  o   /                           |",      };
    
    
    static void checkStatus(Pet p){
    if(p.stats.getHappiness() > 6)
    {
        bear[2] = bearHappy[0];
        bear[3] = bearHappy[1];
         for(int i = 0; i < bear.length; ++i)
        {
            System.out.println("|   " +bear[i] + "   |");
        }
    }
    else if(p.stats.getHappiness() < 3)
    {
        bear[2] = bearSad[0];
        bear[3] = bearSad[1];
        for(int i = 0; i < bear.length; ++i)
        {
            System.out.println("|   " +bear[i] + "   |");
        }
    }
    else if(p.stats.getHappiness() < 6 && p.stats.getHappiness() > 3)
    {
        bear[2] = bearOk[0];
        bear[3] = bearOk[1];
        for(int i = 0; i < bear.length; ++i)
        {
            System.out.println("|   " +bear[i] + "   |");
        }
    }
}
    
    
    public static void main (String[] args)
    {
        Pet p = new Pet("ok", 0, 0, 8, 0);
        BearImage.checkStatus(p);
    }
    
    
}
