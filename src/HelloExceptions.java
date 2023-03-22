/* TODO: Write a small program that will build up a random array of non-primitive integers, and 0 is a valid entry.
    Now loop over the array and divide each integer with the previous integer.
    The first integer can be divided by itself.
    How will you make sure that the program doesn't crash when dividing by zero?
 */

import java.util.Random;
public class HelloExceptions {
    public static void main(String[] args) {
        int arraySize = 10;
        Integer [] myArray = new Integer[arraySize];  // Generate a random array of Integer objects
        Random random = new Random();  // create a Random object


        for(int i = 0; i < arraySize; i++){
            // Generate a random integer between -10 and 10, inclusive
            int value = random.nextInt(21) -10;
            myArray[i] = value;
        }

        // Divide each integer with the previous integer
        Integer previous = myArray[0];
        for(int i = 1; i < arraySize; i++){
            Integer current = myArray[i];
            try{
                Integer result = current / previous;
                System.out.println("Division of index " + i + " = " + result);
                previous = current;

            }catch(ArithmeticException e){
                System.out.println("No division by zero for index " + i);
            }
        }
    }
}
