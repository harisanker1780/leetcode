package recursion;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:
Input: 2.00000, 10
Output: 1024.00000

Example 2:
Input: 2.10000, 3
Output: 9.26100

Example 3:
Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 */
public class Pow {
	
	public double myPow(double x, int n) {
        
		if(n == 0)
			return 1;
		
		if(n == 1)
			return x;
		
		double r = x * myPow(x, Math.abs(n) - 1);
		
		return n > 0 ? r : 1 / r;
    }
	
	public double myPow1(double x, int n) {
		
		if(n == 0)
			return 1;
		
		if(n == 1)
			return x;
		
		double r = myPow(x,  Math.abs(n), 1, 1);
		return n > 0 ? r : 1 / r;
	}
	
	private double myPow(double x, int n, int start, double r) {
		
		if(start > n)
			return r;
		
		return myPow(x, n, start + 1, r * x);
	}
	
	public static void main(String[] args) {
		Pow sol = new Pow();
		System.out.println(sol.myPow1(0.00001, 2147483647));
	}

}
