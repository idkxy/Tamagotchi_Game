/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tamagotchi_game;

import java.util.Random;

/**
 *
 * @author idkxy
 */
public enum Maturity {
    BABY,
    ADULT;
    
    final static Maturity randomMaturity()
    {
        Maturity[] maturity = Maturity.values();
        Random random = new Random();
        return maturity[random.nextInt(maturity.length)];
    }
}
