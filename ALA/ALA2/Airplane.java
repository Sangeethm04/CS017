import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

/**
 * Airplane class for ALA2
 */
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
    /**
     * Constructor that takes a filename as a parameter
     * @param filename
     */
    public Airplane(String filename) {
        seatMap = new char[9][8];
        readMap(filename);
    }

    /**
     * Reads the seat map from a file
     * @param filename
     */
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

    /**
     * Checks if the seat number is valid
     * @param seatNumber seat number to check
     * @return boolean true if valid, false otherwise
     */
    private boolean checkSeatNumber(String seatNumber) throws InvalidSeatException {
        if (seatNumber.matches("[1-9][A-H]")) {
            return true;
        }
        throw new InvalidSeatException("Invalid seat number (row[1-9]column[A-H]). Please try again.");
    }

    /**
     * Reserves a seat
     * @param seatNumber seat number to reserve
     * @return boolean true if reserved, false otherwise
     */
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

    /**
     * Frees a seat on airplane
     * @param seatNumber seat number to free
     * @return boolean true if freed, false otherwise
     * @throws InvalidSeatException
     */
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

    /**
     * Saves the seat map to a file
     * @param filename
     * @throws FileNotFoundException
     */
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

    /**
     * Returns a string representation of the seat map
     * @return String of attributes
     */
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