package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:

Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]
 *
 */
public class PalindromePairs {
	
	private TrieNode root;
	
	public PalindromePairs() {
		root = new TrieNode(null);
	}

	public List<List<Integer>> palindromePairs(String[] words) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for(int k = 0; k < words.length; k++) {
			String word = words[k];
			insert(word, k);
		}
		
		for(int k = 0; k < words.length; k++) {
			String word = words[k];
			if(word.length() > 0) {
				char[] chars = word.toCharArray();
				TrieNode node = root;
				for(int i = chars.length - 1; i >= 0; i--) {
					char c = chars[i];
					if(node.children.containsKey(c)) {
						node = node.children.get(c);
						if(node.index != null && k != node.index) {
							char[] other = buildWord(node).toCharArray();
							
							if(isPalindrome(chars, other)) {
								List<Integer> pair = buildPair(k, node.index);
								result.add(pair);
							} 
							
							if(isPalindrome(other, chars)) {
								List<Integer> pair = buildPair(node.index, k);
								result.add(pair);
							}
						}
					} else {
						break;
					}
				}
			} else {
				for(int i = 0; i < words.length; i++) {
					if(i != k) {
						char[] chars = words[i].toCharArray();
						char[] empty = new char[0];
						if(isPalindrome(chars, empty)) {
							List<Integer> pair1 = buildPair(i, k);
							result.add(pair1);
							List<Integer> pair2 = buildPair(k, i);
							result.add(pair2);
						}
					}
				}
			}
		}
		
        return result;
    }
	
    /** Inserts a word into the trie. */
    private void insert(String word, int index) {
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
            	
            	node.index = index;
        	}
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
 	
 	private boolean isPalindrome(char[] w1, char[] w2) {
 		int i = 0;
 		int j = w2.length - 1;
 		boolean iReset = false, jReset = false;
 		int N = w1.length + w2.length;
 		for(int k = 0; k < N; k = k + 2) {
 			char a = ' ', b = ' ';
 			if(i < w1.length && !iReset) {
 				a = w1[i++];
 			} else {
 				if(i == w1.length && !iReset) {
 					i = 0;
 					iReset = true;
 				}
 				
 				a = w2[i++];
 			}
 			
 			if(j >= 0 && !jReset) {
 				b = w2[j--];
 			} else {
 				if(j < 0 && !jReset) {
 					j = w1.length - 1;
 					jReset = true;
 				}
 				
 				b = w1[j--];
 			}
 			
 			if(a != b) {
 				return false;
 			}
 		}
 	
 		return true;
 	}
 	
 	
 	private List<Integer> buildPair(Integer n1, Integer n2) {
 		List<Integer> pair = new ArrayList<>();
 		pair.add(n1);
 		pair.add(n2);
 		return pair;
 	}
	

    class TrieNode {
    	public Character c;
    	public Integer index;
    	public TrieNode parent;
        public Map<Character, TrieNode> children = new HashMap<>();
        
        public TrieNode(Character c) {
        	this.c = c;
        }
    };
    
    public static void main(String[] args) {
    	PalindromePairs sol = new PalindromePairs();
//    	String s1 = "a";
//    	String s2 = "aa";
//    	System.out.println(sol.isPalindrome(s1.toCharArray(), s2.toCharArray()));
    	//String[] input = {"abcd","dcba","lls","s","sssll"}; // Output: [[0,1],[1,0],[3,2],[2,4]] 
    	//String[] input = {"lls","s", ""};
    	//String[] input = {"bat","tab","cat"}; // Output: [[0,1],[1,0]] 
    	//String[] input = {"a",""}; // Output: [[0, 1], [1, 0]]
    	//String[] input = {"a","abc","aba",""};
    	String[] input = {"a","b","c","ab","ac","aa"}; // Output: [[3,0],[1,3],[4,0],[2,4],[5,0],[0,5]]
    	List<List<Integer>> output = sol.palindromePairs(input);
    	
    	for(List<Integer> i : output) {
    		System.out.println("[" + i.get(0) + ", " + i.get(1) +"]");
    	}
    	
	}
}
