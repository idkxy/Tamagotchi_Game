package tamagotchi_game;

import java.util.Scanner;

 /* 
 * @author DaisyXiao - 1392836
 * @author Liam Yates - 18016696
 * @author Liam Rimmer - 18040246
 */
public class InputValidation {

    /**
     * Validates input through the power of regex
     *
     * @param scan The scanner which is taking input.
     * @param values The only valid inputs the scanner should take. Case
     * insensitive.
     * @return the input value
     */
    public static String regexValidate(Scanner scan, String values) {
        String[] temp = values.split("");
        // prints accepted input on cli
        System.out.print("User (");
        for (int k = 0; k < temp.length; k++) {
            temp[k] = temp[k].toUpperCase();
            System.out.print(temp[k] + (k == temp.length - 1 ? "" : ","));
        }
        System.out.print("):");

        // builds regex string
        String regex = "(?i)^";
        String input = scan.nextLine();
        for (int i = 0; i < temp.length; i++) {
            regex += "[" + temp[i] + "]";
            if (i < temp.length - 1) {
                regex += "|";
            }
        }
        regex += "{1}$";

        //polls for valid input
        while (!input.matches(regex)) {
            System.out.print("invalid input! try again: ");
            input = scan.nextLine();
        }
        return input;
    }
}
