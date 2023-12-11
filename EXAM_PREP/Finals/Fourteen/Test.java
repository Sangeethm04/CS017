import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
//Implement the hierarchy of classes shown below. Write a program that reads the files patients.txt, doctors.txt, and billings.txt, and prints out the total income from the Billing records, the highest total income of doctors, and the highest total spending of patients. Note that Person is an abstract class.
public class Test {


    public static void main(String[] args) {
        ArrayList < Billing > bills = new ArrayList < > ();
        ArrayList < Doctor > doctors = new ArrayList < > ();
        ArrayList < Patient > patients = new ArrayList < > ();
       

    }

    public static double highestSpend(ArrayList<Patient> patients, ArrayList < Doctor > doctors, ArrayList < Billing > bills){

    }

    public static void readBills(String file, ArrayList < Billing > bills, ArrayList < Doctor > doctors, ArrayList < Patient > patients) {
        try {
            Scanner files = new Scanner(new File(file));
            while (files.hasNextLine()) {
                String line = files.nextLine();
                String[] data = line.split("\\ ");
                Patient p = new Patient(data[0], data[1]);
                bills.add(new Billing(doctors.get[data[0]]));
            }
            files.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void readPatients(String file, ArrayList < Patient > patients) {
        try {
            Scanner files = new Scanner(new File(file));
            while (files.hasNextLine()) {
                String line = files.nextLine();
                String[] data = line.split("\\ ");
                patients.add(new Patient(data[0], data[1]));
            }
            files.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void readDoctors(String file) {
        try {
            Scanner files = new Scanner(new File(file));
            while (files.hasNextLine()) {
                String line = files.nextLine();
                String[] data = line.split("\\ ");
                System.out.println(data[0]);
            }
            files.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}