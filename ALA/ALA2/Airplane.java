import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class Airplane {
    private char[][] seatMap;
    //default constructor
    public Airplane() {
        seatMap = new char[9][8];
        for (int i = 0; i < seatMap.length; i++) {
            for (int j = 0; j < seatMap[i].length; j++) {
                seatMap[i][j] = '.';
            }
        }
    }
    //second constrcutor
    public Airplane(String filename) {
        seatMap = new char[9][8];
        readMap(filename);
    }

    private void readMap(String filename) {
        //open file
        File file = new File(filename);
        try {
            Scanner readFile = new Scanner(file); //opening
            for (int i = 0; i < seatMap.length; i++) {
                for (int j = 0; j < seatMap[i].length; j++) {
                    seatMap[i][j] = readFile.next().charAt(0);
                }
            }
            readFile.close();
        } catch (FileNotFoundException e) {
            for (int i = 0; i < seatMap.length; i++) {
                for (int j = 0; j < seatMap[i].length; j++) {
                    seatMap[i][j] = '.';
                }
            }
        }
    }

    private boolean checkSeatNumber(String seatNumber) throws InvalidSeatException {
        if (seatNumber.matches("[1-9][A-H]")) {
            return true;
        }
        throw new InvalidSeatException("Invalid seat number (row[1-9]column[A-H]). Please try again.");
    }

    public boolean reserveSeat(String seatNumber) throws InvalidSeatException {
        checkSeatNumber(seatNumber);
        int row = seatNumber.charAt(0) - '1';
        int col = seatNumber.charAt(1) - 'A';
        if (seatMap[row][col] == '.') {
            seatMap[row][col] = 'X';
            return true;
        } else { //seat is reserved
            return false;
        }
    }

    public boolean freeSeat(String seatNumber) throws InvalidSeatException {
        checkSeatNumber(seatNumber);
        int row = seatNumber.charAt(0) - '1';
        int col = seatNumber.charAt(1) - 'A';
        if (seatMap[row][col] == 'X') {
            seatMap[row][col] = '.';
            return true;
        } else { //seat is free
            return false;
        }
    }

    public void saveMap(String filename) {
        File file = new File(filename);
        try {
            PrintWriter pw = new PrintWriter(file);
            for (int i = 0; i < seatMap.length; i++) {
                for (int j = 0; j < seatMap[i].length; j++) {
                    pw.print(seatMap[i][j] + " ");
                }
                pw.println();
            }
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot write to file. seatMap not saved.");
        }
    }

    public String toString() {
        String out = "\tA\tB\tC\tD\tE\tF\tG\tH\n";
        for (int i = 0; i < seatMap.length; i++) {
            out += (i + 1) + "\t";
            for (int j = 0; j < seatMap[i].length; j++) {
                out += seatMap[i][j] + "\t";
            }
            out += "\n";
        }
        return out;
    }
}