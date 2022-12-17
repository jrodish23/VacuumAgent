//Name: Jarrad Self
//Class: CS3642
//Assignment 1
//Main method for vacuum reflex agent


import java.util.*;

public class StartVacuum {

	public static void main(String args[]) {
		
		random(); //calling the random() class 
	}
	
	public static void random(){
		Scanner scan = new Scanner(System.in);  
		
		System.out.print("Please enter a number for the floor width: "); // prompting user for the width of x 
		int x = scan.nextInt();

		System.out.print("Please enter a number for the floor height: ");// prompting user for height of y
		int y = scan.nextInt(); 
		
		AiVacuum vac = new AiVacuum(); //creating new Vacuum each time it runs
		new Grid(vac, x, y); // creating new x and y plane for vacuum
		scan.close();
	}


}