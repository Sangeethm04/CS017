import java.util.InputMismatchException;
import java.util.Scanner;

public class SeatReservation {
    public static void main(String[] args) {
        Airplane ap = new Airplane("seatsmap.txt");
        Scanner keyboard = new Scanner(System.in);
        int operation = 0;
        do {
            System.out.println(ap);
            System.out.println("Select an operation:");
            System.out.println("1: Reserve a seat");
            System.out.println("2: Free a seat");
            System.out.println("3: Quit");
            try {
                operation = keyboard.nextInt();
                String seatNumber;
                switch (operation) {
                    case 1:
                        System.out.println("Enter a seat number");
                        seatNumber = keyboard.next();
                        if (ap.reserveSeat(seatNumber)) {
                            System.out.println("Seat " + seatNumber + " reserved successufully");
                        } else {
                            System.out.println("Seat " + seatNumber + " already reserved");
                        }
                        break;
                    case 2:
                        System.out.println("Enter a seat number");
                        seatNumber = keyboard.next();
                        if (ap.freeSeat(seatNumber)) {
                            System.out.println("Seat " + seatNumber + " freed successufully");
                        } else {
                            System.out.println("Seat " + seatNumber + " already free");
                        }
                        break;
                    case 3:
                            ap.saveMap("seatsmap.txt");
                            break;
                    default:
                            System.out.println("Invalid operation (1 to 3)");
                }
            } catch (InvalidSeatException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input operation");
                keyboard.next();
            }

        } while (operation != 3);

    }
}