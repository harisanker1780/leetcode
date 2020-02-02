package hashtable;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	
	public boolean isValidSudoku(char[][] board) {
        
		if(board == null)
			return false;
		
		int ROW = board.length;
		int COLUMN = board[0].length;
		
		for(int i = 0; i < ROW; i++) {
			Set<Character> set = new HashSet<Character>();
			for(int j = 0; j < COLUMN; j++) {
				
				if(set.contains(board[i][j])) {
					return false;
				}
				
				if(board[i][j] != '.') {
					set.add(board[i][j]);
				}
			}
		}
		
		for(int j = 0; j < COLUMN; j++) {
			Set<Character> set = new HashSet<Character>();
			for(int i = 0; i < ROW; i++) {
				
				if(set.contains(board[i][j])) {
					return false;
				}
				
				if(board[i][j] != '.') {
					set.add(board[i][j]);
				}
			}
		}

		for(int i = 0; i < ROW; i = i + 3) {
			for(int j = 0; j < COLUMN; j = j + 3) {
				Set<Character> set = new HashSet<Character>();
				for(int k = i; k < i + 3; k++) {
					for(int l = j; l < j + 3; l++) {
						if(set.contains(board[k][l])) {
							return false;
						}
						
						if(board[k][l] != '.') {
							set.add(board[k][l]);
						}
					}
				}
			}
		}
		
	    return true; 
    }
	
	public static void main(String[] args) {
		ValidSudoku sol = new ValidSudoku();
		/*char[][] board = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
	            {'.','9','8','.','.','.','.','6','.'},
	            {'8','.','.','.','6','.','.','.','3'},
	            {'4','.','.','8','.','3','.','.','1'},
	            {'7','.','.','.','2','.','.','.','6'},
	            {'.','6','.','.','.','.','2','8','.'},
	            {'.','.','.','4','1','9','.','.','5'},
	            {'.','.','.','.','8','.','.','7','9'}
			};*/
		
		char[][] board = {
		                  {'8','3','.','.','7','.','.','.','.'},
		                  {'6','.','.','1','9','5','.','.','.'},
		                  {'.','9','8','.','.','.','.','6','.'},
		                  {'8','.','.','.','6','.','.','.','3'},
		                  {'4','.','.','8','.','3','.','.','1'},
		                  {'7','.','.','.','2','.','.','.','6'},
		                  {'.','6','.','.','.','.','2','8','.'},
		                  {'.','.','.','4','1','9','.','.','5'},
		                  {'.','.','.','.','8','.','.','7','9'}
		                };
		
	   System.out.println(sol.isValidSudoku(board));
	}
}
