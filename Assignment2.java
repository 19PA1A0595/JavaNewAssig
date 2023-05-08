//Write a java function that checks if the input string contains all the letters of the alphabet a-z (case-insensitive).
// Write time and space complexity of your solution as comments in the source file.

import java.util.*;

public class Assignment2 {
    public static void main(String[] args) {
        String input1 = "abcdefghijklmnopqrestuvwxyz";
        String input2 = "Pack my box with five dozen liquor jugs";
        System.out.println(Alphabets(input1));
        System.out.println(Alphabets(input2));
    }

    public static boolean Alphabets(String str) {
        str = str.toLowerCase();
        Set<Character> Set = new HashSet<>();
        for (char c : str.toCharArray()) {

            if ('a' - c >= -25 && 'a' - c <= 0) {
                Set.add(c);
            }
        }
        return Set.size() == 26;
    }
}
//Time complexity:O(n)
//Space complexity:O(1)