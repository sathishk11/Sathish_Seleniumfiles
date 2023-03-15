 package Simple_programs;

import java.util.Scanner;

public class Add_integer {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in); 
		//we create a new Scanner object called scanner, which reads input from the "System.in" stream (i.e.,from the console).

		System.out.print("Enter a integer: ");
		int  userinput = input.nextInt(); 
		//read the user's input using the "input.nextInt()" method. We store the number of integers in the "userinput" variable.

		int[] integers = new int[userinput];
		//We then create an array called integers with "userinput" elements.

		int total =0;

		for (int i=0; i<userinput; i++) {
			System.out.println("Enter integer #" + (i+1) + ": ");
			integers[i] = input.nextInt();    //We store the i-th integer in the integers[i] element of the array.
		}	

		System.out.println("Entered integers are : ");
		for (int i=0; i<userinput; i++) {
			System.out.println(integers[i]);
			total+=integers[i];
		}	
		System.out.println("total:"+total);
	}

}
