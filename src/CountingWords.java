/*TODO: Write a program that reads in a text file and then counts the appearance of words line by line.
    The result should be an overview of how many times each word was in the text.
 */
import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.util.Scanner; // Import the Scanner class to read text files

import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileNotFoundException;  // Import this class to handle errors

import java.util.HashMap;
import java.util.Map;

public class CountingWords {
    public static void main(String[] args){
        //TODO: create a new file
        try{
            File myFile = new File("test.txt");
            if(myFile.createNewFile()){
                System.out.println("File created: " + myFile.getName());
            }else{
                System.out.println("File already exists.");
            }
        }catch(IOException e){
            System.out.println("An error occurred. // creating file");
            e.printStackTrace();
        }

        //TODO: write in the file
        try{
            FileWriter myFile = new FileWriter("test.txt");
            myFile.write("As the sun rose over the horizon, the small town of Millfield slowly awakened from its slumber.\n" +
                    "The streets, which had been deserted just a few hours before, were now bustling with activity as the residents went about their daily routines.\n" +
                    "The smell of fresh coffee wafted out of the local cafes, while the sound of schoolchildren's laughter filled the air.\n" +
                    "It was just another ordinary day in Millfield, but for the people who lived there, it was home, and there was nowhere else they'd rather be.");

            myFile.close();
        }catch(IOException e){
            System.out.println("An error occurred. // writing file");
            e.printStackTrace();
        }

        //TODO: read the file
        try {
            File myFile = new File("test.txt");

            Scanner myReader = new Scanner(myFile);// myReader: will be used to read the contents of myFile line by line.
            while (myReader.hasNextLine()) {                   // this loop will continue until it reaches the end of the file.
                String line = myReader.nextLine();           // This line of text will be printed to the console in the next line.
                System.out.println(line);
            }
            myReader.close();

        }catch(FileNotFoundException e){
            System.out.println("An error occurred. // reading file");
            e.printStackTrace();
        }

        //TODO: count words
        try{
            File myFile = new File("test.txt");
            Scanner myReader = new Scanner(myFile);

            Map<String, Integer> wordCounts = new HashMap<>();

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] words = line.split("[,\\s]+"); //splits the line into words using the split() method


                for(String word : words){
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }
            // Print the word counts
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                System.out.printf("%-20s %d%n", entry.getKey(), entry.getValue());
            }

            myReader.close();

        }catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

        //TODO: we also want to know which word was used the most.
        try {
            File myFile = new File("test.txt");
            Scanner myReader = new Scanner(myFile);

            Map<String, Integer> wordCount = new HashMap<>();
            String mostFrequentWord = "";
            int maxCount = 0;

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] words = line.split("[,\\s]+"); //split by comma and whitespace

                for (String word : words) {
                    if (wordCount.containsKey(word)) {
                        int count = wordCount.get(word);
                        wordCount.put(word, count + 1); //update the count in the HashMap

                        if (count + 1 > maxCount) { //updating the maxCount and mostFrequentWord variables whenever a word is added to the HashMap
                            maxCount = count + 1;
                            mostFrequentWord = word;
                        }
                    } else {
                        wordCount.put(word, 1);

                        if (1 > maxCount) {
                            maxCount = 1;
                            mostFrequentWord = word;
                        }
                    }
                }
            }
            System.out.println("Most frequently used word: " + mostFrequentWord);
            myReader.close();
        }catch(FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }
}
