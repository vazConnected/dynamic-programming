import java.math.BigInteger;
import java.util.Scanner;

public final class Main {
	private static void printGridTravellerStats(int length, int height) {
		GridTraveller gridTraveller = new GridTraveller();
				
		long beginning = System.currentTimeMillis();
		BigInteger value = gridTraveller.getGridTravellerResult(length, height);
		long ending = System.currentTimeMillis();
		
		Long timeSpent = ending - beginning;
		
		System.out.println("    Grid Traveller Problem");
		System.out.println("    - (length, height): (" + length + ", " + height + ")");
		System.out.println("    - Possibilities: " + value.toString());
		System.out.println("    - Time spent: " + timeSpent.toString() + " ms");
	}
	
	public static void main(String[] args) {
		System.out.println("Grid Traveller calculator");
		
		Scanner scanner = new Scanner(System.in);
		boolean shouldContinue = true;
		int length = 0, height = 0;
		
		do {
			shouldContinue = true;
			length = -1;
			height = -1;
			
			System.out.println("\nEnter the heigth and length (set both params as 0 to exit).");
			try {
				System.out.print("> length: ");
				length = scanner.nextInt();
				
				System.out.print("> heigth: ");
				height = scanner.nextInt();
				
				if (length == 0 && height == 0) shouldContinue = false;
			} catch (Exception ex) {
				System.err.println("NaN or the number is too big.");
				scanner.next();
				shouldContinue = false;
			}

			if (shouldContinue) Main.printGridTravellerStats(length, height);
		} while (length != 0 || height != 0);

		scanner.close();
		System.out.println("\nEnd.");
	}
}
