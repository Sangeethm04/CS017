import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class GymManager {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		// Read the list of classes in an array list
		LinkedList < Class > classes = new LinkedList < > ();
		readClasses(classes, "classes.txt");
		// Read the list of users in a hash map
		// username is the key and the User object is the value
		HashMap < String, User > users = new HashMap < > (500);
		readUsers(users, "users.txt");

		// Read the list of members in a BST
		BST < Member > members = new BST < > ();
		readMembers(members, "members.txt");
		// login interface (username and password)

		try { 
			User user = login(keyboard, users);	
			if (user != null) {
			if (user.getID().startsWith("M")) {
				// Member menu (add/drop sessions)
				memberOperations(keyboard, user.getID(), members, classes);
			} else {
				// Administrator menu (popular classes/income)
				adminOperations(classes, members);
			}
		}
		} catch(InputMismatchException e) {
			System.out.println(e);
		}
		

	
	}
	/**
	 * Method readClasses
	 * @param list linked list where the data read will be stored
	 * @param filename name of the text file to read from
	 */
	public static void readClasses(LinkedList < Class > list, String filename) {
		File file = new File(filename);
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
			while (readFile.hasNextLine()) {
				String line = readFile.nextLine();
				String[] tokens = line.split(" ");
				Class c = new Class(tokens[0], tokens[1],
					Integer.parseInt(tokens[2]),
					Double.parseDouble(tokens[3]),
					tokens[4]);
				list.add(c);
			}
			readFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File " + filename + " not found");
		}
	}

	/**
	 * Method readUsers
	 * @param ht the hashtable where the read data will be stored
	 * @param filename name of the text file to read from
	 */
	public static void readUsers(HashMap < String, User > hm, String filename) {
		File file = new File(filename);
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
			while (readFile.hasNextLine()) {
				String line = readFile.nextLine();
				String[] tokens = line.split(" ");
				User user = new User(tokens[0], tokens[1], tokens[2]);
				hm.put(tokens[1], user);
			}
			readFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File " + filename + " not found");
		}
	}

	/**
	 * Method readMembers
	 * @param bst the binary search tree where the data read will be stored
	 * @param filename name of the text file to read from
	 */
	public static void readMembers(BST < Member > bst, String filename) {
		File file = new File(filename);
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
			while (readFile.hasNextLine()) {
				String line = readFile.nextLine();
				String[] tokens = line.split(" ");
				String id = tokens[0];
				String name = tokens[1];
				Member m = new Member(id, name);
				for (int i = 2; i < tokens.length; i++) {
					m.addClass(tokens[i]);
				}
				bst.add(m);
			}
			readFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File " + filename + " not found");
		}
	}
	/**
	 * Method to check the user credentials
	 * @param scan the scanner used to interact with the user
	 * @param users the hashtable with all the users credentials
	 */
	public static User login(Scanner scan, HashMap < String, User > users) {
		int count = 0;
		while (count < 3) {
			System.out.print("Enter username: ");
			String username = scan.next();
			if (!username.matches("[a-z]{3}[0-9]{3}")) {
				throw new InputMismatchException();
			}
			User u = users.get(username);
			if (u == null) {
				System.out.println("Username not found. Try again.");
			} else {
				System.out.print("\nEnter password: ");
				String password = scan.next();
				if (u.getPassword().equals(password)) {
					return u;
				} else {
					System.out.println("Password incorrect. Try again.");
				}
			}
			count++;
		}
		System.out.println("Incorrect username or password more than 3 times.");
		System.out.println("Terminating the program...");
		return null;
	}

	/**
	 * Method memberOperations
	 * @param scan the Scanner object used to interact with the user
	 * @param id the id of the member for whom the operations are performed
	 * @param members the BST of the Gym members
	 * @param classes the linked list of the Gym classes
	 */
	public static void memberOperations(Scanner scan, String id,
		BST < Member > members, LinkedList < Class > classes) {
		int operation;
		Member m = members.find(new Member(id, ""));
		if (m == null) {
			System.out.println("ID: " + id + " not found.");
			System.exit(0);
		}
		do {
			ArrayList < String > myClasses = m.getClasses();
			System.out.println("Select an operation:");
			System.out.println("1: View My Classes");
			System.out.println("2: View All Classes");
			System.out.println("3: Add a Class");
			System.out.println("4: Drop a Class");
			System.out.println("5: Logout");
			operation = scan.nextInt();
			switch (operation) {
				case 1: // view my classes
					myClasses = m.getClasses();
					printMyClasses(classes, myClasses);
					break;

				case 2: // print all classes
					printAll(classes);
					break;

				case 5: // logout
					System.out.println("Thank you for your visit!");
					break;

				case 3: // add class
					/********* Write your code for add class here    *********/
					printAll(classes);
					System.out.println("enter code");
					String code = scan.next();
					m.addClass(code);
					break;

				case 4: // drop class
					/********* Write your code for drop class here    *********/
					myClasses = m.getClasses();
					printMyClasses(classes, myClasses);
					System.out.println("Enter the code of the class you want to drop");
					String codes = scan.next();

					m.removeClass(codes);

			}
		} while (operation != 5);
	}
	/**
	 * Method printAll the classes
	 * @param classes the list of classes
	 */
	public static void printAll(LinkedList < Class > classes) {
		System.out.printf("%-5s\t%-20s\t%-20s\t$%s\n", "Code", "Name", "Duration(minutes)", "Fees");
		Iterator < Class > iter = classes.iterator();
		while (iter.hasNext()) {
			Class c = iter.next();
			System.out.printf("%-5s\t%-20s\t%-20d\t$%-5.2f\n",
				c.getCode(), c.getName(), c.getTime(), c.getFees());
		}
	}
	/**
	 * Method printMyClasses
	 * @param classes the list of classes
	 * @param myClasses the list of the member classes to print
	 */
	public static void printMyClasses(LinkedList < Class > classes,
		ArrayList < String > myClasses) {
		System.out.printf("%-5s\t%-20s\t%-20s\t$%s\n", "Code", "Name", "Duration(minutes)", "Fees");
		Iterator < String > it = myClasses.iterator();
		while (it.hasNext()) {
			String code = it.next();
			Class c = classes.find(new Class(code, "", 0, 0.0, ""));
			System.out.printf("%-5s\t%-20s\t%-20d\t$%-5.2f\n",
				c.getCode(), c.getName(), c.getTime(), c.getFees());
		}
	}
	/**	
	 * Method adminOperations to print the Gym income and the classes ranked by popularity
	 * @param classes the list classes
	 * @param members the bst with all the Gym members
	 */
	public static void adminOperations(LinkedList < Class > classes, BST < Member > members) {
		printIncome(classes, members);
		sortClasses(classes, members);
	}
	/**
	 * Method printIncome to print the income from each member and the total income
	 * @param classes the list of classes
	 * @param bst the bst with all the Gym members
	 * time complexity: O(n^2)
	 */
	public static void printIncome(LinkedList < Class > classes, BST < Member > bst) {
		ArrayList < Member > arr = bst.toList();
		double total = 0.0;
		for (int i = 0; i < bst.size(); i++) {
			Member m = arr.get(i);
			double income = 0.0;
			for (int j = 0; j < m.getClasses().size(); j++) {
				String code = m.getClasses().get(j);
				Class c = classes.find(new Class(code, "", 0, 0.0, ""));
				income += c.getFees();
			}
			System.out.printf("%-10s\t$%-5.2f\n", m.getID(), income);
			total += income;
			
		}

		System.out.println(total);
	}
	/**
	 * Method sortClasses to print the list of classes ranked by popularity
	 * @param classes the list fo classes
	 * @param bst the BST with all the Gym members
	 * 
	 */


	public static void sortClasses(LinkedList < Class > classes, BST < Member > bst) {
		class ComparatorByMember implements Comparator < Class > {
			public int compare(Class c1, Class c2) {
				return c2.getMembers() - c1.getMembers();
			}
		}

		/********* Write your code for sortClasses here    *********/
		//The method should iterate through the bst members to find the members enrolled in each class and update the data member members for each class in the list classes
		
		ArrayList < Member > arr = bst.toList();
		for (int i = 0; i < bst.size(); i++) {
			Member m = arr.get(i);
			for (int j = 0; j < m.getClasses().size(); j++) {
				String code = m.getClasses().get(j);
				Class c = classes.find(new Class(code, "", 0, 0.0, ""));
				c.addMember();
			}

		}
		

Iterator < Class > iter = classes.iterator();


		classes.sort(new ComparatorByMember());

		/********* Print the sorted list here    *********/
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}
}