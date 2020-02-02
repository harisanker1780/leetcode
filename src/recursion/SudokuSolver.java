package recursion;

/**
 * 
 *Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.
 */

public class SudokuSolver {
	
	public void solveSudoku(char[][] board) {
		
		int emptyCellCount = 0;
		
		char[][] copy = new char[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				copy[i][j] = board[i][j];
				if(board[i][j] == '.') {
					emptyCellCount++;
				}
			}
		}
		
		int[][] emptyCells = new int[emptyCellCount][2];
		int count = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board[i][j] == '.') {
					emptyCells[count][0] = i;
					emptyCells[count][1] = j;
					count++;
				}
			}
		}
		
		char[] values = { '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		solve(board, emptyCells, 0, values);
    }
	
	private void solve(char[][] board, int[][] emptyCells, int index, char[] values) {
		
		if(index == emptyCells.length)
			return;
		
		int i = emptyCells[index][0];
		int j = emptyCells[index][1];
		
		if(board[i][j] == '.') {
			for(int k = 0; k < 9; k++) {
				char v = values[k];
				if(isValidValue(board, i, j, v)) {
					board[i][j] = v;
					solve(board, emptyCells, index + 1, values);
				}
			}
		}
		
		if(board[i][j] == '.' && index > 0) {
			int iPrev = emptyCells[index - 1][0];
			int jPrev = emptyCells[index - 1][1];
			board[iPrev][jPrev] = '.';
		}
	}
	
	private boolean isValidValue(char[][] board, int i, int j, char val) {
		
		// Check Row
		for(int col = 0; col < 9; col++) {
			if(col != j && board[i][col] == val) {
				return false;
			}
		}
		
		// Check Column
		for(int row = 0; row < 9; row++) {
			if(row != i && board[row][j] == val) {
				return false;
			}
		}
			
		// Check Sub board.
		int rowStart = (i /3) * 3;
		int colStart = (j / 3) * 3;
		for(int row = rowStart; row < (rowStart + 3); row++) {
			for(int col = colStart; col < (colStart + 3); col++) {
				if(row != i && col != j && board[row][col] == val) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private void print(char[][] board) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + ", ");
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		SudokuSolver solver = new SudokuSolver();
		char[][] board = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
		
		solver.solveSudoku(board);
		
		solver.print(board);
		
	}

}
