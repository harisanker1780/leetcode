package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
Given a 2D board and a list of words from the dictionary, find all words in the board.
Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input: board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]

Note:
1. All inputs are consist of lowercase letters a-z.
2. The values of words are distinct.
 *
 */
public class WordSearchII {
	
	 private TrieNode root;
	 
	 public WordSearchII() {
		 root = new TrieNode(null);
	 }

	 public List<String> findWords(char[][] board, String[] words) {
		 
		 Set<String> result = new HashSet<>();
		 
		 if(board != null && words != null) {
			 
			 int N = board.length;
			 
			 if(N > 0  && words.length > 0) {
				 int M = board[0].length;
		    	 boolean[][] visited = new boolean[N][M];
				 
				 // Insert words into the trie.
			     for(String word : words) {
			    	 insert(word);
			     }
		    	 
		    	 for(int i = 0; i < N; i++) {
		    		 for(int j = 0; j < M; j++) {
		    			 findWords(board, i, j, result, visited, root);
		    		 }
		    	 }
			 }
		 }
    	 
    	 return new ArrayList<String>(result);
	 }
	 
	 public void findWords(char[][] board, int i, int j, Set<String> result, boolean[][] visited, TrieNode node) {
		 
		 if(isValidPosition(board, i, j)) {
			 
			 visited[i][j] = true;
			 
			 char c = board[i][j];
			 if(node.children.containsKey(c)) {
				 TrieNode child = node.children.get(c);
				 if(child != null) {
					 if(child.isLeafNode) {
						 result.add(buildWord(child));
					 }
					 
					 if(isValidPosition(board, i + 1, j) && !visited[i + 1][j]) {
						 findWords(board, i + 1, j, result, visited, child);
					 }
					 
					 if(isValidPosition(board, i, j + 1) && !visited[i][j + 1]) {
						 findWords(board, i, j + 1, result, visited, child);
					 }
					 
					 if(isValidPosition(board, i - 1, j) && !visited[i - 1][j]) {
						 findWords(board, i - 1, j, result, visited, child);
					 }
					 
					 if(isValidPosition(board, i, j - 1) && !visited[i][j - 1]) {
						 findWords(board, i, j - 1, result, visited, child);
					 }
				 }
			 }
			 
			 visited[i][j] = false;
		 }
	 }
	 
	 // Build the word from child to parent node
	 private String buildWord(TrieNode node) {
		 StringBuilder builder = new StringBuilder();
		 while(node != null) {
			 Character c = node.c;
			 if(c != null) {
				 builder.append(c);
			 }
			 
			 node = node.parent;
		 }
		 
		 return builder.reverse().toString();
	 }
	 
	 /** Inserts a word into the trie. */
     private void insert(String word) {
        if(word != null) {
        	word = word.trim();
        	if(word.length() > 0) {
        		char[] array = word.toCharArray();
            	TrieNode node = root;
            	for(char c : array) {
            		if(node.children.containsKey(c)) {
            			node = node.children.get(c);
            		} else {
            			TrieNode child = new TrieNode(c);
            			node.children.put(c, child);
            			child.parent = node;
            			node = child;
            		}
            	}
            	
            	node.isLeafNode = true;
        	}
        }
     }
     
     private boolean isValidPosition(char[][] board, int i, int j) {
    	 int N = board.length;
    	 int M = board[0].length;
    	 return i >= 0 && i < N && j >= 0 && j < M;
     }
	 
	 class TrieNode {
	    	public Character c;
	    	public boolean isLeafNode;
	        public Map<Character, TrieNode> children = new HashMap<>();
	        public TrieNode parent;
	        
	        public TrieNode(Character c) {
	        	this.c = c;
	        }
	 };
	 
	 
	 public static void main(String[] args) {
		 WordSearchII sol = new WordSearchII();
		 char[][] board = {
				 {'o','a','a','n'},
				 {'e','t','a','e'},
				 {'i','h','k','r'},
				 {'i','f','l','v'}
		 };
		 String[] words = {"oath","pea","eat","rain"}; // Output: ["eat", "oath"]
//		 char[][] board = {
//				 {'a'},
//		 };
//		 String[] words = {"a"};
		 
//		 char[][] board = {
//				 {'a','b'},
//				 {'c','d'},
//		 };
//		 String[] words = {"abcd", "acdb"}; // Output: ["acdb"]
//		 String[] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"}; // Output: ["ab","ac","bd","ca","db"]
		 List<String> result = sol.findWords(board, words);
		 for(String s : result) {
			 System.out.println(s);
		 }
	 }
}
