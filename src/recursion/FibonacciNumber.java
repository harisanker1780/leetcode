package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, 
 * called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * 
 * F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
 *
 */
public class FibonacciNumber {
	
	Map<Integer, Integer> cache = new HashMap<>();
	
	public int fib(int N) {
        
		if(cache.containsKey(N)) {
			return cache.get(N);
		}
		
		if(N < 2) {
			return N;
		}
		else {
			int r = fib(N - 1) + fib(N - 2);
			cache.put(N, r);
			
			return r;
		}
    }
	
	public static void main(String[] args) {
		FibonacciNumber sol = new FibonacciNumber();
		System.out.println(sol.fib(4));
	}

}
