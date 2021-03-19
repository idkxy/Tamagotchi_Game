/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tamagotchi_game;

/**
 *
 * @author Liam
 */
public class Competition {
    public static int compete(int happy, int hunger, int thirst, int energy){
        //equation for money assuming max reward is 100 currency and base is 20:
        //reward = 20 + ((happy + hunger + thirst + energy) * 2)
        //If the reward is equal to 100, the player is rewarded an additional 30 currency
        //i.e. 100 currency = 100 + 30 currency (130)
        
        int pointsEarned = (happy + hunger + thirst + energy) * 2;
        
        if (pointsEarned == 100){
            pointsEarned = 130;
        }
        
        return 20 + pointsEarned;
    }
}