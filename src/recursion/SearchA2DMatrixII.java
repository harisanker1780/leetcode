package recursion;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 *
 */
public class SearchA2DMatrixII {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		int rStart = 0;
		int rEnd = matrix.length - 1;
		int cStart = 0;
		int cEnd = matrix[0].length - 1;
		
		return searchMatrix(matrix, target, rStart, rEnd, cStart, cEnd);
    }
	
	private boolean searchMatrix(int[][] matrix, int target, int rStart, int rEnd, int cStart, int cEnd) {
		
		int pr = (rStart + rEnd) / 2;
		int pc = (cStart + cEnd) / 2;
		
		if(matrix[pr][pc] == target) {
			return true;
		}
		
		if(rStart == rEnd && cStart == cEnd) {
			return false;
		}
		
		if(target < matrix[pr][pc]) {
			// LT, RT, LB
			return searchMatrix(matrix, target, rStart, pr, cStart, pc) || searchMatrix(matrix, target, rStart, pr, pc, cEnd)
					|| searchMatrix(matrix, target, pr, rEnd, cStart, pc);
		}
		else {
			// RB, RT, LB
			return searchMatrix(matrix, target, pr, rEnd, pc, cEnd) || searchMatrix(matrix, target, rStart, pr, pc, cEnd)
					|| searchMatrix(matrix, target, pr, rEnd, cStart, pc);
		}
	}
	
	public static void main(String[] args) {
		SearchA2DMatrixII sol = new SearchA2DMatrixII();
		int matrix[][] = {
				{1,   4,  7, 11, 15},
				{2,   5,  8, 12, 19},
				{3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
		};
		
		System.out.println(sol.searchMatrix(matrix, 20));
	}

}
