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
    public static int compete(int hunger, int thirst, int happy){
        //equation for money assuming max reward is 100 currency and base is 10:
        //reward = 10 + ((happy + hunger + thirst + energy) * 3)
        //If the reward is equal to 100, the player is rewarded an additional 30 currency
        //i.e. 100 currency = 100 + 30 currency (130)
        
        int pointsEarned = (happy + hunger + thirst) * 3;
        
        if (pointsEarned == 100){
            pointsEarned = 130;
        }
        
        return 10 + pointsEarned;
    }
}
