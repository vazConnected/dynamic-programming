import java.util.Arrays;

public class Combinations extends Thread {
    private int[] combinationsUnits;
    private int targetScore;
    private int combinations;

    public Combinations(int[] combinationsUnits, int targetScore) {
        this.combinations = -1;
        this.targetScore = targetScore;
        this.combinationsUnits = combinationsUnits;
        Arrays.sort(this.combinationsUnits);
    }

    public int getCombinations() {
        if (this.combinations == -1) {
            throw new IllegalStateException("Combinations not calculated yet");
        }

        return this.combinations;
    }

    @Override
    public void run() {
        this.combinations = -1;

        int allPossibleScores = this.targetScore + 1; // from 0 to targetScore
        int[] combinationsTracker = new int[allPossibleScores];

        combinationsTracker[0] = 1; // Only one possible way to score 0

        for (int combinationUnit : this.combinationsUnits) {
            for (int currentTarget = 0; currentTarget < combinationsTracker.length; currentTarget++) {
                boolean combinationUnitFitsInCurrentTarget = (combinationUnit <= currentTarget);

                if (combinationUnitFitsInCurrentTarget) {
                    int lastTargetScoreThatFitsTheCurrentCombinationUnit = currentTarget - combinationUnit;
                    combinationsTracker[currentTarget] += combinationsTracker[lastTargetScoreThatFitsTheCurrentCombinationUnit];
                }
            }
        }

        this.combinations = combinationsTracker[this.targetScore];
    }
}