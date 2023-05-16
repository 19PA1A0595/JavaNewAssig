//Write a java function that will ping any host ( given as input ) and computes the median of the time taken to ping.
// Use the system ping utility, do not use any deprecated methods.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;
public class Assignment3 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        String host =sc.next();
        ProcessBuilder processBuilder = new ProcessBuilder("ping", "-n", "10", host);

        Process pingProcess = processBuilder.start();

        BufferedReader input = new BufferedReader(new InputStreamReader(pingProcess.getInputStream()));
        int[] pingTimes = new int[5];
        int count = 0;
        while ((input.readLine()!="" )&& count < 5) {
            String line = input.readLine();
            if (line.startsWith("Reply from ")) {
                int startIndex = line.indexOf("time=");
                int endIndex = line.indexOf("ms", startIndex);
                pingTimes[count++] = Integer.parseInt(line.substring(startIndex+5, endIndex));
            }
        }

        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += pingTimes[i];
        }
        double median = (count % 2 == 0) ? (double) (pingTimes[count/2 - 1] + pingTimes[count/2]) / 2 : pingTimes[count/2];
        System.out.println("Median ping time: " + median + " ms");
    }
}