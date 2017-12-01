/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonrepeatingletter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Office
 */
public class NonRepeatingLetter {

    /**
     * @param args the command line arguments
     */
    static Scanner input = null;
    static String in;

    public static void main(String[] args) {
        // TODO code application logic here
        input = new Scanner(System.in);
        do {
            System.out.println("Enter a string:");
            in = input.nextLine();
            System.out.println("First NonRepeating Letter: " + firstNonRepeatingLetter(in));
        } while (!"-1".equalsIgnoreCase(in));
    }

    static ArrayList<Character> nonRepeatedCharArray = new ArrayList<Character>();

    private static Character firstNonRepeatingLetter(String inputString) {
        char repeatedChar = 0;
        nonRepeatedCharArray.clear();

        if (inputString != null) {
            for (Character ch : inputString.toCharArray()) {

                if (!containsIgnoreCase(ch) && Character.toLowerCase(ch) != Character.toLowerCase(repeatedChar)) {
                    nonRepeatedCharArray.add(ch);
                } else {
                    deleteRepeatedChar(ch);
                    repeatedChar = ch;
                }
            }
        }

        return nonRepeatedCharArray.isEmpty() ? 0 : nonRepeatedCharArray.get(0);
    }

    public static boolean containsIgnoreCase(Character ch) {
        for (Character i : nonRepeatedCharArray) {
            if (Character.toLowerCase(i) == Character.toLowerCase(ch)) {
                return true;
            }
        }
        return false;
    }

    public static void deleteRepeatedChar(Character ch) {
        nonRepeatedCharArray.removeAll(Collections.singleton(ch));
    }
}
