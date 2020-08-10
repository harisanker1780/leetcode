package test;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 

Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
 *
 */
public class WordSearch {
	
	public boolean exist(char[][] board, String word) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		boolean wordFound = false;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				wordFound = exist(board, word.toCharArray(), visited, i, j, 0);
				
				if(wordFound) {
					break;
				}
			}
			
			if(wordFound) {
				break;
			}
		}
		
		return wordFound;
    }
	
	private boolean exist(char[][] board, char[] word, boolean[][] visited, int i, int j, int k) {
		
		if(k == word.length)
			return true;
		
		if(board[i][j] != word[k])
			return false;
		else if(k == word.length - 1)
			return true;
		
		boolean result = false;
		visited[i][j] = true;
		
		if(i < board.length - 1 && !visited[i + 1][j])
			result = result || exist(board, word, visited, i + 1, j, k + 1);
		
		if(i > 0 && !visited[i - 1][j])
			result = result || exist(board, word, visited, i - 1, j, k + 1);
		
		if(j < board[0].length - 1 && !visited[i][j + 1])
			result = result || exist(board, word, visited, i, j + 1, k + 1);
		
		if(j > 0 && !visited[i][j - 1])
			result = result || exist(board, word, visited, i, j - 1, k + 1);
		
		visited[i][j] = false;
		return result;
	}

	
	public static void main(String[] args) {
		WordSearch sol =  new WordSearch();
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		
		System.out.println(sol.exist(board, "ABCCED"));
		System.out.println(sol.exist(board, "SEE"));
		System.out.println(sol.exist(board, "ABCB"));
		
//		char[][] board = {
//				{'a'}
//		};
//		
//		System.out.println(sol.exist(board, "a"));
	}
}
