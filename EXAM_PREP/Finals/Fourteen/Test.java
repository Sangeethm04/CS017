import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    // Main method
    public static void main(String[] args) {
        ArrayList < Patient > patientList = new ArrayList < > ();
        ArrayList < Doctor > doctorList = new ArrayList < > ();
        ArrayList < Billing > billingList = new ArrayList < > ();
        readDoctorFile("doctors.txt", doctorList);
        readPatientFile("patients.txt",
            patientList, doctorList);
        readBillingFile("billings.txt", billingList,
            patientList, doctorList);
        double total = 0;
        for (int i = 0; i < billingList.size(); i++)
            total += billingList.get(i).getDoctor().getFee();
        System.out.printf("Total Billing Amount: %.2f$\n",
            total);
        doctorIncome(doctorList, billingList);
        patientSpending(patientList, billingList);
    }
    public static void doctorIncome(ArrayList < Doctor > dList,
        ArrayList < Billing > bList) {
        double max = 0;
        int maxIndex = 0;
        ArrayList < Double > doctorIncome = new ArrayList < > ();
        for (int i = 0; i < dList.size(); i++)
            doctorIncome.add(0.0);
        for (int i = 0; i < dList.size(); i++) {
            for (int j = 0; j < bList.size(); j++) {
                if (bList.get(j).getDoctor().equals(dList.get(i))) {
                    doctorIncome.set(i,
                        doctorIncome.get(i) + dList.get(i).getFee());
                }
            }
        }
        for (int i = 0; i < doctorIncome.size(); i++) {
            if (doctorIncome.get(i) > max) {
                maxIndex = i;
                max = doctorIncome.get(i);
            }
        }
        System.out.printf(
            "Doctor with the maximum income: %-15s ($%.2f)\n",
            dList.get(maxIndex).getName(), max);
    }
    public static void patientSpending(
        ArrayList < Patient > pList,
        ArrayList < Billing > bList) {
        double max = 0;
        int maxIndex = 0;
        ArrayList < Double > pSpending = new ArrayList < > ();
        for (int i = 0; i < pList.size(); i++)
            pSpending.add(0.0);
        for (int i = 0; i < pList.size(); i++) {
            for (int j = 0; j < bList.size(); j++) {
                if (bList.get(j).getPatient().equals(pList.get(i))) {
                    pSpending.set(i, pSpending.get(i) +
                        bList.get(j).getDoctor().getFee());
                }
            }
        }
        for (int i = 0; i < pSpending.size(); i++) {
            if (pSpending.get(i) > max) {
                maxIndex = i;
                max = pSpending.get(i);
            }
        }
        System.out.printf(
            "Patient with the maximum spending: %-15s ($%.2f)\n",
            pList.get(maxIndex).getName(), max);
    }

    public static void readPatientFile(String filename,
        ArrayList < Patient > list,
        ArrayList < Doctor > dList) {
        Scanner readFile = null;
        File file = new File(filename);
        try {
            readFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
        while (readFile.hasNext()) {
            String p = readFile.next();
            String dname = readFile.next();
            Doctor d = new Doctor(dname, "", 0);
            int index = dList.indexOf(d);
            if (index != -1) {
                list.add(new Patient(p, dList.get(index)));
            }
        }
        readFile.close();
    }
    public static void readDoctorFile(String filename,
        ArrayList < Doctor > list) {
        Scanner readFile = null;
        File file = new File(filename);
        try {
            readFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
        while (readFile.hasNext()) {
            Doctor d = new Doctor(readFile.next(),
                readFile.next(),
                readFile.nextDouble());
            list.add(d);
        }
        readFile.close();
    }
    public static void readBillingFile(String filename,
        ArrayList < Billing > list,
        ArrayList < Patient > pList,
        ArrayList < Doctor > dList) {
        Scanner readFile = null;
        File file = new File(filename);
        try {
            readFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
        while (readFile.hasNext()) {
            String pname = readFile.next();
            Patient p = new Patient(pname, null);
            String dname = readFile.next();
            Doctor d = new Doctor(dname, "", 0);
            int dindex = dList.indexOf(d);
            int pindex = pList.indexOf(p);
            if (pindex != -1 && dindex != -1)
                list.add(new Billing(pList.get(pindex),
                    dList.get(dindex)));
        }
        readFile.close();
    }
}