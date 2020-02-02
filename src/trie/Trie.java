package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */
public class Trie {
	
	private TrieNode root;
	
	/** Initialize your data structure here. */
    public Trie() {
    	root = new TrieNode(null);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	 if (word != null) {
    		char[] array = word.toCharArray();
         	TrieNode node = root;
         	for(char c : array) {
         		if(node.children.containsKey(c)) {
         			node = node.children.get(c);
         		} else {
         			return false;
         		}
         	}
         	
         	return node.isLeafNode;
    	 }
    	 
    	 return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	 if (prefix != null) {
     		char[] array = prefix.toCharArray();
          	TrieNode node = root;
          	for(char c : array) {
          		if(node.children.containsKey(c)) {
          			node = node.children.get(c);
          		} else {
          			return false;
          		}
          	}
          	
          	return true;
     	 }
     	 
     	 return false;
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
    	Trie trie = new Trie();

    	trie.insert("apple");
    	System.out.println(trie.search("apple"));   // returns true
    	System.out.println(trie.search("app"));     // returns false
    	System.out.println(trie.startsWith("app")); // returns true
    	trie.insert("app");   
    	System.out.println(trie.search("app"));     // returns true

	}
}
