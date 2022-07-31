import java.math.BigInteger;
import java.util.HashMap;

public final class Fibonacci {
	private HashMap<Integer, BigInteger> memoization;
	
	public BigInteger getFibonacciValue(Integer index) {
		this.memoization = new HashMap<Integer, BigInteger>();
		return this.fibonacci(index);
	}
	
	private BigInteger fibonacci(Integer index) {
		if (index < 1) 
			return BigInteger.valueOf(0);
			
		if (index == 1 || index == 2) 
			return BigInteger.valueOf(1);
		
		if (memoization.containsKey(index))
			return this.memoization.get(index);
		
		BigInteger fibMinusOne = this.fibonacci(index - 1);
		BigInteger fibMinusTwo = this.fibonacci(index - 2);

		BigInteger fibonacciValue = fibMinusOne.add(fibMinusTwo);
		this.memoization.put(index, fibonacciValue);

		return fibonacciValue;
	}
}
