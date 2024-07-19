public class Main {
    private static int[] getAmericanSoccerScores() {
        int FIELD_GOAL = 3;
        int TOUCHDOWN_SIMPLE = 6;
        int TOUCHDOWN_EXTRA_1 = TOUCHDOWN_SIMPLE + 1;
        int TOUCHDOWN_EXTRA_2 = TOUCHDOWN_SIMPLE + 2;

        return new int[] { FIELD_GOAL, TOUCHDOWN_SIMPLE, TOUCHDOWN_EXTRA_1, TOUCHDOWN_EXTRA_2 };
    }

    private static int[] getFootballCompetitionScores() {
        int VICTORY = 3;
        int DRAW = 1;

        return new int[] { VICTORY, DRAW };
    }

    private static int[] getBrazilianRealCoins() {
        return new int[] { 1, 5, 10, 25, 50, 100 };
    }

    public static void main(String[] args) {
        int coinsInCents = 243; // R$ 2.43
        Combinations brazilianCoins = new Combinations(Main.getBrazilianRealCoins());
        System.out.println("Possible combinations to get R$ " + ((float) coinsInCents / 100.0) + " using coins: "
                + brazilianCoins.getCombinations(coinsInCents));

        int teamScoreAmericanFootball = 15;
        Combinations americanSoccer = new Combinations(Main.getAmericanSoccerScores());
        System.out.println("Possible ways to score " + teamScoreAmericanFootball + " in a american football match: "
                + americanSoccer.getCombinations(teamScoreAmericanFootball));

        int teamScoreFootballCompetition = 62;
        Combinations footballCompatition = new Combinations(Main.getFootballCompetitionScores());
        System.out.println("Possible ways to score " + teamScoreFootballCompetition + " in a football competition: "
                + footballCompatition.getCombinations(teamScoreFootballCompetition));
    }
}
