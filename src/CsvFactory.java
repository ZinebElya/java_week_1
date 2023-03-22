/*TODO: Write a program that will create csv files. The csv files will contain the following fields:
    firstname: The firstname is a name which will be chosen randomly from a set of 30 firstnames.
    Lastname: The lastname is a name which will be chosen randomly from a set of 40 lastnames.
    Reason: This value is to be chosen randomly from 2 values: Appointment or visit
    Department: This value is a value chosen from 5 values: Cardiology, Radiology, Pediatrics, Geriatrics, Pulmonology.
    This is only to be filled in if the reason of the visit is 'Appointment'
    Date of the visit. The date can be something random, but let's keep it in a certain month in the current year.
    You can decide how long this file is, don't make it too long though. Ideally, this challenge also consists out of multiple classes

 */

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class CsvFactory{
    private static final String[] FIRSTNAMES = {"John", "Jane", "Michael", "Emily", "David", "Samantha", "Christopher", "Megan", "James", "Sarah", "Robert", "Olivia", "William", "Ava", "Richard", "Grace", "Joseph", "Isabella", "Charles", "Sophia", "Thomas", "Madison", "Daniel", "Elizabeth", "Matthew", "Chloe", "Anthony", "Victoria", "Donald", "Emma", "Steven"};
    private static final String[] LASTNAMES = {"Smith", "Johnson", "Brown", "Taylor", "Wilson", "Miller", "Davis", "Garcia", "Jones", "Martin", "Anderson", "Jackson", "Harris", "White", "Clark", "Lewis", "Robinson", "Walker", "Young", "Hall", "Allen", "King", "Wright", "Scott", "Green", "Baker", "Adams", "Nelson", "Carter", "Mitchell"};
    private static final String[] REASONS = {"Appointment", "Visit"};
    private static final String[] DEPARTMENTS = {"Cardiology", "Radiology", "Pediatrics", "Geriatrics", "Pulmonology"};

    private static final int MAX_RECORDS = 50;

    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("visits.csv");
            writer.write("Firstname,Lastname,Reason,Department,Date\n");

            Random rand = new Random();
            for (int i = 0; i < MAX_RECORDS; i++) {
                String firstname = FIRSTNAMES[rand.nextInt(FIRSTNAMES.length)];
                String lastname = LASTNAMES[rand.nextInt(LASTNAMES.length)];
                String reason = REASONS[rand.nextInt(REASONS.length)];
                String department = reason.equals("Appointment") ? DEPARTMENTS[rand.nextInt(DEPARTMENTS.length)] : "";
                LocalDate date = LocalDate.of(2023, 3, rand.nextInt(31) + 1); // Set to March 2023

                VisitRecord record = new VisitRecord(firstname, lastname, reason, department, date);
                writer.write(record.toString() + "\n");
            }

            writer.close();
            System.out.println("CSV file created successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the CSV file.");
            e.printStackTrace();
        }
    }
}

class VisitRecord {
    private String firstname;
    private String lastname;
    private String reason;
    private String department;
    private LocalDate date;

    public VisitRecord(String firstname, String lastname, String reason, String department, LocalDate date) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.reason = reason;
        this.department = department;
        this.date = date;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getReason() {
        return reason;
    }

    public String getDepartment() {
        return department;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return firstname + "," + lastname + "," + reason + "," + department + "," + date.toString();
    }
}


