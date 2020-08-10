package test;

/**
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28
 

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
 *
 */
public class UniquePath {

	public int uniquePaths(int m, int n) {
		int a[][] = new int[n][m];
		return uniquePath(m, n, a, 0, 0);
    }
	
	private int uniquePath(int m, int n, int a[][], int i, int j) {
		
		if(i == n - 1 && j == m - 1)
			return 1;
		
		if(a[i][j] != 0)
			return a[i][j];
		
		int pathCount = 0;
		if(i < n - 1)
			pathCount += uniquePath(m, n, a, i + 1, j);
		if(j < m - 1)
			pathCount += uniquePath(m, n, a, i, j + 1);
		
		a[i][j] = pathCount;
		return pathCount;
	}
	
	public static void main(String[] args) {
		UniquePath sol =  new UniquePath();
		System.out.println(sol.uniquePaths(0, 0));
	}
}
