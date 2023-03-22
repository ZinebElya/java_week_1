/*TODO: Write a program that reads in a text file and then counts the appearance of letters line by line.
    The result should be an overview of how many times each letter (or should we go for character?) appeared.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CountingLetters {
    public static void main(String[] args){

        try {
            File myFile = new File("test2.txt");
            BufferedReader reader = new BufferedReader(new FileReader(myFile));
            String line =  reader.readLine();
            System.out.println(line);
            int[] counts = new int[256]; // We assume ASCII characters

            while (line != null) {
                for (char c : line.toCharArray()) {
                    counts[c]++;
                }
                line = reader.readLine(); // read the next line
            }
            System.out.println(counts);

            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > 0) {
                    System.out.printf("%c: %d\n", i, counts[i]);
                }
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //TODO: The same as challenge 6, but also report which is the most commonly used letter.
        try {
            File myFile = new File("test2.txt");
            BufferedReader reader = new BufferedReader(new FileReader(myFile));
            String line =  reader.readLine();
            int[] counts = new int[26]; // We only count letters of the alphabet
            int maxCount = 0;
            char mostCommonChar = ' ';

            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        char lowercaseChar = Character.toLowerCase(c);
                        counts[lowercaseChar - 'a']++;
                        if (counts[lowercaseChar - 'a'] > maxCount) {
                            maxCount = counts[lowercaseChar - 'a'];
                            mostCommonChar = lowercaseChar;
                        }
                    }
                }
                line = reader.readLine(); // read the next line
            }

            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > 0) {
                    char letter = (char)('a' + i);
                    System.out.printf("%c: %d\n", letter, counts[i]);
                }
            }

            System.out.println("The most commonly used letter is: " + mostCommonChar);
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }












    }
}
