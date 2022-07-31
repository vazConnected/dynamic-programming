import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	private static void printFibonacci(int index) {
		Fibonacci fibonacciCalculator = new Fibonacci();
		
		long beginning = System.currentTimeMillis();
		BigInteger value = fibonacciCalculator.getFibonacciValue(index);
		long ending = System.currentTimeMillis();
		
		Long timeSpent = ending - beginning;
		
		System.out.println("    Fibonacci of " + index + ":");
		System.out.println("    - Value: " + value.toString());
		System.out.println("    - Time spent: " + timeSpent.toString() + " ms");
	}
	
	public static void main(String[] args) {
		System.out.println("Fibonacci calculator");
		boolean shouldContinue;
		int index;
		Scanner scanner = new Scanner(System.in);
		
		do {
			index = -1;
			shouldContinue = true;
			
			System.out.println("\nEnter the fibonacci sequence index to be calculated (type 0 to exit).");
			System.out.print("> index: ");

			try {
				index = scanner.nextInt();
				
				if (index < 1) shouldContinue = false;
			} catch (Exception ex) {
				System.err.println("NaN or the number is too big.");
				scanner.next();
				shouldContinue = false;
			}

			if (shouldContinue) {
				if (index < 0) index = Math.abs(index);
			 
				try {
					printFibonacci(index);
				} catch (Exception ex) {
					System.err.println("Not enough hardware resources.");
				}
			}
		} while (index != 0);

		scanner.close();
		System.out.println("\nProgram successfully closed.");
	}

}
