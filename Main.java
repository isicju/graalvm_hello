//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello World");
//    }
//}

//
//
//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//        int listSize = 1000000;
//        long begin = System.nanoTime();
//        // Create a list of random integers
//        List<Integer> list = new ArrayList<>();
//        Random random = new Random();
//        for (int i = 0; i < listSize; i++) {
//            list.add(random.nextInt());
//        }
//
//        // Shuffle the list
//        long jdkShuffleStart = System.nanoTime();
//        Collections.shuffle(list);
//        long jdkShuffleEnd = System.nanoTime();
//
//        // Sort the list
//        long jdkSortStart = System.nanoTime();
//        Collections.sort(list);
//        long jdkSortEnd = System.nanoTime();
//
//        // Reverse the list
//        long jdkReverseStart = System.nanoTime();
//        Collections.reverse(list);
//        long jdkReverseEnd = System.nanoTime();
//
//        // Sum the list
//        long jdkSumStart = System.nanoTime();
//        int jdkSum = 0;
//        for (int i = 0; i < listSize; i++) {
//            jdkSum += list.get(i);
//        }
//        long jdkSumEnd = System.nanoTime();
//
//        // Shuffle the list again
//
//        System.out.println("JDK shuffle time: " + (jdkShuffleEnd - jdkShuffleStart) + " nanoseconds");
//        System.out.println("JDK sort time: " + (jdkSortEnd - jdkSortStart) + " nanoseconds");
//        System.out.println("JDK reverse time: " + (jdkReverseEnd - jdkReverseStart) + " nanoseconds");
//        System.out.println("JDK sum time: " + (jdkSumEnd - jdkSumStart) + " nanoseconds");
//
//        long end = System.nanoTime();
//        System.out.println("JDK total time: " + (end - begin) + " nanoseconds");
//    }
//
////    public static void main(String[] args) {
////        long startTime = System.nanoTime();
////        long totalsize = 10;
////        for (int i = 0; i < 1000000; i++) {
////            String s = "somestiringsomestiringsomestiringsomestiringsomestiringsomestiringsomestiringsomestiringsomestiringsomestiringsomestiringsomestiring";
////            totalsize = totalsize + reverse(s).length();
////        }
////        long endTime = System.nanoTime();
////        long duration = (endTime - startTime) / 1000000; // convert to milliseconds
////        System.out.println("Duration: " + duration + "ms");
////    }
////
////    public static String reverse(String s) {
////        StringBuilder sb = new StringBuilder();
////        for (int i = s.length() - 1; i >= 0; i--) {
////            sb.append(s.charAt(i));
////        }
////        return sb.toString();
////    }
//
//
//}

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int NUM_RANDOM_NUMBERS = 1000000;
    private static final String URL_TO_CALL = "https://www.google.com";
    private static final int NUM_HTTP_CALLS = 100;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // Generate random numbers and store them in a list
        List<Integer> randomNumbers = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < NUM_RANDOM_NUMBERS; i++) {
            randomNumbers.add(rand.nextInt());
        }

        // Calculate the sum of the random numbers
        int sum = 0;
        for (int randomNumber : randomNumbers) {
            sum += randomNumber;
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Time to generate random numbers and calculate sum: " + elapsedTime + " milliseconds");

        startTime = System.currentTimeMillis();

        // Write the random numbers to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("random_numbers.txt"))) {
            for (int randomNumber : randomNumbers) {
                writer.write(randomNumber + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Time to write random numbers to file: " + elapsedTime + " milliseconds");

        startTime = System.currentTimeMillis();

        // Make HTTP calls to a specified URL
        try {
            URL url = new URL(URL_TO_CALL);
            for (int i = 0; i < NUM_HTTP_CALLS; i++) {
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                connection.getInputStream().close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Time to make " + NUM_HTTP_CALLS + " HTTP calls: " + elapsedTime + " milliseconds");
    }
}
