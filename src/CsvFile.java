/* TODO: Write a program that can read in a comma separated value file (a csv file).
    Make a data model (a class) to hold the lines and print out only one particular piece of information.
    So we are expecting getter and setter methods.
    Students should also be able to explain what a method signature is.
    Ideally, the solution for this challenge also consists out of multiple classes.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CsvFile {
    public static void main(String[] args){

        String csvFile = "data.csv";
        String spiltBy = ",";
        int lineNumber = 0;

        try{
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            String line = reader.readLine();

            while( line != null){
                // Skip the first line since it contains headers
                if (lineNumber == 0) {
                    lineNumber++;
                    continue;
                }

                // Split the line by comma and create a new DataModel object
                String[] data = line.split(spiltBy);

                /*if (data.length < 3) {
                    continue; // Skip this line if it doesn't have enough data
                }*/
                DataModel model = new DataModel();
                model.setName(data[0]);
                //model.setAge(Integer.parseInt(data[1]));
                //model.setGender(data[2]);

                System.out.println("Name: " + model.getName() + "  Age: " + model.getAge());

                line = reader.readLine();

            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class DataModel{
    private String name;
    private int age;
    private String gender;

    public DataModel() {
        this.name = "";
        this.age = 0;
        this.gender = "";
    }

    // Getters and Setters
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

}
/*A method signature is the part of a method declaration that includes the method name and its parameter types.
For example, in the setName(String name) method of the DataModel class, the method signature is setName(String).
The method signature is used to uniquely identify the method in the program.*/
