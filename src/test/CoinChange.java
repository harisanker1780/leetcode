package test;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
 *
 */
public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		
		if(amount == 0)
			return 0;
		
        int minCount = -1;
        int[] counts = new int[amount];
        for(int i = 0; i < coins.length; i++) {
        	if(coins[i] <= amount) {
            	int count = coinChange(coins, amount - coins[i], counts);
            	if(count != -1) {
            		minCount = minCount != -1 ? Math.min(minCount, count) : count;
            	}
        	}
        }
        
        return minCount;
    }
	
	private int coinChange(int[] coins, int amount, int[] counts) {
		
		if(amount == 0) {
			return 1;
		}
		
		if(amount < 0) {
			return -1;
		}
		
		if(counts[amount] != 0)
			return counts[amount];
		
		int minCount = -1;
		for(int i = 0; i < coins.length; i++) {
			if(coins[i] <= amount) {
				int count = coinChange(coins, amount - coins[i], counts);
				if(count != -1) {
					minCount = minCount != -1 ? Math.min(minCount, count) : count;
				}
			}
		}
		
		counts[amount] = minCount != -1 ? 1 + minCount : 0;
		return minCount != -1 ? 1 + minCount : -1;
	}
	
	public static void main(String[] args) {
		CoinChange sol = new CoinChange();
		//int[] coins = {1, 2, 5};
		int[] coins = {186,419,83,408};
		System.out.println(sol.coinChange(coins, 6249));
	}
}
