package epi.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import meta.Problem;

public class EnumerateAllPrimes {
	
	@Problem(code = "6.8", name = "Enumerate all primes to n")
	public static List<Integer> generateAllPrimes(int n) {
		List<Integer> primes = new ArrayList<Integer>();
		List<Boolean> isPrime = new ArrayList<Boolean>(Collections.nCopies(n + 1, true));
		isPrime.set(0, false);
		isPrime.set(1, false);
		
		for(int i = 2; i <= n; i++) {
			if(isPrime.get(i)) {
				primes.add(i);
				for(int j = i; j <= n; j = j + i) {
					isPrime.set(j, false);
				}
			}
		}
		
		return primes;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(generateAllPrimes(18).toArray()));
	}

}
