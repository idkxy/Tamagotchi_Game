package tamagotchi_game;

import java.util.Scanner;

public class InputValidation {

    String input = "";
    
    /**
     * test test 123
     * @param scan The scanner which is taking input.
     * @param min Minimum number wanted in input range.
     * @param max Maximum number wanted in input range.
     * @return the input value
     */
    public String numbers(Scanner scan, int min, int max) {
        input = scan.nextLine();

        while (!input.matches("^[" + min + "-" + max + "2]{1}$")) {
            System.out.print("invalid input! try again: ");
            input = scan.nextLine();
        }

        return input;
    }
}
