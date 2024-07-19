import java.util.Arrays;

public class Combinations {
    private int[] combinationsUnits;

    public Combinations(int[] combinationsUnits) {
        this.combinationsUnits = combinationsUnits;
        Arrays.sort(this.combinationsUnits);
    }

    public int getCombinations(int targetValue) {
        int[] memoization = new int[targetValue + 1]; // from 0 to targetScore
        memoization[0] = 1; // Only one possible way for value = 0

        for (int combinationUnit : this.combinationsUnits) {
            for (int currentTargetValue = 0; currentTargetValue < memoization.length; currentTargetValue++) {
                boolean combinationUnitFitsInCurrentTargetValue = (combinationUnit <= currentTargetValue);

                if (combinationUnitFitsInCurrentTargetValue) {
                    int lastValueThatFitsTheCurrentCombinationUnit = currentTargetValue - combinationUnit;
                    memoization[currentTargetValue] += memoization[lastValueThatFitsTheCurrentCombinationUnit];
                }
            }
        }

        return memoization[targetValue];
    }
}