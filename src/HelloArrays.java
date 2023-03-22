/* TODO: Write a small program that will build up an array with a maximum size filled with random primitive integers.
    When the array is ready, loop over it and print out every number smaller than 10 (this is the upper limit for printing)
    Extra: how can you make the program run so that it is easy to change the upper limit for printing?*/

import java.util.Random;

public class HelloArrays {
    public static void main(String[] args){
        int [] myArray = new int[20];  // create an array with maxSize 20
        Random random = new Random();  // create a Random object

        // fill the array with random integers
        for (int i = 0 ; i < myArray.length; i++){
            myArray[i] = random.nextInt(30); // generate a random integer between 0 and 30
        }
        // print the array
        for (int x = 0 ; x < myArray.length; x++){
            System.out.println("print1 : " +  myArray[x]);
        }

        //print out every number smaller than 10
        for (int y = 0 ; y < myArray.length; y++){
            if(myArray[y]<10) {
                System.out.println("print2 : " +  myArray[y]);
            }
        }


    }
}
