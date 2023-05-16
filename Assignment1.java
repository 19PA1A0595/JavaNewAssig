//Create a java program to search through the home directory and look for files that match a regular expressio.
//The program should be able to take inputs repeatedly and should print out the full absolute path of the matching files found.


import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String directoryPath = "C:\\Users\\chellarao\\OneDrive\\Desktop\\assignment\\src\\component";
        File directory = new File(directoryPath);

        while (true) {
            System.out.print("Enter a regular expression to search for files (or type 'exit' to quit): ");
            String patternString = scanner.nextLine();

            if (patternString.equals("exit")) {
                break;
            }

            Pattern pattern = Pattern.compile(patternString);
            File[] files = directory.listFiles();

            System.out.println("Matching files:");
            for (File file : files) {
                String fileName = file.getName();
                Matcher matcher = pattern.matcher(fileName);

                if (matcher.matches()) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}