/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tamagotchi_game;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Liam
 */
public class InputValidation {
    String input = "";
    public String numbers(Scanner scan){
        input = scan.nextLine();
        
        while (!input.matches("^[1-2]{1}$"))
            {
                System.out.print("invalid input! try again: ");
                input = scan.nextLine();
            }
        
        return input;
    }
}