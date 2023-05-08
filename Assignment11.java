//Using TextFile and a Map<Character,Integer>, create a program that takes the file name as a command
// line argument and counts the occurrence of all the different characters. Save the results in a text file.

import java.io.*;
import java.util.*;
public class Assignment11{
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a filename as an argument.");
            return;
        }

        String fileName = args[0];
        Map<Character, Integer> charCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                char character = (char) currentChar;
                if (charCount.containsKey(character)) {
                    charCount.put(character, charCount.get(character) + 1);
                } else {
                    charCount.put(character, 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("char_count.txt"))) {
            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                char character = entry.getKey();
                int count = entry.getValue();
                writer.println(character + " - " + count);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.println("Character count saved to char_count.txt");
    }
}