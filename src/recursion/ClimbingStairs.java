package recursion;

/**
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 *
 */
public class ClimbingStairs {
	
    public int climbStairs(int n) {
    	int cache[] = new int[n + 1];
    	return climbStairs(0, n, cache);
        
    }
    
    private int climbStairs(int i, int n, int[] cache) {
    	
    	if(i > n)
    		return 0;
    	
    	if(i == n)
    		return 1;
    	
    	if(cache[i] > 0)
    		return cache[i];
    	
    	cache[i] = climbStairs(i + 1, n, cache) + climbStairs(i +  2, n, cache);
    	return cache[i];
    }
    
    public static void main(String[] args) {
    	ClimbingStairs sol = new ClimbingStairs();
    	System.out.println(sol.climbStairs(44));
	}

}
