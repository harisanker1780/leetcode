package test;

public class NumberOfWaysRepresentingCoins {

	public static void main(String[] args) {
		int[] coins = {25, 10, 5, 1};
		int n = 20;
		
		int[] cache = new int[coins.length];
		for(int i = 0; i < cache.length; i++) {
			cache[i] = -1;
		}
		
		System.out.println(numOfWays(n, coins, 0, cache));
	}
	
	private static int numOfWays(int n, int[] coins, int start, int[] cache) {
		
		if(cache[start] != -1) {
			return cache[start];
		}
		
		if(n < 0) {
			return 0;
		}
		
		if(n == 0) {
			return 1;
		}
		
		int count = 0;
		for(int i = start; i < coins.length; i++) {
			int coin = coins[i];
			int c = numOfWays(n - coin, coins, i, cache);
			count += c;
		}
		
		cache[start] = count;
		
		return count;
	}
}
