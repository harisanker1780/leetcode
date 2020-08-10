package test;

/**
 * 
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
        
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		
		return search(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }
	
	private boolean search(int[][] matrix, int target, int rowStart, int rowEnd, int colStart, int colEnd) {
		
		if(rowStart > rowEnd || colStart > colEnd)
			return false;
		
		int rowMid = (rowStart + rowEnd) / 2;
		int colMid = (colStart + colEnd) / 2;
		
		if(matrix[rowMid][colMid] == target)
			return true;
		
		if(target > matrix[rowMid][colMid]) {
			if(search(matrix, target, rowStart, rowMid, colMid + 1, colEnd))
				return true;
			if(search(matrix, target, rowMid + 1, rowEnd, colMid + 1, colEnd))
				return true;
			if(search(matrix, target, rowMid + 1, rowEnd, colStart, colMid))
				return true;
		} else {
			if(search(matrix, target, rowMid, rowEnd, colStart, colMid - 1))
				return true;
			if(search(matrix, target, rowStart, rowMid - 1, colStart, colMid - 1))
				return true;
			if(search(matrix, target, rowStart, rowMid - 1, colMid, colEnd))
				return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		SearchA2DMatrixII sol = new SearchA2DMatrixII();
		int[][] input = {
				 {1,   4,  7, 11, 15},
				 {2,   5,  8, 12, 19},
				 {3,   6,  9, 16, 22},
				 {10, 13, 14, 17, 24},
				 {18, 21, 23, 26, 30}
		};
		
		System.out.println(sol.searchMatrix(input, 1));
		System.out.println(sol.searchMatrix(input, 30));
		System.out.println(sol.searchMatrix(input, 15));
		System.out.println(sol.searchMatrix(input, 18));
		System.out.println(sol.searchMatrix(input, 17));
		System.out.println(sol.searchMatrix(input, 9));
		System.out.println(sol.searchMatrix(input, 12));
		
	}
}
