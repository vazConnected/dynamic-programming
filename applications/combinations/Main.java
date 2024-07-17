import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static final int FIELD_GOAL = 3;
    private static final int TOUCHDOWN_SIMPLE = 6;
    private static final int TOUCHDOWN_EXTRA_1 = TOUCHDOWN_SIMPLE + 1;
    private static final int TOUCHDOWN_EXTRA_2 = TOUCHDOWN_SIMPLE + 2;

    private static final int[] americanSoccerScoreUnits = { FIELD_GOAL, TOUCHDOWN_SIMPLE, TOUCHDOWN_EXTRA_1,
            TOUCHDOWN_EXTRA_2 };

    private static int[] inputToMatchScore(String input) {
        int[] matchScore = new int[2];
        String[] inputScores = input.split("x");

        matchScore[0] = Integer.parseInt(inputScores[0]);
        matchScore[1] = Integer.parseInt(inputScores[1]);

        return matchScore;
    }

    private static int[] calculateCombinations(int[] matchScore) {
        Combinations combinationsTeamOne = new Combinations(americanSoccerScoreUnits, matchScore[0]);
        Combinations combinationsTeamTwo = new Combinations(americanSoccerScoreUnits, matchScore[1]);

        combinationsTeamOne.start();
        combinationsTeamTwo.start();

        try {
            combinationsTeamOne.join();
            combinationsTeamTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new int[] {
                combinationsTeamOne.getCombinations(),
                combinationsTeamTwo.getCombinations(),
                combinationsTeamOne.getCombinations() * combinationsTeamTwo.getCombinations()
        };
    }

    private static String getValidUserInput() {
        Pattern inputPattern = Pattern.compile("^\\d*x\\d*$"); // Match pattern: AxB
        String input = "";

        Scanner scanner = new Scanner(System.in);

        boolean validEntry = false;
        do {
            System.out.print("\nType a American Soccer match score (example: XxY): ");
            input = scanner.nextLine();

            if (!inputPattern.matcher(input).matches()) {
                System.err.println("Invalid entry. Press 'Enter' and type valid match score (AxB)");
                scanner.nextLine(); // clear buffer
            } else {
                validEntry = true;
            }
        } while (!validEntry);
        scanner.close();

        return input;
    }

    public static void main(String[] args) {
        String userInput = getValidUserInput();
        int[] matchScore = inputToMatchScore(userInput);

        int[] combinations = Main.calculateCombinations(matchScore);

        System.out.println("\n\nCombinations for team one (" + matchScore[0] + "): "
                + combinations[0]);
        System.out.println("Combinations for team two (" + matchScore[1] + "): "
                + combinations[1]);
        System.out.println("Match score combinations (" + matchScore[0] + "x" + matchScore[1] + "): "
                + (combinations[2]));
    }
}
