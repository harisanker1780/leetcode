package trie;

import java.util.HashMap;
import java.util.Map;


/**
 * Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z. 
 *
 */
public class WordDictionary {
	
	private TrieNode root;

	/** Initialize your data structure here. */
    public WordDictionary() {
    	root = new TrieNode(null);
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
            			node = child;
            		}
            	}
            	
            	node.isLeafNode = true;
        	}
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	 if (word != null) {
     		char[] array = word.toCharArray();
     		return seach(root, array);
     	 }
     	 
     	 return false;
    }
    
    private boolean seach(TrieNode node, char[] array) {
    	for(int i = 0; i < array.length; i++) {
    		char c = array[i];
    		if(c == '.') {
    			if(node.children.size() > 0) {
    				if(array.length == 1) {
    					for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                     		if(entry.getValue().isLeafNode) {
                     			return true;
                     		}
                     	}
    					
    					return false;
    				} else {
    					char[] array1 = new char[(array.length - 1) - i];
            			int k = 0;
            			for(int j = i + 1; j < array.length; j++) {
            				array1[k++] = array[j];
            			}
            			
            			for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                     		if(seach(entry.getValue(), array1)) {
                     			return true;
                     		}
                     	}
            			
            			return false;
    				}
    			} else {
    				return false;
    			}
    		} else if(node.children.containsKey(c)) {
      			node = node.children.get(c);
      		} else {
      			return false;
      		}
    	}
    	
		return node.isLeafNode;
	}

	class TrieNode {
    	public Character c;
    	public boolean isLeafNode;
        public Map<Character, TrieNode> children = new HashMap<>();
        
        public TrieNode(Character c) {
        	this.c = c;
        }
    };
    
    public static void main(String[] args) {
    	WordDictionary sol = new WordDictionary();
    	sol.addWord("bad");
    	sol.addWord("dad");
    	sol.addWord("mad");
    	System.out.println(sol.search("pad"));
    	System.out.println(sol.search("bad"));
    	System.out.println(sol.search(".ad"));
    	System.out.println(sol.search("b.."));
    	System.out.println(sol.search(".."));
    	System.out.println(sol.search("..q"));
    	System.out.println(sol.search("...."));
    	System.out.println(sol.search(""));
    	System.out.println(sol.search(null));
	}
}
