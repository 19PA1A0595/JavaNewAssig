//1. A vampire number v is a number with an even number of digits n, that can be factored into two numbers x and y each with n/2 digits and not both with trailing zeroes, where v contains precisely all the digits from x and from y, in any order.
// Write a java program to print first 100 vampire numbers.
import java.util.HashSet;
public class Assignment6_1 {
    public static void main(String[] args) {
        int count = 0;
        long number = 10;
        HashSet<Long> vampireNumbers = new HashSet<Long>();
        while (count < 100) {
            String strNumber = String.valueOf(number);
            int len = strNumber.length();
            if (len % 2 != 0) {
                number++;
                continue;
            }
            for (long i = 1; i <= Math.sqrt(number) + 1; i++) {
                if (number % i != 0) {
                    continue;
                }
                String strI = String.valueOf(i);
                if (strI.length() != len / 2) {
                    continue;
                }
                String strJ = String.valueOf(number / i);
                if (strJ.length() != len / 2) {
                    continue;
                }
                String strIJ = strI + strJ;
                String strNumberSorted = String.valueOf(number).chars().sorted().mapToObj(c -> String.valueOf((char)c)).reduce((s1, s2) -> s1 + s2).get();
                String strIJSorted = strIJ.chars().sorted().mapToObj(c -> String.valueOf((char)c)).reduce((s1, s2) -> s1 + s2).get();
                if (strNumberSorted.equals(strIJSorted)) {
                    vampireNumbers.add(number);
                    count++;
                }
            }
            number++;
        }
        System.out.println("First 100 vampire numbers are: ");
        for (long vampireNumber : vampireNumbers) {
            System.out.println(vampireNumber);
        }
    }
}
