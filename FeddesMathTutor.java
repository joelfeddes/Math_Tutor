//Joel Feddes
//This program is intended to test you on the most basic mathematical computations.

import java.util.Random;	//Import Random, need it for generating random nums
import java.util.Scanner;	//Need Scanner to harvest input from user

public class FeddesMathTutor {
	public static void printMenu() {
		System.out.println("Choose the type of problem:");
		System.out.println("1. Addition");
		System.out.println("2. Multiplication");
		System.out.println("3. Mixed");
		System.out.println("4. Quit");
	}
	public static void printResults(int correct, int problemCount) {
		System.out.printf("\nYou answered %d of %d correctly!\n", correct, problemCount);
		double percentageScore;
		percentageScore = ((double) correct/problemCount) * 100;	//Compute percentageScore
		System.out.printf("Your percentage score was %.2f.\n\n", percentageScore);
	}
	public static void printHeading() {
		System.out.println("\n********************************");
		System.out.println("     Electronic Math Tutor");
		System.out.println("********************************\n");
	}
	public static int runProblemSet(Scanner sc, Random rnd, int problemCount, int largestOperand, int choice) {
		int correct = 0;	//Initialize correct to 0
		int answer, num1, num2, response;
		String sign;
		int gen_random;
		for (int i = 1; i <= problemCount; i++) {	//Repeat problems until we reach how many the user indicated
			num1 = rnd.nextInt(largestOperand);		//Generate a number between 0 and the largest operand.
			num2 = rnd.nextInt(largestOperand);
			if (choice == 1) {	//Condition if the user wants to do addition
				sign = "+";
				answer = num1 + num2;
				
			} else if (choice == 2) {	//Condition if the user wants to do multiplication
				sign = "*";
				answer = num1 * num2;
			} else {					//Condition if the user wants to do a mix
				gen_random = rnd.nextInt(2);	//Generate a 0 and a 1
				if (gen_random == 0) {			//If the random num is 0, throw out an addition prob.
					sign = "+";
					answer = num1 + num2;
				} else {						//otherwise, throw the user a multiplication prob.
					sign = "*";
					answer = num1 * num2;
				} 
		}

		System.out.print(num1 + sign + num2 + "= ? ");
		response = sc.nextInt();
		if (response == answer) {	//If the user was right, tell them and add 1 to the correct count.
			correct = correct + 1;
			System.out.println("Correct!");
		} else {
			System.out.println("Incorrect! The answer is " + answer + ".");	//Otherwise, they were wrong. Tell them the right answer
		}
		}
		return correct;	//Return the total correct count.
	}
	
//Main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		printHeading();
		int choice, problemCount, largestOperand, correct;
		do {
			printMenu();
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			if (choice != 4) {	//As long as the user picks a number 1-3, run the program.
				System.out.print("How many problems? ");
				problemCount = sc.nextInt();
				System.out.print("Largest operand? ");
				largestOperand = sc.nextInt();
				System.out.println();
				correct = runProblemSet(sc,rnd,problemCount,largestOperand,choice);
				printResults(correct,problemCount);
				
			}
		} while (choice != 4);
	}

}
