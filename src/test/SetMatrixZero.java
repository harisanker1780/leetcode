package test;

/**
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 *
 */
public class SetMatrixZero {
	
	public void setZeroes(int[][] matrix) {
		
		if(matrix != null) {
			boolean isFirstRowZero = false;
	        boolean isFirstColumnZero = false;
	        
	        int M = matrix.length;
	        int N = matrix[0].length;
	        
	        for(int i = 0; i < M; i++) {
	        	for(int j = 0; j < N; j++) {
	        		if(matrix[i][j] == 0) {
	        			matrix[i][0] = 0;
	        			matrix[0][j] = 0;
	        			
	        			if(i == 0)
	        				isFirstRowZero = true;
	        			if(j == 0)
	        				isFirstColumnZero = true;
	        		}
	        	}
	        }
	        
	        for(int i = 1; i < M; i++) {
	        	if(matrix[i][0] == 0) {
	        		for(int j = 0; j < N; j++) {
	        			matrix[i][j] = 0;
	        		}
	        	}
	        }
	        
	        for(int j = 1; j < N; j++) {
	        	if(matrix[0][j] == 0) {
	        		for(int i = 0; i < M; i++) { 
	        			matrix[i][j] = 0;
	        		}
	        	}
	        }
	        
	        if(isFirstRowZero) {
	        	for(int j = 0; j < N; j++) {
	        		matrix[0][j] = 0;
	        	}
	        }
	        
	        if(isFirstColumnZero) {
	        	for(int i = 0; i < M; i++) {
	        		matrix[i][0] = 0;
	        	}
	        }
		}
    }
	
	public static void main(String[] args) {
		SetMatrixZero sol = new SetMatrixZero();
		int matrix[][] = {
				{0,1,2,0},
				{3,4,5,2},
				{1,3,1,5}
		};
		sol.setZeroes(matrix);
	}
}
