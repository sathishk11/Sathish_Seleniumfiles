package Simple_programs;

import java.util.Scanner;

public class sat1 {
	public void occurrence() {
		Scanner input = new Scanner(System.in); //reads input from the "System.in"
		System.out.print("Enter a string: ");
		String str = input.nextLine(); // read the string from the user input
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a' || str.charAt(i) == 'A') {
				count++;
			}
		}
		System.out.println("The occurrence of 'a' in the string is: " + count);
	}

	public static void main(String[] args) {
		sat1 object = new sat1();
		object.occurrence();
	}

}