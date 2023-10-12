import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        Stack < Integer > postfixStack = new Stack < > ();
        Scanner keyboard = new Scanner(System.in);
        String expression = "";
        String[] tokens;
        do {
            System.out.println("Enter a postfix expression:");
            expression = keyboard.nextLine();
            tokens = expression.split(" ");
            try {
                for (String token: tokens) {
                    if (token.matches("\\d{1,}")) {
                        int operand = Integer.parseInt(token);
                        postfixStack.push(operand);
                    } else {
                        int operand1 = postfixStack.pop();
                        int operand2 = postfixStack.pop();
                        switch (token) {
                            case "+":
                                postfixStack.push(operand2 + operand1);
                                break;
                            case "-":
                                postfixStack.push(operand2 - operand1);
                                break;
                            case "*":
                                postfixStack.push(operand2 * operand1);
                                break;
                            case "/":
                                postfixStack.push(operand2 / operand1);
                                break;
                            default:
                                System.out.println("Invalid operation");
                        }
                    }
                }
                int result = postfixStack.pop();
                if (postfixStack.isEmpty()) {
                    System.out.println("Result = " + result);
                } else {
                    System.out.println("Malformed postfix expression");
                    System.out.println("Do you want to evaluate another postfix expression? (yes/no):");
                    expression = keyboard.nextLine();
                }
            } catch (EmptyStackException e) {
                System.out.println("Malformed postfix expression");
                System.out.println("Do you want to evaluate another postfix expression? (yes/no):");
                expression = keyboard.nextLine();

            }
        } while (!expression.equals("no"));

        // Using the priority Queue
        PriorityQueue < PrintRequest > printingQueue = new PriorityQueue < > ();
        try {
            Scanner readFile = new Scanner(new File("requests.txt"));
            while (readFile.hasNextLine()) {
                String line = readFile.nextLine();
                tokens = line.split(" ");
                int id = Integer.parseInt(tokens[0]);
                String group = tokens[1];
                long size = Long.parseLong(tokens[2]);
                PrintRequest pr = new PrintRequest(id, group, size);
                printingQueue.offer(pr);
            }
            readFile.close();
            //process printing requests
            long speed = 10000; //10,000 bytes/s
            while (!printingQueue.isEmpty()) {
                PrintRequest pr = printingQueue.poll();
                long time = pr.getSize() / speed;
                System.out.println(pr + "\t" + time);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}