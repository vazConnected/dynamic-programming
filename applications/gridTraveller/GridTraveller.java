import java.math.BigInteger;
import java.util.HashMap;

public final class GridTraveller {
	private HashMap<String, BigInteger> memoization;

	public BigInteger getGridTravellerResult(int length, int height) {
		this.memoization = new HashMap<String, BigInteger>();
		return this.gridTraveller(length, height);
	}

	public BigInteger gridTraveller(Integer length, Integer height) {
		if (height <= 0 || length <= 0) return BigInteger.valueOf(0L); // Invalid grid
		if (height == 1 && length == 1) return BigInteger.valueOf(1L); // Bottom-right reached

		String mapKeyStandard = length.toString() + "," + height.toString();
		String mapKeyReversed = height.toString() + "," + length.toString();

		if (this.memoization.containsKey(mapKeyStandard))
			return this.memoization.get(mapKeyStandard);

		BigInteger moveDownPaths = gridTraveller(length, (height - 1));
		BigInteger moveRightPaths = gridTraveller((length - 1), height);

		BigInteger possibilitiesDiscovered = moveRightPaths.add(moveDownPaths);

		// gridTraveller(length, height) = gridTraveller(height, length)
		this.memoization.put(mapKeyStandard, possibilitiesDiscovered);
		this.memoization.put(mapKeyReversed, possibilitiesDiscovered);
		
		return possibilitiesDiscovered;
	}
}
